package com.example.realm_recyclerview.Helper;

import android.provider.Contacts;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyHelper  {
    private Realm realm;
    RealmResults<Contacts.People> people;

    public MyHelper(Realm realm) {
        this.realm = realm;
    }
    public void setFromDB(){
        people = realm.where(Contacts.People.class).findAll();
    }
    public ArrayList<Contacts.PeopleColumns> jastRefresh(){

        ArrayList<Contacts.PeopleColumns>listitem = new ArrayList<>();
        for(Contacts.People p : people){
            listitem.add(p);
        }
        return listitem;
    }
}
