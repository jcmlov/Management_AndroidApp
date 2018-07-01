package com.example.jcmcsy.management.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jcmcsy.management.R;
import com.example.jcmcsy.management.adapters.UserListAdapter;
import com.example.jcmcsy.management.vo.User;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ManagementActivity extends AppCompatActivity {

    private ListView listView;
    private UserListAdapter adapter;
    private List<User> userList;
    private List<User> saveList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_management);
        Intent intent = getIntent();

        listView = (ListView) findViewById(R.id.listView);
        userList = new ArrayList<User>();
        saveList = new ArrayList<User>();
        adapter = new UserListAdapter(getApplicationContext(), userList, saveList, this);
        listView.setAdapter(adapter);

        try {
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("userList"));
            JSONArray jsonArray = jsonObject.getJSONArray("response");

            int count = 0;
            String userId, userPw, userNm, userEmail;

            while(count < jsonArray.length()) {
                JSONObject object = jsonArray.getJSONObject(count);
                userId = object.getString("userId");
                userPw = object.getString("userPw");
                userNm = object.getString("userNm");
                userEmail = object.getString("userEmail");
                User user = new User(userId, userPw, userNm, userEmail);

                if(!userId.equals("admin")) {
                    userList.add(user);
                    saveList.add(user);
                }
                count++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        EditText search = (EditText) findViewById(R.id.search);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                searchUser(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void searchUser(String search) {
        userList.clear();
        for(int i=0; i<saveList.size(); i++) {
            if(saveList.get(i).getUserId().contains(search)) {
                userList.add(saveList.get(i));
            }
        }
        adapter.notifyDataSetChanged();
    }
}
