package com.jcaa.usersmanagement.application.service.dto.query;

import jakarta.validation.constraints.NotBlank;

public record GetPracticeByIdQuery(
        @NotBlank(message = "The practice id must not be blank.") String practiceId
) {
}
