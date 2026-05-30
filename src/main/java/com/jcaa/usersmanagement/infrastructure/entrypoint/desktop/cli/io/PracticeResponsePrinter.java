package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.cli.io;

import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.PracticeResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class PracticeResponsePrinter {
    private static final String SEPARATOR  = "-".repeat(52);
    private static final String ROW_FORMAT = "  %-18s : %s%n";
    private final ConsoleIO console;

    public void print(final PracticeResponse response) {
        console.println(SEPARATOR);
        console.printf(ROW_FORMAT, "id", response.practiceId());
        console.printf(ROW_FORMAT, "title", response.title());
        console.printf(ROW_FORMAT, "difficulty", response.difficultyLevel());
        console.printf(ROW_FORMAT, "type", response.practiceType());
        console.println(SEPARATOR);
    }

    public void printList(final List<PracticeResponse> practices) {
        if (practices.isEmpty()) {
            console.println("no practices found.");
            return;
        }
        console.printf("%n  Total: %d practice(s)%n", practices.size());
        practices.forEach(this::print);
    }
}