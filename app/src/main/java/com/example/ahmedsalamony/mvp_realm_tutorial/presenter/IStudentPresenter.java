package com.example.ahmedsalamony.mvp_realm_tutorial.presenter;

import com.example.ahmedsalamony.mvp_realm_tutorial.model.Student;

/**
 * Created by Ahmed Salamony on 8/3/2017.
 */

public interface IStudentPresenter extends IBasePresenter {

    void addStudent(Student student);

    void addStudentByUniversityId(Student student, String universityId);

    void deleteStudentByPosition(int position);

    void deleteStudentById(String studentId);

    void getAllStudents();

    void getAllStudentsByUniversityId(String id);

    void getStudentById(String id);

    void getUniversityById(String id);
}
