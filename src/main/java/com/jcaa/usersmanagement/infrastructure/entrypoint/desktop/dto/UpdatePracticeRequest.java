package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto;

public record UpdatePracticeRequest(
        String practiceId,
        String title,
        String difficultyLevel,
        String practiceType
) {

}