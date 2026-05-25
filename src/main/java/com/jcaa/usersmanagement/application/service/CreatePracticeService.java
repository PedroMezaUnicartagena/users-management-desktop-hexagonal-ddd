package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.CreatePracticeUseCase;
import com.jcaa.usersmanagement.application.port.out.GetPracticeByIdPort;
import com.jcaa.usersmanagement.application.port.out.SavePracticePort;
import com.jcaa.usersmanagement.application.service.dto.command.CreatePracticeCommand;
import com.jcaa.usersmanagement.application.service.mapper.PracticeApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.PracticeAlreadyExistsException;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.util.Set;

@Log
@RequiredArgsConstructor
public class CreatePracticeService implements CreatePracticeUseCase {

    private final SavePracticePort savePracticePort;
    private final GetPracticeByIdPort getPracticeByIdPort;
    Validator validator;

    @Override
    public PracticeModel execute(CreatePracticeCommand command) {
        validateCommand(command);

        final PracticeId practiceId = new PracticeId(command.practiceId());
        ensurePracticeDoesNotExist(practiceId);

        final PracticeModel practiceToSave = PracticeApplicationMapper.fromCreateCommandToModel(command);
        return savePracticePort.save(practiceToSave);
    }

    private void validateCommand(final CreatePracticeCommand command) {
        final Set<ConstraintViolation<CreatePracticeCommand>> violations =
                validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    private void ensurePracticeDoesNotExist(final PracticeId practiceId) {
        getPracticeByIdPort
                .getById(practiceId)
                .ifPresent(ignored -> {
                    throw PracticeAlreadyExistsException.becauseIdAlreadyExists(practiceId.value());
                });
    }
}
