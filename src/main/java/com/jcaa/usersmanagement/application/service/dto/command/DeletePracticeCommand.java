package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;

public record DeletePracticeCommand(
        @NotBlank(message = "Practice id must not be null.") String practiceId
) {
}
