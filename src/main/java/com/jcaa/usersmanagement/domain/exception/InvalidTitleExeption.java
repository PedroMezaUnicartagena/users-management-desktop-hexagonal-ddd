package com.jcaa.usersmanagement.domain.exception;

public class InvalidTitleExeption extends DomainException{
    private static final String MESSAGE_EMPTY = "The title must not be empty.";

    public InvalidTitleExeption(final String message){super(message);}

    public static InvalidTitleExeption becauseValueIsEmpty(){
        return new InvalidTitleExeption(MESSAGE_EMPTY);
    }
}
