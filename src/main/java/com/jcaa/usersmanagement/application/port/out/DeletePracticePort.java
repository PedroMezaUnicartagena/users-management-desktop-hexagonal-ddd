package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.valueobject.PracticeId;

public interface DeletePracticePort {
    void delete(PracticeId practiceId);
}
