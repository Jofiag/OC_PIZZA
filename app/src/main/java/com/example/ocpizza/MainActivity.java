package com.example.ocpizza;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

//    private Button signInFacebookButton;
//    private Button signInGoogleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setReferences();
    }

//    private void setReferences(){
//        signInFacebookButton = findViewById(R.id.sign_in_facebook_button);
//        signInGoogleButton = findViewById(R.id.sign_in_google_button);
//    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in_facebook_button:
                signInWithFacebook();
                break;
            case R.id.sign_in_google_button:
                signInWithGoogle();
                break;
        }
    }

    private void signInWithFacebook(){

    }

    private void signInWithGoogle(){

    }
}