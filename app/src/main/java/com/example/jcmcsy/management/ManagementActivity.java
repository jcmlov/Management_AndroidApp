package com.example.jcmcsy.management;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        TextView userListTextView = (TextView) findViewById(R.id.userListTextView);
        Intent intent = getIntent();
        userListTextView.setText(intent.getStringExtra("userList"));
    }
}
