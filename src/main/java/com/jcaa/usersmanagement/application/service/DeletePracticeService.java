package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.DeletePracticeUseCase;
import com.jcaa.usersmanagement.application.port.out.DeletePracticePort;
import com.jcaa.usersmanagement.application.port.out.GetPracticeByIdPort;
import com.jcaa.usersmanagement.application.service.dto.command.DeletePracticeCommand;
import com.jcaa.usersmanagement.application.service.mapper.PracticeApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.PracticeNotFoundException;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;

import java.util.Set;

@AllArgsConstructor
public class DeletePracticeService implements DeletePracticeUseCase {

    private final DeletePracticePort deletePracticePort;
    private final GetPracticeByIdPort getPracticeByIdPort;
    private final Validator validator;

    @Override
    public void execute(DeletePracticeCommand command) {
        validateCommand(command);

        final PracticeId practiceId = PracticeApplicationMapper.fromDeleteCommandToPracticeId(command);
        ensurePracticeExists(practiceId);

        deletePracticePort.delete(practiceId);
    }

    private void validateCommand(final DeletePracticeCommand command) {
        final Set<ConstraintViolation<DeletePracticeCommand>> violations = validator.validate(command);
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
