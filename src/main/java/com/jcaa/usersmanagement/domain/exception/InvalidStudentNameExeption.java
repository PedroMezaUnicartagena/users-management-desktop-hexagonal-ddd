package com.jcaa.usersmanagement.domain.exception;

public class InvalidStudentNameExeption extends DomainException {
    private static final String MESSAGE_EMPTY = "The student name must not be empty.";

    public InvalidStudentNameExeption(final String message){super(message);}

    public static InvalidStudentNameExeption becauseValueIsEmpty(){
        return new InvalidStudentNameExeption(MESSAGE_EMPTY);
    }

}
