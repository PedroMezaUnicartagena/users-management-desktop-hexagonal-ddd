package com.jcaa.usersmanagement.domain.model;


import com.jcaa.usersmanagement.domain.enums.DifficultyLevel;
import com.jcaa.usersmanagement.domain.enums.PracticeType;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import com.jcaa.usersmanagement.domain.valueobject.Title;
import lombok.Value;

@Value
public class PracticeModel {

    private PracticeId practiceId;
    private Title title;
    private DifficultyLevel difficultyLevel;
    private PracticeType practiceType;

    public static PracticeModel create(
            PracticeId practiceId,
            Title title,
            DifficultyLevel difficultyLevel,
            PracticeType practiceType
    ) {
        return new PracticeModel(
                practiceId,
                title,
                difficultyLevel,
                practiceType
        );
    }

    public PracticeModel withTitle(final Title newTitle) {
        return new PracticeModel(practiceId, newTitle, difficultyLevel, practiceType);
    }

    public PracticeModel withDifficultyLevel(final DifficultyLevel newLevel) {
        return new PracticeModel(practiceId, title, newLevel, practiceType);
    }

    public PracticeModel withPracticeType(final PracticeType newType) {
        return new PracticeModel(practiceId, title, difficultyLevel, newType);
    }
}