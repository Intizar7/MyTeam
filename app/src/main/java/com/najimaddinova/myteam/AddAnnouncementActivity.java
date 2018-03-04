package com.najimaddinova.myteam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AddAnnouncementActivity extends AppCompatActivity {

    private Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addannouncement);


        addButton = (Button) findViewById(R.id.btnannouncement);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddAnnouncementActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}

