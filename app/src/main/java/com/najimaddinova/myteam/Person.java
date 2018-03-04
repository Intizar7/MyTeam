package com.najimaddinova.myteam;

import android.view.View;

/**
 * Created by gulin on 3.03.2018.
 */

public class Person {

    private String name;
    private String surname;
    private String eMail;
    private String phone;
    private int photo_id;
    private int person_age;

    public String getSurname() {return surname;}
    public void setSurname(String surname) {this.surname = surname;}
    public String geteMail() {return eMail;}
    public void seteMail(String eMail) {this.eMail = eMail;}
    public int getPerson_age() {return person_age;}
    public void setPerson_age(int person_age) {this.person_age = person_age;}
    public String getName()
    {
        return this.name;
    }
    public String getAge()
    {
        return this.phone;
    }
    public int getPhoto_id()
    {
        return this.photo_id;
    }
    public Person(String name,String phone,int photo_id)
    {
        this.name = name;
        this.phone = phone;
        this.photo_id = photo_id;
    }
    public Person()
    {
    }
    public interface CustomItemClickListener {
        void onItemClick(View v, int position);
    }

}
