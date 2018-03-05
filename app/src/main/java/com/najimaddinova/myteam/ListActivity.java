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
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ListActivity extends AppCompatActivity {


    TextView txtannouncetitle;
    TextView txtDate;
    RecyclerView recyclerView;
    private DatabaseReference mDatabase;

    private List<Announcement> announcement_list;
    private FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        txtannouncetitle = (TextView) findViewById(R.id.announcement_title);
        txtDate = (TextView) findViewById(R.id.txtdate);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);




        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListActivity.this, AddAnnouncementActivity.class);
                startActivity(intent);
                finish();
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        layoutManager.scrollToPosition(0);

        recyclerView.setLayoutManager(layoutManager);

        announcement_list = new ArrayList<Announcement>();

        FirebaseDatabase.getInstance().getReference().child("Announcements")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            Announcement announcement = snapshot.getValue(Announcement.class);
                            Log.e("AN:  ", announcement.getTitle());
                            announcement_list.add(announcement);
                            recyclerView.setAdapter(new SimpleRecyclerAdapter(announcement_list));

                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });

//        ValueEventListener listener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // Get Post object and use the values to update the UI
//                Announcement announcement = dataSnapshot.child("Announcements").child("-L6pE1Xm2B5BbFJBBR9O").getValue(Announcement.class);
//                announcement_list.add(announcement);
//                Log.e("AN:  ", announcement.getTitle());
//                synchronized(recyclerView){
//                    recyclerView.notify();
//                }
//                // ...
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                // Getting Post failed, log a message
//                // ...
//            }
//        };
//        mDatabase.addValueEventListener(listener);

//        announcement_list.add(new Announcement("Akyaka'da Bisiklet Turu", "03 May"));
//        announcement_list.add(new Announcement("Yarışa var mısın?", "18 April"));
//        announcement_list.add(new Announcement("Dağ Bisikleti Turnuvası", "9 May"));
//        announcement_list.add(new Announcement("Bisiklet Çekilişi", "23 July"));



        SimpleRecyclerAdapter adapter_items = new SimpleRecyclerAdapter(announcement_list);
//
        recyclerView.setHasFixedSize(true);

        recyclerView.setAdapter(adapter_items);

        recyclerView.setItemAnimator(new DefaultItemAnimator());









    }
}

