package com.jcaa.usersmanagement.domain.exception;

public class InvalidDifficultyLevel extends DomainException{
    private static final String MESSAGE_INVALID = "The difficulty level '%s' is not valid.";

    public InvalidDifficultyLevel(final String message){
        super(message);
    }

    public static InvalidDifficultyLevel becauseValueIsInvalid(final String difficultyLevel){
        return new InvalidDifficultyLevel(String.format(MESSAGE_INVALID, difficultyLevel));
    }
}
