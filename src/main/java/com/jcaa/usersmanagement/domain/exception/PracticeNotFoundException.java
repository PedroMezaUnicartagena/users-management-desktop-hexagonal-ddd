package com.jcaa.usersmanagement.domain.exception;

public class PracticeNotFoundException extends DomainException{
    private static final String MESSAGE_BY_ID = "The practice with id '%s' was not found.";

    private PracticeNotFoundException(final String message) {
        super(message);
    }

    public static PracticeNotFoundException becauseIdWasNotFound(final String userId) {
        return new PracticeNotFoundException(String.format(MESSAGE_BY_ID, userId));
    }
}
