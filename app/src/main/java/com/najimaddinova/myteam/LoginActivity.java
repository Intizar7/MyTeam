package com.najimaddinova.myteam;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    public Button btnLogin,btnRegister;
    public EditText edUser,edPassword;
    public String username;
    public  String password;
    private FirebaseUser firebaseUser;
    private FirebaseAuth firebaseAuth;
    @Override
    public void onStart() {
        super.onStart();

        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FirebaseApp.initializeApp(this);

        firebaseAuth = FirebaseAuth.getInstance();
        btnLogin=(Button)findViewById(R.id.btnLogin);
        btnRegister=(Button)findViewById(R.id.btnRegister);
        edUser=(EditText)findViewById(R.id.edUser);
        edPassword=(EditText)findViewById(R.id.edPassword);

        if(firebaseUser != null){
            Intent i = new Intent(LoginActivity.this,MainActivity.class);
            i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
            startActivity(i);
            finish();
        }
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, AddAnnouncementActivity.class));
//                username=edUser.getText().toString();
//                password=edPassword.getText().toString();
//                if(username.isEmpty() || password.isEmpty()){
//                    Toast.makeText(getApplicationContext(),"Lütfen gerekli alanı doldurunuz!",Toast.LENGTH_LONG).show();
//                }else{
//                    loginFunc();
//                }
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }
    private void loginFunc(){
        firebaseAuth.signInWithEmailAndPassword(username,password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i = new Intent(LoginActivity.this,MainActivity.class);
                            i.putExtra("Email",firebaseAuth.getCurrentUser().getEmail());
                            startActivity(i);
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}
