package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.CreateStudentCommand;
import com.jcaa.usersmanagement.domain.model.StudentModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface CreateStudentUseCase {
    StudentModel execute(@NotNull @Valid CreateStudentCommand command);
}
