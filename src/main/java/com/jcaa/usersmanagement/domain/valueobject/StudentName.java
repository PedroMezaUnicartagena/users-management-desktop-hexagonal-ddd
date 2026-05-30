package com.jcaa.usersmanagement.domain.valueobject;

import com.jcaa.usersmanagement.domain.exception.InvalidStudentNameExeption;

import java.util.Objects;

public record StudentName(String value){

    public StudentName{
        final String normalizedValue = Objects.requireNonNull(value, "Student name cannot be null").trim();
        ValidateNotEmpty(normalizedValue);
        value = normalizedValue;
    }

    public static void ValidateNotEmpty(final String normalizedValue){
        if (normalizedValue.isEmpty()) {
            throw InvalidStudentNameExeption.becauseValueIsEmpty();
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
