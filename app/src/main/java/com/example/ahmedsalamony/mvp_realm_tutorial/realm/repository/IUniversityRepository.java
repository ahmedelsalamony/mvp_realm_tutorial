package com.example.ahmedsalamony.mvp_realm_tutorial.realm.repository;

import com.example.ahmedsalamony.mvp_realm_tutorial.model.University;

import io.realm.RealmResults;

/**
 * Created by Ahmed Salamony on 8/3/2017.
 */

public interface IUniversityRepository {

    interface OnAddUniversityCallback{

        void success();
        void error(String msg);
    }

    interface OnGetAllUniversitiesCallback{

        void success(RealmResults<University> university);
        void error(String msg);
    }

    interface OnGetUniversityById{

        void success(University university);
        void error(String msg);
    }

    interface OnDeleteUniversity{

        void success();
        void error(String msg);
    }

    void addUniversity(University university,OnAddUniversityCallback onAddUniversityCallback);

    void getAllUniversities(OnGetAllUniversitiesCallback onGetAllUniversitiesCallback);

    void getUniversityById(String id,OnGetUniversityById onGetUniversityById);

    void deleteById(String id,OnDeleteUniversity onDeleteUniversity);

    void deleteByPosition(int position,OnDeleteUniversity onDeleteUniversity);
}
