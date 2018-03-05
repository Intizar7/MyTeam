package com.najimaddinova.myteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddAnnouncementActivity extends AppCompatActivity {

    private Button addButton;
    EditText edTitle;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addannouncement);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        addButton = (Button) findViewById(R.id.btnannouncement);
        edTitle = (EditText) findViewById(R.id.edannounce);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredTask = edTitle.getText().toString();
                if(TextUtils.isEmpty(enteredTask)){
                    Toast.makeText(AddAnnouncementActivity.this, "You must enter a task first", Toast.LENGTH_LONG).show();

                }
                else
                {
                    writeNewAnnouncement(edTitle.getText().toString(), "5 Mart");
                }
            }
        });

    }



    private void writeNewAnnouncement(String title, String date) {
        Announcement announcement = new Announcement(title, date);
        String id = mDatabase.push().getKey();

        mDatabase.child("Announcements").child(id).setValue(announcement);
    }

}

