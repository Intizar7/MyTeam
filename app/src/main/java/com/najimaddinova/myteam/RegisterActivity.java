package com.najimaddinova.myteam;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterActivity extends AppCompatActivity {

    private EditText edname, edsurname, edTeamname, edphone, edemail,edpassword;
    private Button btnregister;
    private CircleImageView addpicture;
    private String userName;
    private String userPassword;
    private StorageReference mStorageRef;
    private static final int GALLERY_INTENT = 2;
    private FirebaseAuth mAuth;
    private String CurrentImgPath="-";
    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ID();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dtRef = database.getReference();
        final DatabaseReference memberRef = dtRef.child("Kayitlar").child("Kullanicilar");
        mStorageRef = FirebaseStorage.getInstance().getReference();
        mAuth = mAuth.getInstance();

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userName = edemail.getText().toString();
                userPassword = edpassword.getText().toString();

                final Person p = new Person();
                p.setName(edname.getText().toString());
                p.setSurname(edsurname.getText().toString());
                p.seteMail(edemail.getText().toString());
                p.setPhone(edphone.getText().toString());
                p.setPassword(edpassword.getText().toString());
                p.setUser_Pic(CurrentImgPath);
                // kayitKontrol();
                Toast.makeText(RegisterActivity.this, "Kayıt başarılı..", Toast.LENGTH_SHORT).show();
                final ProgressDialog progressDialog = ProgressDialog.show(RegisterActivity.this, "Please Wait..", "Processing..", true);
                (mAuth.createUserWithEmailAndPassword(edemail.getText().toString(), edpassword.getText().toString())).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if (task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "Registration Succesfull", Toast.LENGTH_LONG).show();
                            p.setUser_Id(mAuth.getCurrentUser().getUid());
                            memberRef.child(memberRef.push().getKey()).setValue(p);
                            SignIn();
                        } else {
                            Log.e("ERROR", task.getException().toString());
                            Toast.makeText(RegisterActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
    public void SignIn(){
        final ProgressDialog progressDialog=ProgressDialog.show(RegisterActivity.this,"Lütfen bekleyiniz..",
                /*processing*/"işlem..",true);
        (mAuth.signInWithEmailAndPassword(edemail.getText().toString(),edpassword.getText().toString())).
                addOnCompleteListener(new OnCompleteListener<AuthResult>(){
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task){

                        if(task.isSuccessful()){

                            if(imageUri != null) {
                                final StorageReference filepath = mStorageRef.child("Profile")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                                filepath.putFile(imageUri)
                                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                                            @Override
                                            public void onSuccess(final UploadTask.TaskSnapshot taskSnapshot) {

                                                @SuppressWarnings("VisibleForTests") Uri downloadUrl = taskSnapshot.getDownloadUrl();
                                                Picasso.with(addpicture.getContext()).load(downloadUrl.toString()).into(addpicture);
                                                progressDialog.dismiss();
                                                Toast.makeText(RegisterActivity.this,"Giriş Başarılı",Toast.LENGTH_LONG).show();
                                                Intent i=new Intent(RegisterActivity.this,SimpleRecyclerAdapter.class);
                                                startActivity(i);
                                            }
                                        });
                            } else {
                                progressDialog.dismiss();
                                Intent i=new Intent(RegisterActivity.this,SimpleRecyclerAdapter.class);
                                startActivity(i);
                            }
                        } else {
                            Log.e("ERROR",task.getException().toString());
                            Toast.makeText(RegisterActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_INTENT && resultCode== RESULT_OK ){
            imageUri = data.getData();
        }
    }
    public  void ID(){
        edname = (EditText) findViewById(R.id.edName);
        edsurname = (EditText) findViewById(R.id.edSurname);
        edTeamname = (EditText) findViewById(R.id.edTeamName);
        edphone = (EditText) findViewById(R.id.edPhone);
        edemail = (EditText) findViewById(R.id.edEmail);
        edpassword = (EditText) findViewById(R.id.edPassword);
        btnregister=(Button) findViewById(R.id.btnRegis);
    }
}
