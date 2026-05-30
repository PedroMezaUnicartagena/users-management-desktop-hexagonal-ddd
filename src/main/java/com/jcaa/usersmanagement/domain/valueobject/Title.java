package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidTitleExeption;

import java.util.Objects;

public record Title(String value) {
    public Title{
        final String normalizedValue = Objects.requireNonNull(value, "Title cannot be null").trim();
        ValidateNotEmpty(normalizedValue);
        value = normalizedValue;
    }

    public static void ValidateNotEmpty(final String normalizedValue){
        if (normalizedValue.isEmpty()) {
            throw InvalidTitleExeption.becauseValueIsEmpty();
        }
    }
}
