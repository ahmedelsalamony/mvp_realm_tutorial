package com.example.ahmedsalamony.mvp_realm_tutorial.realm.module;


import com.example.ahmedsalamony.mvp_realm_tutorial.model.Student;
import com.example.ahmedsalamony.mvp_realm_tutorial.model.University;

import io.realm.annotations.RealmModule;

/**
 * Created by roma on 15.10.15.
 */
@RealmModule(classes = {Student.class, University.class})
public class SimpleRealmModule {

}
