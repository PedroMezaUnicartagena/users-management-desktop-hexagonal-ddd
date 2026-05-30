package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.StudentModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.jcaa.usersmanagement.application.service.dto.query.GetStudentByIdQuery;

public interface GetByIdStudentUseCase {
    StudentModel execute(@NotNull @Valid GetStudentByIdQuery query);
}
