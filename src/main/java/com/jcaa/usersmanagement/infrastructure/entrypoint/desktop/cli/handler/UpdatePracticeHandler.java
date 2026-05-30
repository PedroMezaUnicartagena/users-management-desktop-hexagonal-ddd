package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.exception.PracticeNotFoundException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.PracticeResponsePrinter;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.PracticeController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdatePracticeRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UpdatePracticeHandler implements OperationHandler {

    private final PracticeController practiceController;
    private final ConsoleIO console;
    private final PracticeResponsePrinter printer;

    @Override
    public void handle() {
        final String id = console.readRequired("id: ");
        final String title = console.readRequired("new title: ");
        final String difficulty = console.readRequired("difficulty (can be LOW, MEDIUM or HIGH): ");
        final String type = console.readRequired("type (can be INDIVIDUAL or GROUP): ");

        try {
            final var updated = practiceController.updatePractice(
                    new UpdatePracticeRequest(id, title, difficulty, type));
            console.println("\n  practice updated successfully.");
            printer.print(updated);
        } catch (final PracticeNotFoundException exception) {
            console.println("  error: " + exception.getMessage());
        }
    }
}
