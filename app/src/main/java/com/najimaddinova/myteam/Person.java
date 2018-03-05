package com.najimaddinova.myteam;

import android.view.View;

/**
 * Created by gulin on 3.03.2018.
 */

public class Person {


    public void setName(String name) {
        this.name = name;
    }
    private String name;
    private String surname;
    private String eMail;
    private String phone;
    private int photo_id;
    private int person_age;

    public String getUser_Pic() {
        return user_Pic;
    }

    public void setUser_Pic(String user_Pic) {
        this.user_Pic = user_Pic;
    }

    private String user_Pic;

    public String getPhone() {
        return phone;
    }

    public void setPhoto_id(int photo_id) {
        this.photo_id = photo_id;
    }

    private String password;

    public String getUser_Id() {
        return User_Id;
    }

    public void setUser_Id(String user_Id) {
        User_Id = user_Id;
    }

    private  String User_Id;

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public void setPhone(String phone) {this.phone = phone;}

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
