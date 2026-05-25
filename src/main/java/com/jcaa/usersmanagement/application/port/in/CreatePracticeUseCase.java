package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.CreatePracticeCommand;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface CreatePracticeUseCase {
    PracticeModel execute(@NotNull @Valid CreatePracticeCommand command);
}
