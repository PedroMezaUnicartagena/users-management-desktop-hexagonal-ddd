package com.jcaa.usersmanagement.application.port.out;

import com.jcaa.usersmanagement.domain.model.PracticeModel;

import java.util.List;

public interface GetAllPracticesPort {
    List<PracticeModel> getAll();
}
