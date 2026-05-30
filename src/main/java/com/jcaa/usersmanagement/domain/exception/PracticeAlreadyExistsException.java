package com.jcaa.usersmanagement.domain.exception;

public class PracticeAlreadyExistsException extends DomainException{
    private final static String MESSAGE_PRACTICE_EXISTS = "A practice with id '%s' already exists.";

    public PracticeAlreadyExistsException(final String message){super(message);}

    public static PracticeAlreadyExistsException becauseIdAlreadyExists(final String practiceId){
        return new PracticeAlreadyExistsException(String.format(MESSAGE_PRACTICE_EXISTS,practiceId));
    }
}
