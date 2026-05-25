package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.UpdatePracticeUseCase;
import com.jcaa.usersmanagement.application.port.out.GetPracticeByIdPort;
import com.jcaa.usersmanagement.application.port.out.UpdatePracticePort;
import com.jcaa.usersmanagement.application.service.dto.command.UpdatePracticeCommand;
import com.jcaa.usersmanagement.application.service.mapper.PracticeApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.PracticeNotFoundException;
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
public class UpdatePracticeService implements UpdatePracticeUseCase {

    private final UpdatePracticePort updatePracticePort;
    private final GetPracticeByIdPort getPracticeByIdPort;
    private final Validator validator;

    @Override
    public PracticeModel execute(final UpdatePracticeCommand command) {
        validateCommand(command);

        final PracticeId practiceId = new PracticeId(command.practiceId());
        ensurePracticeExists(practiceId);

        final PracticeModel practiceToUpdate = PracticeApplicationMapper.fromUpdateCommandToModel(command);

        return updatePracticePort.update(practiceToUpdate);

    }

    private void validateCommand(final UpdatePracticeCommand command){
        final Set<ConstraintViolation<UpdatePracticeCommand>> violations = validator.validate(command);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    private void ensurePracticeExists(final PracticeId practiceId) {
        getPracticeByIdPort
                .getById(practiceId)
                .orElseThrow(() ->
                        PracticeNotFoundException.becauseIdWasNotFound(practiceId.value()));
    }
}
