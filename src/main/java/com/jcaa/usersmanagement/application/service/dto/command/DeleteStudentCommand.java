package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;

public record DeleteStudentCommand(
        @NotBlank(message = "student id must not be blank") String studentId
) {}
