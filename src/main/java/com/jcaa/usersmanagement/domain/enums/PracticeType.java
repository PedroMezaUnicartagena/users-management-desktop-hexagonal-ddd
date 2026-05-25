package com.jcaa.usersmanagement.domain.enums;

import com.jcaa.usersmanagement.domain.exception.InvalidPracticeTypeException;

public enum PracticeType {
    INDIVIDUAL,
    GROUP;

    public static PracticeType fromString(final String value) {
        for (final PracticeType practiceType : values()) {
            if (practiceType.name().equalsIgnoreCase(value)) {
                return practiceType;
            }
        }
        throw InvalidPracticeTypeException.becauseValueIsInvalid(value);
    }
}