package com.jcaa.usersmanagement.domain.model;


import com.jcaa.usersmanagement.domain.enums.DifficultyLevel;
import com.jcaa.usersmanagement.domain.enums.PracticeType;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import com.jcaa.usersmanagement.domain.valueobject.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PracticeModel {

    private PracticeId practiceId;
    private Title title;
    private DifficultyLevel difficultyLevel;
    private PracticeType practiceType;

    public static PracticeModel create(
            String practiceId,
            String title,
            String difficultyLevel,
            String practiceType
    ) {
        return new PracticeModel(
                new PracticeId(practiceId),
                new Title(title),
                DifficultyLevel.fromString(difficultyLevel),
                PracticeType.fromString(practiceType)
        );
    }

    public void updateTitle(String title) {
        this.title = new Title(title);
    }

    public void updateDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel =
                DifficultyLevel.fromString(difficultyLevel);
    }

    public void updatePracticeType(String practiceType) {
        this.practiceType =
                PracticeType.fromString(practiceType);
    }
}