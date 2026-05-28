package com.jcaa.usersmanagement.infrastructure.adapter.persistence.repository;

import com.jcaa.usersmanagement.application.port.out.*;
import com.jcaa.usersmanagement.domain.exception.PracticeNotFoundException;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.dto.PracticePersistenceDto;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.exception.PracticePersistenceException;
import com.jcaa.usersmanagement.infrastructure.adapter.persistence.mapper.PracticePersistencyMapper;
import lombok.RequiredArgsConstructor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PracticeRepositoryMySQL  implements
        SavePracticePort,
        UpdatePracticePort,
        DeletePracticePort,
        GetAllPracticesPort,
        GetPracticeByIdPort
{
    private final Connection connection;

    private static final String SQL_INSERT =
            "INSERT INTO practices (practice_id, title, difficulty_level, practice_type, created_at, updated_at) " +
                    "VALUES (?, ?, ?, ?, NOW(), NOW()";

    private static final String SQL_UPDATE =
            "UPDATE practices SET title = ?, difficulty_level = ?, practice_type = ?, updated_at= NOW()" +
                    "WHERE practice_id = ?";

    private static final String SQL_SELECT_BY_ID =
            "SELECT practice_id, title, difficulty_level, practice_type, created_at, updated_at " +
                    "FROM practices " +
                    "WHERE practice_id = ? LIMIT 1";

    private static final String SQL_SELECT_ALL =
            "SELECT practice_id, title, difficulty_level, practice_type , created_at, updated_at" +
                    "FROM practices " +
                    "ORDER BY title ASC";

    private static final String SQL_DELETE =
            "DELETE FROM practices "
                    + "WHERE practice_id = ?";





    @Override
    public PracticeModel save(final PracticeModel practice) {
        final PracticePersistenceDto dto = PracticePersistencyMapper.fromModelToDto(practice);
        executeSave(dto);
        return findByIdOrFail(practice.getPracticeId());
    }

    @Override
    public PracticeModel update(final PracticeModel practice) {
        final PracticePersistenceDto dto = PracticePersistencyMapper.fromModelToDto(practice);
        executeUpdate(dto);
        return findByIdOrFail(practice.getPracticeId());
    }

    @Override
    public Optional<PracticeModel> getById(final PracticeId practiceId) {
        try (final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID)) {
            statement.setString(1, practiceId.value());
            final ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return Optional.empty();
            }
            return Optional.of(PracticePersistencyMapper.fromResultSetToModel(resultSet));
        } catch (final SQLException exception) {
            throw PracticePersistenceException.becauseFindByIdFailed(practiceId.value(), exception);
        }
    }

    @Override
    public List<PracticeModel> getAll() {
        try (final PreparedStatement statement = connection.prepareStatement(SQL_SELECT_ALL)) {
            final ResultSet resultSet = statement.executeQuery();
            return PracticePersistencyMapper.fromResultSetToModelList(resultSet);
        } catch (final SQLException exception) {
            throw PracticePersistenceException.becauseFindAllFailed(exception);
        }
    }

    @Override
    public void delete(final PracticeId practiceId) {
        try (final PreparedStatement statement = connection.prepareStatement(SQL_DELETE)) {
            statement.setString(1, practiceId.value());
            statement.executeUpdate();
        } catch (final SQLException exception) {
            throw PracticePersistenceException.becauseDeleteFailed(practiceId.value(), exception);
        }
    }

    private void executeSave(final PracticePersistenceDto dto) {
        try (final PreparedStatement statement = connection.prepareStatement(SQL_INSERT)) {
            statement.setString(1, dto.practiceId());
            statement.setString(2, dto.title());
            statement.setString(3, dto.difficultyLevel());
            statement.setString(4, dto.practiceType());
            statement.executeUpdate();
        } catch (final SQLException exception) {
            throw PracticePersistenceException.becauseSaveFailed(dto.practiceId(), exception);
        }
    }

    private void executeUpdate(final PracticePersistenceDto dto) {
        try (final PreparedStatement statement = connection.prepareStatement(SQL_UPDATE)) {
            statement.setString(1, dto.title());
            statement.setString(2, dto.difficultyLevel());
            statement.setString(3, dto.practiceType());
            statement.setString(4, dto.practiceId());
            statement.executeUpdate();
        } catch (final SQLException exception) {
            throw PracticePersistenceException.becauseUpdateFailed(dto.practiceId(), exception);
        }
    }

    private PracticeModel findByIdOrFail(final PracticeId practiceId) {
        return getById(practiceId)
                .orElseThrow(() ->
                        PracticeNotFoundException.becauseIdWasNotFound(practiceId.value()));
    }
}
