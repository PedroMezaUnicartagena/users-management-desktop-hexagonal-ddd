package com.jcaa.usersmanagement.domain.exception;


public final class InvalidPracticeIdException extends DomainException {

    private static final String MESSAGE_EMPTY = "The practice id must not be empty.";

    private InvalidPracticeIdException(final String message) {
        super(message);
    }

    public static InvalidPracticeIdException becauseValueIsEmpty() {
        return new InvalidPracticeIdException(MESSAGE_EMPTY);
    }
}
