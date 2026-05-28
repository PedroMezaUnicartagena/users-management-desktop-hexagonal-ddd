package com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper;

import com.jcaa.usersmanagement.domain.enums.DifficultyLevel;
import com.jcaa.usersmanagement.domain.enums.PracticeType;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import com.jcaa.usersmanagement.domain.valueobject.*;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto.PracticePersistenceDto;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.entity.PracticeEntity;
import lombok.experimental.UtilityClass;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class PracticePersistencyMapper {

    public PracticePersistenceDto fromModelToDto(final PracticeModel practice) {
        return new PracticePersistenceDto(
                practice.getPracticeId().value(),
                practice.getTitle().value(),
                practice.getDifficultyLevel().name(),
                practice.getPracticeType().name(),
                null,
                null
        );
    }

    public PracticeEntity fromResultSetToEntity(final ResultSet resultSet) throws SQLException {
        return new PracticeEntity(
                resultSet.getString("practice_id"),
                resultSet.getString("title"),
                resultSet.getString("difficulty_level"),
                resultSet.getString("practice_type"),
                resultSet.getString("created_at"),
                resultSet.getString("updated_at")
        );
    }

    public PracticeModel fromEntityToModel(final PracticeEntity entity) {
        return new PracticeModel(
                new PracticeId(entity.practiceId()),
                new Title(entity.title()),
                DifficultyLevel.fromString(entity.difficultyLevel()),
                PracticeType.fromString(entity.practiceType())
        );
    }

    public PracticeModel fromResultSetToModel(final ResultSet resultSet) throws SQLException {
        return fromEntityToModel(fromResultSetToEntity(resultSet));
    }

    public List<PracticeModel> fromResultSetToModelList(final ResultSet resultSet) throws SQLException {
        final List<PracticeModel> practices = new ArrayList<>();
        while (resultSet.next()) {
            practices.add(fromResultSetToModel(resultSet));
        }
        return practices;
    }
}
