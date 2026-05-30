package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.exception.PracticeNotFoundException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.PracticeController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class DeletePracticeHandler implements OperationHandler {

    private final PracticeController practiceController;
    private final ConsoleIO console;

    @Override
    public void handle() {
        final String id = console.readRequired("insert practice id to delete: ");
        try {
            practiceController.deletePractice(id);
            console.println(" practice deleted successfully.");
        } catch (final PracticeNotFoundException exception) {
            console.println(" error: " + exception.getMessage());
        }
    }
}
