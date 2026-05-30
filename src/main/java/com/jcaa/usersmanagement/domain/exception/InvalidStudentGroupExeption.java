package com.jcaa.usersmanagement.domain.exception;

public class InvalidStudentGroupExeption extends DomainException{
    private static final String MESSAGE_EMPTY = "The student group must not be empty.";

    public InvalidStudentGroupExeption(final String message){super(message);}

    public static InvalidStudentGroupExeption becauseValueIsEmpty(){
        return new InvalidStudentGroupExeption(MESSAGE_EMPTY);
    }
}
