package com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.mapper;

import com.jcaa.usersmanagement.application.service.dto.command.CreatePracticeCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeletePracticeCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdatePracticeCommand;
import com.jcaa.usersmanagement.application.service.dto.query.GetPracticeByIdQuery;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.CreatePracticeRequest;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.PracticeResponse;
import com.jcaa.usersmanagement.infrastructure.entrypoint.desktop.dto.UpdatePracticeRequest;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public final class PracticeDesktopMapper {
    public CreatePracticeCommand toCreateCommand(final CreatePracticeRequest request) {
        return new CreatePracticeCommand(
                request.practiceId(),
                request.title(),
                request.difficultyLevel(),
                request.practiceType()
        );
    }

    public UpdatePracticeCommand toUpdateCommand(final UpdatePracticeRequest request) {
        return new UpdatePracticeCommand(
                request.practiceId(),
                request.title(),
                request.difficultyLevel(),
                request.practiceType()
        );
    }

    public DeletePracticeCommand toDeleteCommand(final String practiceId) {
        return new DeletePracticeCommand(practiceId);
    }

    public GetPracticeByIdQuery toGetByIdQuery(final String practiceId) {
        return new GetPracticeByIdQuery(practiceId);
    }

    public PracticeResponse toResponse(final PracticeModel practice) {
        return new PracticeResponse(
                practice.getPracticeId().value(),
                practice.getTitle().value(),
                practice.getDifficultyLevel().name(),
                practice.getPracticeType().name()
        );
    }

    public  List<PracticeResponse> toResponseList(final List<PracticeModel> practices) {
        return practices.stream().map(PracticeDesktopMapper::toResponse).toList();
    }
}
