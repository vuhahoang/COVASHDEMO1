package com.example.covash_demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class loginform extends AppCompatActivity {
    private Button signup;
    private Context context;
    TextInputLayout EdUsername, EdPassword;
    FirebaseDatabase rootNode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_loginform);
        context = this;
        signup = (Button) findViewById(R.id.btsignupa);
        EdUsername = (TextInputLayout) findViewById(R.id.edusernamea);
        EdPassword = (TextInputLayout) findViewById(R.id.edpassworda);
        Intent k = getIntent();
        EdUsername.getEditText().setText(k.getStringExtra("key1"));
        EdPassword.getEditText().setText(k.getStringExtra("key2"));

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(loginform.this, registerform.class);
                startActivity(i);
            }
        });
    }

    public void loginUser(View view) {
        //Validate Login Info
        if (!validateUsername() | !validatePassword()) {
            return;
        } else {
            isUser();
        }
    }

    private Boolean validateUsername() {
        String val = EdUsername.getEditText().getText().toString();
        if (val.isEmpty()) {
            EdUsername.setError("Field cannot be empty");
            return false;
        } else {
            EdUsername.setError(null);
            EdUsername.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = EdPassword.getEditText().getText().toString();
        if (val.isEmpty()) {
            EdPassword.setError("Field cannot be empty");
            return false;
        } else {
            EdPassword.setError(null);
            EdPassword.setErrorEnabled(false);
            return true;
        }
    }

    private void isUser() {
        //progressBar.setVisibility(View.VISIBLE);
        final String userEnteredUsername = EdUsername.getEditText().getText().toString().trim();
        final String userEnteredPassword = EdPassword.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        Query checkUser = reference.orderByChild("username").equalTo(userEnteredUsername);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                if(snapshot.exists()){
                    EdUsername.setError(null);
                    EdUsername.setErrorEnabled(false);
                    String passwordFromDB = snapshot.child(userEnteredUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userEnteredPassword)) {
                        Intent j = new Intent(loginform.this,homepage.class);
                        startActivity(j);
                    }else{
                        EdPassword.setError("Wrong password");
                        EdPassword.requestFocus();
                    }
                }else {
                    EdUsername.setError("No such User exist");
                    EdUsername.requestFocus();
                }

            }

            @Override
            public void onCancelled(@NonNull  DatabaseError error) {

            }
        });
    }


}