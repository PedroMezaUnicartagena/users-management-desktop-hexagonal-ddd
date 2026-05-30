package com.jcaa.usersmanagement.application.service.dto.query;

import jakarta.validation.constraints.NotBlank;

public record GetStudentByIdQuery(
        @NotBlank(message = "student id must not be blank") String studentId
) {}
