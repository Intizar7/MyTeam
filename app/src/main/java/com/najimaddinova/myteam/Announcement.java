package com.najimaddinova.myteam;

import android.view.View;

/**
 * Created by ASUS on 3.03.2018.
 */

public class Announcement {

        private String title;
        private String date;
        boolean isRead;


        public String getTitle()
        {
            return this.title;
        }
        public void setTitle(String title){
            this.title = title;
        }



        public Announcement(String title, String date)
        {
            this.title = title;
            this.date = date;
        }
        public Announcement()
        {

        }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public interface CustomItemClickListener {
        void onItemClick(View v, int position);
    }



}

