package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidStudentGroupExeption;

import java.util.Objects;

public record StudentGroup (String value){

    public StudentGroup{
        final String normalizedValue = Objects.requireNonNull(value, "student group cannot be null").trim();
        ValidateNotEmpty(normalizedValue);
        value = normalizedValue;
    }

    public static void ValidateNotEmpty(final String normalizedValue){
        if (normalizedValue.isEmpty()) {
            throw InvalidStudentGroupExeption.becauseValueIsEmpty();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
