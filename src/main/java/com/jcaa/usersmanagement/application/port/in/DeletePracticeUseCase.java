package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.DeletePracticeCommand;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface DeletePracticeUseCase {
    void execute(@NotNull @Valid DeletePracticeCommand command);
}
