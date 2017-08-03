package com.example.ahmedsalamony.mvp_realm_tutorial.realm.repository.impl;

import com.example.ahmedsalamony.mvp_realm_tutorial.app.SimpleRealmApp;
import com.example.ahmedsalamony.mvp_realm_tutorial.model.Student;
import com.example.ahmedsalamony.mvp_realm_tutorial.model.University;
import com.example.ahmedsalamony.mvp_realm_tutorial.realm.repository.IStudentRepository;
import com.example.ahmedsalamony.mvp_realm_tutorial.realm.table.RealmTable;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ahmed Salamony on 8/3/2017.
 */

public class StudentRepository implements IStudentRepository {


    @Override
    public void addStudent(Student student, OnSaveStudentCallback onSaveStudentCallback) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        Student realmStudent = realm.createObject(Student.class);
        realmStudent.setId(UUID.randomUUID().toString());
        realmStudent.setName(student.getName());
        realmStudent.setEmail(student.getEmail());
        realmStudent.setBirthday(student.getBirthday());

        realm.commitTransaction();

        if (onSaveStudentCallback != null)
            onSaveStudentCallback.success();
    }

    @Override
    public void addStudentByUniversityId(Student student, String universityId, OnSaveStudentCallback onSaveStudentCallback) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();

        Student realmStudent = realm.createObject(Student.class);
        realmStudent.setId(UUID.randomUUID().toString());
        realmStudent.setName(student.getName());
        realmStudent.setBirthday(student.getBirthday());
        realmStudent.setEmail(student.getEmail());

        University university = realm.where(University.class).equalTo(RealmTable.ID, universityId).findFirst();
        university.getStudents().add(realmStudent);
        realm.commitTransaction();

        if (onSaveStudentCallback!=null){
            onSaveStudentCallback.success();
        }
    }

    @Override
    public void deleteStudentById(String id, OnDeleteStudentCallback onDeleteStudentCallback) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        Student result = realm.where(Student.class).equalTo(RealmTable.ID, id).findFirst();
        result.removeFromRealm();
        realm.commitTransaction();

        if (onDeleteStudentCallback!=null){
            onDeleteStudentCallback.success();
        }
    }

    @Override
    public void deleteStudentByPosition(int position, OnDeleteStudentCallback onDeleteStudentCallback) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        RealmQuery<Student> query = realm.where(Student.class);
        RealmResults<Student> results = query.findAll();
        results.remove(position);
        realm.commitTransaction();

        if (onDeleteStudentCallback!=null){
            onDeleteStudentCallback.success();
        }
    }

    @Override
    public void getAllStudents(OnGetAllStudentsCallback onGetAllStudentsCallback) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        RealmResults<Student> results = realm.where(Student.class).findAll();

        if (onGetAllStudentsCallback!=null){
            onGetAllStudentsCallback.success(results);
        }
    }

    @Override
    public void getAllStudentsByUniversityId(String id, OnGetStudentsCallback onGetStudentsCallback) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        University university = realm.where(University.class).equalTo(RealmTable.ID, id).findFirst();
        RealmList<Student> students = university.getStudents();

        if (onGetStudentsCallback!=null){
            onGetStudentsCallback.success(students);
        }
    }

    @Override
    public void getStudent(String id, OnGetStudentByIdCallback onGetStudentByIdCallback) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        Student student = realm.where(Student.class).equalTo(RealmTable.ID, id).findFirst();

        if (onGetStudentByIdCallback!=null){
            onGetStudentByIdCallback.success(student);
        }
    }
}
