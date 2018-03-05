package com.najimaddinova.myteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddAnnouncementActivity extends AppCompatActivity {

    private Button addButton;
    EditText edTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addannouncement);


        addButton = (Button) findViewById(R.id.btnannouncement);
        edTitle = (EditText) findViewById(R.id.edannounce);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("title");

                myRef.setValue(edTitle.getText().toString());
            }
        });

    }
}

