package com.example.ahmedsalamony.mvp_realm_tutorial.realm.table;

/**
 * Created by Ahmed Salamony on 8/3/2017.
 */

public interface RealmTable {

    String ID = "id";

    interface University {
        String STUDENTS = "students";
        String NAME = "name";
    }

    interface Student{
        String NAME = "name";
        String AGE = "age";
        String EMAIL = "email";
        String BOOKS = "books";
        String LESSONS = "lessons";
    }
}