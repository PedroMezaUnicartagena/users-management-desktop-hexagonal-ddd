package com.jcaa.usersmanagement.domain.exception;

public class InvalidPracticeTypeException extends DomainException{
    private static final String MESSAGE_INVSLID = "the parctice type %s is not valid.";

    public InvalidPracticeTypeException(final String message){super(message);}

    public static InvalidPracticeTypeException becauseValueIsInvalid(final String practiceType){
        return new InvalidPracticeTypeException(String.format(MESSAGE_INVSLID,practiceType));
    }
}
