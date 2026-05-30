package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.application.service.dto.command.UpdatePracticeCommand;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public interface UpdatePracticeUseCase {
    PracticeModel execute(@NotNull @Valid UpdatePracticeCommand command);
}
