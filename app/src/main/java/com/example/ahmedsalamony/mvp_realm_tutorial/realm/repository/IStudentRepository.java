package com.example.ahmedsalamony.mvp_realm_tutorial.realm.repository;

import com.example.ahmedsalamony.mvp_realm_tutorial.model.Student;

import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Ahmed Salamony on 8/2/2017.
 */

public interface IStudentRepository {

    interface OnSaveStudentCallback{

        void success();
        void error(String msg);
    }

    interface OnDeleteStudentCallback{

        void success();
        void error(String msg);
    }

    interface OnGetStudentByIdCallback{

        void  success(Student student);
        void error(String msg);
    }

    interface OnGetAllStudentsCallback{

        void success(RealmResults<Student> student);
        void error(String msg);
    }

    //this interface for get all students for each university "one to many relationship " "one university many students"
    //just RealmList can be used in this case ,RealmResults can't;
    interface OnGetStudentsCallback{

        void success(RealmList<Student> student);
        void error(String msg);
    }

    void addStudent(Student student,OnSaveStudentCallback onSaveStudentCallback);

    void addStudentByUniversityId(Student student,String universityId,OnSaveStudentCallback onSaveStudentCallback);

    void deleteStudentById(String studentId,OnDeleteStudentCallback onDeleteStudentCallback);

    void deleteStudentByPosition(int position,OnDeleteStudentCallback onDeleteStudentCallback);

    void getAllStudents(OnGetAllStudentsCallback onGetAllStudentsCallback);

    void getAllStudentsByUniversityId(String id, OnGetStudentsCallback onGetStudentsCallback);

    void getStudent(String id,OnGetStudentByIdCallback onGetStudentByIdCallback);
}
