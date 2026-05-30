package com.jcaa.usersmanagement.domain.model;

import com.jcaa.usersmanagement.domain.valueobject.StudentGroup;
import com.jcaa.usersmanagement.domain.valueobject.StudentId;
import com.jcaa.usersmanagement.domain.valueobject.StudentName;
import lombok.Value;

@Value
public class StudentModel {

    StudentId studentId;
    StudentName name;
    StudentGroup group;

    public static StudentModel create(
            final StudentId id,
            final StudentName name,
            final StudentGroup group) {
        return new StudentModel(id, name, group);
    }

    public StudentModel withName(final StudentName newName) {
        return new StudentModel(studentId, newName, group);
    }

    public StudentModel withGroup(final StudentGroup newGroup) {
        return new StudentModel(studentId, name, newGroup);
    }
}