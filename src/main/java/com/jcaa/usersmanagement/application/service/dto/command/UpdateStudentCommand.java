package com.jcaa.usersmanagement.application.service.dto.command;

import jakarta.validation.constraints.NotBlank;

public record UpdateStudentCommand(
        @NotBlank(message = "student id must not be blank") String studentId,
        @NotBlank(message = "name must not be blank")      String name,
        @NotBlank(message = "group must not be blank")     String group
) {}
