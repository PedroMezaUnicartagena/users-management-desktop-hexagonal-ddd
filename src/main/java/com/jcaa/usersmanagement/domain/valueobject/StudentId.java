package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidStudentIdException;
import com.jcaa.usersmanagement.domain.exception.InvalidUserIdException;

import java.util.Objects;

public record StudentId(String value) {

    public StudentId{
        final String normalizedValue = Objects.requireNonNull(value, "student id cannot be null").trim();
        validateNotEmpty(normalizedValue);
        value = normalizedValue;
    }

    private static void validateNotEmpty(final String normalizedValue) {
        if (normalizedValue.isEmpty()) {
            throw InvalidStudentIdException.becauseValueIsEmpty();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
