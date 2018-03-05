package com.najimaddinova.myteam;

/**
 * Created by monovi on 5.03.2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {


    TextView txtannouncetitle;
    TextView txtDate;
    RecyclerView recyclerView;

    private RecyclerView recycler_view;
    private List<Announcement> announcement_list;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);


        txtannouncetitle = (TextView) findViewById(R.id.announcement_title);
        txtDate = (TextView) findViewById(R.id.txtdate);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);




        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, AddAnnouncementActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recycler_view.setLayoutManager(layoutManager);

        announcement_list = new ArrayList<Announcement>();


        announcement_list.add(new Announcement("Akyaka'da Bisiklet Turu", "03 May"));
        announcement_list.add(new Announcement("Yarışa var mısın?", "18 April"));
        announcement_list.add(new Announcement("Dağ Bisikleti Turnuvası", "9 May"));
        announcement_list.add(new Announcement("Bisiklet Çekilişi", "23 July"));



//        SimpleRecyclerAdapter adapter_items = new SimpleRecyclerAdapter(announcement_list, new Announcement.CustomItemClickListener() {
//            @Override
//            public void onItemClick(View v, int position) {
//
//                Announcement announcement = announcement_list.get(position);
//                Intent intent = new Intent(LoginActivity.this, AnnouncementDetailsActivity.class);
//                startActivity(intent);
//
//
//
//
//            }
//        });
//
        recycler_view.setHasFixedSize(true);

//        recycler_view.setAdapter(adapter_items);

        recycler_view.setItemAnimator(new DefaultItemAnimator());









    }
}

