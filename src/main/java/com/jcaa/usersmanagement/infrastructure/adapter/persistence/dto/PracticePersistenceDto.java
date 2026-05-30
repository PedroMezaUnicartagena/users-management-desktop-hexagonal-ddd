package com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto;

import com.jcaa.usersmanagement.domain.enums.DifficultyLevel;
import com.jcaa.usersmanagement.domain.enums.PracticeType;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import com.jcaa.usersmanagement.domain.valueobject.Title;

public record PracticePersistenceDto(
        String practiceId,
        String title,
        String difficultyLevel,
        String practiceType,
        String createdAt,
        String updatedAt
) {

}
