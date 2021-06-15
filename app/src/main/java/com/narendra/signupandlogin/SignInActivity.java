package com.narendra.signupandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignInActivity extends AppCompatActivity {
    EditText username,password;
    Integer count=2;
    Button signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);
        signIn=findViewById(R.id.signin);
    }
    public void signin(View view) {
        Bundle bundle = getIntent().getExtras();
        String uid = bundle.getString("uid");
        String pwd = bundle.getString("pwd");
        if (username.getText().toString().equals(uid) && password.getText().toString().equals(pwd)) {
            Toast.makeText(this, "Login successful", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, SuccessActivity.class);
            startActivity(intent);
        } else{
            if(count==0) {
                signIn.setEnabled(false);
                Toast.makeText(this, "Button disabled", Toast.LENGTH_LONG).show();
            }
            count--;
            if(count>=0)
                Toast.makeText(this, "Login failed, more "+count+" attempt is left", Toast.LENGTH_LONG).show();


        }
    }
}