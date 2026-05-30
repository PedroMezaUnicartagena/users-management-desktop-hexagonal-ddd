package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto;

public record PracticeResponse(
        String practiceId,
        String title,
        String difficultyLevel,
        String practiceType
) {}