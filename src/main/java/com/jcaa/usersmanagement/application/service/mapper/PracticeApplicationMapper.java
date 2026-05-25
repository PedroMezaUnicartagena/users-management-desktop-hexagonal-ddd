package com.jcaa.usersmanagement.application.service.mapper;

import com.jcaa.usersmanagement.application.service.dto.command.CreatePracticeCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeletePracticeCommand;
import com.jcaa.usersmanagement.application.service.dto.command.DeleteUserCommand;
import com.jcaa.usersmanagement.application.service.dto.command.UpdatePracticeCommand;
import com.jcaa.usersmanagement.domain.enums.DifficultyLevel;
import com.jcaa.usersmanagement.domain.enums.PracticeType;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import com.jcaa.usersmanagement.domain.valueobject.Title;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PracticeApplicationMapper {
    public PracticeModel fromCreateCommandToModel(final CreatePracticeCommand command){
        return PracticeModel.create(
                new PracticeId(command.practiceId()),
                new Title(command.title()),
                DifficultyLevel.fromString(command.difficultyLevel()),
                PracticeType.fromString(command.practiceType())
        );
    }

   public PracticeModel fromUpdateCommandToModel(UpdatePracticeCommand command){
        return PracticeModel.create(
                new PracticeId(command.practiceId()),
                new Title(command.title()),
                DifficultyLevel.fromString(command.difficultyLevel()),
                PracticeType.fromString(command.practiceType())
        );
   }

   public PracticeId fromDeleteCommandToPracticeId(DeletePracticeCommand command){
        return new PracticeId(command.practiceId());
    }
}
