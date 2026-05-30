package com.jcaa.usersmanagement.application.port.in;

import com.jcaa.usersmanagement.domain.model.StudentModel;
import java.util.List;


public interface GetAllStudentUseCase {
    List<StudentModel> execute();
}
