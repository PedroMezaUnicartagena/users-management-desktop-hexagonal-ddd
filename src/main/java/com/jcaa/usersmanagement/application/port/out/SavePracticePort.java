package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.PracticeModel;

public interface SavePracticePort {
    PracticeModel save(PracticeModel practice);
}
