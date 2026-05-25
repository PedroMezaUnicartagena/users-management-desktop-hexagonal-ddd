package com.jcaa.usersmanagement.application.port.in;


import com.jcaa.usersmanagement.application.service.dto.query.GetPracticeByIdQuery;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface GetPracticeByIdUseCase {
    PracticeModel getById(@NotNull @Valid GetPracticeByIdQuery query);
}
