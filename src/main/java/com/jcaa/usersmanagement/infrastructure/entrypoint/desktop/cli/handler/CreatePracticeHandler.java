package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.exception.PracticeAlreadyExistsException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.PracticeResponsePrinter;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.PracticeController;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreatePracticeRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class CreatePracticeHandler implements OperationHandler {

    private final PracticeController practiceController;
    private final ConsoleIO console;
    private final PracticeResponsePrinter printer;

    @Override
    public void handle() {
        final String id = console.readRequired("id: ");
        final String title = console.readRequired("title: ");
        final String difficulty = console.readRequired("difficulty ( can be LOW, MEDIUM or HIGH): ");
        final String type = console.readRequired("type ( can be INDIVIDUAL or GROUP): ");

        try {
            final var created = practiceController.createPractice(
                    new CreatePracticeRequest(id, title, difficulty, type));
            console.println("\n  practice created successfully.");
            printer.print(created);
        } catch (final PracticeAlreadyExistsException exception) {
            console.println("error: " + exception.getMessage());
        }
    }
}