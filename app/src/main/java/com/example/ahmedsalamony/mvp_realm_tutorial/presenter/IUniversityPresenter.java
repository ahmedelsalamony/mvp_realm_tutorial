package com.example.ahmedsalamony.mvp_realm_tutorial.presenter;

/**
 * Created by Ahmed Salamony on 8/3/2017.
 */

public interface IUniversityPresenter extends IBasePresenter {

    void addUniversity(String universityName);

    void deleteUniversity(int position);

    void deleteUniversityById(String Id);

    void getUniversityById(String id);

    void getAllUniversities();

}
