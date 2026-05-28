package com.jcaa.usersmanagement.infrastructure.adapter.persistence.exception;

public class PracticePersistenceException extends RuntimeException {

    private static final String MESSAGE_SAVE       = "Failed to save practice with practice id: '%s'.";
    private static final String MESSAGE_UPDATE     = "Failed to update practice with practice id: '%s'.";
    private static final String MESSAGE_FIND       = "Failed to find practice with practice id: '%s'.";
    private static final String MESSAGE_ALL        = "Failed to retrieve all practices";
    private static final String MESSAGE_DELETE     = "Failed to delete practice with practice id: '%s'.";
    private static final String MESSAGE_CONNECTION = "Could not establish database connection";




    private PracticePersistenceException(final String message, final Throwable cause) {
        super(message, cause);
    }


    public static PracticePersistenceException becauseSaveFailed(final String id, final Throwable cause) {
        return new PracticePersistenceException(String.format(MESSAGE_SAVE, id), cause);
    }


    public static PracticePersistenceException becauseUpdateFailed(final String id, final Throwable cause) {
        return new PracticePersistenceException(String.format(MESSAGE_UPDATE, id), cause);
    }


    public static PracticePersistenceException becauseFindByIdFailed(final String id, final Throwable cause) {
        return new PracticePersistenceException(String.format(MESSAGE_FIND, id), cause);
    }


    public static PracticePersistenceException becauseFindAllFailed(final Throwable cause) {
        return new PracticePersistenceException(MESSAGE_ALL, cause);
    }


    public static PracticePersistenceException becauseDeleteFailed(final String id, final Throwable cause) {
        return new PracticePersistenceException(String.format(MESSAGE_DELETE, id), cause);
    }


    public static PracticePersistenceException becauseConnectionFailed(final Throwable cause) {
        return new PracticePersistenceException(MESSAGE_CONNECTION, cause);
    }


}