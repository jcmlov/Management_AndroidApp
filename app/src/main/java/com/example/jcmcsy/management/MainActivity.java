package com.example.jcmcsy.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView idText = (TextView) findViewById(R.id.idText);
        TextView passwordText = (TextView) findViewById(R.id.passwordText);
        TextView welcomeMessage = (TextView) findViewById(R.id.welcomeMessage);

        Intent intent = getIntent();
        String userId = intent.getStringExtra("userId");
        String userPw = intent.getStringExtra("userPw");
        String message = "환영합니다. " + userId + " 님!";

        idText.setText(userId);
        passwordText.setText(userPw);
        welcomeMessage.setText(message);
    }
}
