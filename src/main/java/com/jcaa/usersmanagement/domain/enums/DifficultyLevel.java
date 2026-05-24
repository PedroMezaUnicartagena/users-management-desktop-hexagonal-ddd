package com.jcaa.usersmanagement.domain.enums;

import com.jcaa.usersmanagement.domain.exception.InvalidDifficultyLevel;

public enum DifficultyLevel {
    LOW,
    MEDIUM,
    HIGH;

    public static DifficultyLevel fromString(final String value){
        for (final DifficultyLevel difficultyLevel : values()) {
            if (difficultyLevel.name().equalsIgnoreCase(value)) {
                return difficultyLevel;
            }
        }
        throw InvalidDifficultyLevel.becauseValueIsInvalid(value);
    }
}

