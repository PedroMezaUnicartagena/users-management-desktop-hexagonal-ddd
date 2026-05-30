package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetPracticeByIdUseCase;
import com.jcaa.usersmanagement.application.port.out.GetPracticeByIdPort;
import com.jcaa.usersmanagement.application.service.dto.query.GetPracticeByIdQuery;
import com.jcaa.usersmanagement.application.service.mapper.PracticeApplicationMapper;
import com.jcaa.usersmanagement.domain.exception.PracticeNotFoundException;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class GetPracticeByIdService implements GetPracticeByIdUseCase {
    private final GetPracticeByIdPort getPracticeByIdPort;
    private final Validator validator;

    @Override
    public PracticeModel execute(GetPracticeByIdQuery query) {
        validateQuery(query);

        final PracticeId practiceId = PracticeApplicationMapper.fromGetPracticeByIdQueryToPracticeId(query);

        return getPracticeByIdPort
                .getById(practiceId)
                .orElseThrow(() -> PracticeNotFoundException.becauseIdWasNotFound(practiceId.value()));
    }

    private void validateQuery(final GetPracticeByIdQuery query) {
        final Set<ConstraintViolation<GetPracticeByIdQuery>> violations = validator.validate(query);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
