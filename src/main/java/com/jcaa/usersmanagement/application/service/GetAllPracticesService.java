package com.jcaa.usersmanagement.application.service;

import com.jcaa.usersmanagement.application.port.in.GetAllPracticesUseCase;
import com.jcaa.usersmanagement.application.port.out.GetAllPracticesPort;
import com.jcaa.usersmanagement.domain.model.PracticeModel;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class GetAllPracticesService implements GetAllPracticesUseCase {

    private final GetAllPracticesPort getAllPracticesPort;

    @Override
    public List<PracticeModel> execute() {
        return getAllPracticesPort.getAll();
    }
}
