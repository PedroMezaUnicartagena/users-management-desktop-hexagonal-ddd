package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;

public record UpdatePracticeCommand(
        @NotBlank(message = "practice id must not be blank") String practiceId,
        @NotBlank(message = "title must not be blank") String title,
        @NotBlank(message = "difficulty level must not be blank") String difficultyLevel,
        @NotBlank(message = "practice type must not be blank") String practiceType) {
}
