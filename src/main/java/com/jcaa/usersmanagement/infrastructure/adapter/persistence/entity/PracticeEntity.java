package com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity;

public record PracticeEntity(
        String practiceId,
        String title,
        String difficultyLevel,
        String practiceType,
        String createdAt,
        String updatedAt
) {
}
