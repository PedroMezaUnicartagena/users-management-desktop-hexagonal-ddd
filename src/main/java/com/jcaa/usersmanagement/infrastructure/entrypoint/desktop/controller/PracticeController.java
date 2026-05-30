package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.controller;


import com.jcaa.usersmanagement.application.port.in.*;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreatePracticeRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.PracticeResponse;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdatePracticeRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.mapper.PracticeDesktopMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public final class PracticeController {

    private final CreatePracticeUseCase createPracticeUseCase;
    private final UpdatePracticeUseCase updatePracticeUseCase;
    private final DeletePracticeUseCase deletePracticeUseCase;
    private final GetPracticeByIdUseCase getPracticeByIdUseCase;
    private final GetAllPracticesUseCase getAllPracticesUseCase;

    public List<PracticeResponse> listAllPractices() {
        final var practices = getAllPracticesUseCase.execute();
        return PracticeDesktopMapper.toResponseList(practices);
    }

    public PracticeResponse findPracticeById(final String practiceId) {
        final var query = PracticeDesktopMapper.toGetByIdQuery(practiceId);
        final var practice = getPracticeByIdUseCase.execute(query);
        return PracticeDesktopMapper.toResponse(practice);
    }

    public PracticeResponse createPractice(final CreatePracticeRequest request) {
        final var command = PracticeDesktopMapper.toCreateCommand(request);
        final var practice = createPracticeUseCase.execute(command);
        return PracticeDesktopMapper.toResponse(practice);
    }

    public PracticeResponse updatePractice(final UpdatePracticeRequest request) {
        final var command = PracticeDesktopMapper.toUpdateCommand(request);
        final var practice = updatePracticeUseCase.execute(command);
        return PracticeDesktopMapper.toResponse(practice);
    }

    public void deletePractice(final String practiceId) {
        final var command = PracticeDesktopMapper.toDeleteCommand(practiceId);
        deletePracticeUseCase.execute(command);
    }
}