package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.handler;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io.PracticeResponsePrinter;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller.PracticeController;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class ListPracticesHandler implements OperationHandler {

    private final PracticeController practiceController;
    private final PracticeResponsePrinter printer;

    @Override
    public void handle() {
        printer.printList(practiceController.listAllPractices());
    }
}
