package com.narendra.signupandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.uid);
        password=findViewById(R.id.pwd);
    }
    public void signup(View view) {
        String pwd = password.getText().toString();
        if (pwd.length() >= 8 && validatePassword(pwd)) {
            Toast.makeText(this, "SignUp successful", Toast.LENGTH_LONG).show();
            Intent intent=new Intent(this,SignInActivity.class);
            Bundle bundle=new Bundle();
            bundle.putString("uid",username.getText().toString());
            bundle.putString("pwd",pwd);
            intent.putExtras(bundle);
            startActivity(intent);
        } else Toast.makeText(this, "Password not matching with the constraints", Toast.LENGTH_LONG).show();
    }
    public boolean validatePassword(String pwd){
        Pattern pattern;
        Matcher match;
        String passwordPattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[$#+-@!])(?=\\S+$).{8,}$";
        pattern=Pattern.compile(passwordPattern);
        match=pattern.matcher(pwd);
        return match.matches();
    }
}














