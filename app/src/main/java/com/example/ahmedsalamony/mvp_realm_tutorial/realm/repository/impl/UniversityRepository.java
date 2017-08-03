package com.example.ahmedsalamony.mvp_realm_tutorial.realm.repository.impl;

import com.example.ahmedsalamony.mvp_realm_tutorial.app.SimpleRealmApp;
import com.example.ahmedsalamony.mvp_realm_tutorial.model.University;
import com.example.ahmedsalamony.mvp_realm_tutorial.realm.repository.IUniversityRepository;
import com.example.ahmedsalamony.mvp_realm_tutorial.realm.table.RealmTable;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Ahmed Salamony on 8/3/2017.
 */
public class UniversityRepository implements IUniversityRepository {


    @Override
    public void addUniversity(University university, OnAddUniversityCallback onAddUniversityCallback) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        University u = realm.createObject(University.class);
        u.setId(UUID.randomUUID().toString());
        u.setName(u.getName());
        realm.commitTransaction();

        if (onAddUniversityCallback!=null){
            onAddUniversityCallback.success();
        }
    }

    @Override
    public void getAllUniversities(OnGetAllUniversitiesCallback onGetAllUniversitiesCallback) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        RealmQuery<University> query = realm.where(University.class);
        RealmResults<University> results = query.findAll();

        if (onGetAllUniversitiesCallback!=null){
            onGetAllUniversitiesCallback.success(results);
        }
    }

    @Override
    public void getUniversityById(String id, OnGetUniversityById onGetUniversityById) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        University result = realm.where(University.class).equalTo(RealmTable.ID, id).findFirst();

        if (onGetUniversityById!=null){
            onGetUniversityById.success(result);
        }

    }

    @Override
    public void deleteById(String id, OnDeleteUniversity onDeleteUniversity) {

        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        University university = realm.where(University.class).equalTo(RealmTable.ID, id).findFirst();
        university.removeFromRealm();
        realm.commitTransaction();

        if (onDeleteUniversity!=null){
            onDeleteUniversity.success();
        }

    }

    @Override
    public void deleteByPosition(int position, OnDeleteUniversity onDeleteUniversity) {
        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
        realm.beginTransaction();
        RealmQuery<University> query = realm.where(University.class);
        RealmResults<University> results = query.findAll();
        results.remove(position);
        realm.commitTransaction();

        if (onDeleteUniversity!=null){
            onDeleteUniversity.success();
        }
    }
}
