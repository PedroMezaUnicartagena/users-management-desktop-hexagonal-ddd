package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.domain.exception.PracticeNotFoundException;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.ConsoleIO;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.PracticeResponsePrinter;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.PracticeController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class FindPracticeByIdHandler implements OperationHandler {

    private final PracticeController practiceController;
    private final ConsoleIO console;
    private final PracticeResponsePrinter printer;

    @Override
    public void handle() {
        final String id = console.readRequired("practice id: ");
        try {
            printer.print(practiceController.findPracticeById(id));
        } catch (final PracticeNotFoundException exception) {
            console.println("  Not found: " + exception.getMessage());
        }
    }
}