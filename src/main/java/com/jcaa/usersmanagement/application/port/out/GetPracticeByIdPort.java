package com.jcaa.usersmanagement.application.port.out;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import com.jcaa.usersmanagement.domain.valueobject.PracticeId;


import java.util.Optional;

public interface GetPracticeByIdPort {
    Optional<PracticeModel> getById(PracticeId practiceId);
}
