package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.PracticeModel;

import java.util.List;

public interface GetAllPracticesUseCase {
    List<PracticeModel> execute();
}
