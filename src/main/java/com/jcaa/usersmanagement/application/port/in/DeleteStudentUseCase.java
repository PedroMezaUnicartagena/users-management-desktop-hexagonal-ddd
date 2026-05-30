package com.jcaa.usersmanagement.application.port.in;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteStudentCommand;

public interface DeleteStudentUseCase {
    void execute(@NotNull @Valid DeleteStudentCommand command);
}
