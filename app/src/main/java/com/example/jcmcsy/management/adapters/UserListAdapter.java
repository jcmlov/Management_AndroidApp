package com.example.jcmcsy.management.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.jcmcsy.management.R;
import com.example.jcmcsy.management.request.DeleteRequest;
import com.example.jcmcsy.management.vo.User;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.List;

public class UserListAdapter extends BaseAdapter {

    private Context context;
    private List<User> userList;
    private Activity parentActivity;

    public UserListAdapter(Context context, List<User> userList, Activity parentActivity) {
        this.context = context;
        this.userList = userList;
        this.parentActivity = parentActivity;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return userList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(context, R.layout.user, null);

        final TextView userId = (TextView) v.findViewById(R.id.userId);
        TextView userPw = (TextView) v.findViewById(R.id.userPw);
        TextView userNm = (TextView) v.findViewById(R.id.userNm);
        TextView userEmail = (TextView) v.findViewById(R.id.userEmail);

        userId.setText(userList.get(i).getUserId());
        userPw.setText(userList.get(i).getUserPw());
        userNm.setText(userList.get(i).getUserNm());
        userEmail.setText(userList.get(i).getUserEmail());

        v.setTag(userList.get(i).getUserId());

        final Button deleteButton = (Button) v.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if(success) {
                                userList.remove(i);
                                notifyDataSetChanged();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };

                DeleteRequest deleteRequest = new DeleteRequest(userId.getText().toString(), responseListener);
                RequestQueue queue = Volley.newRequestQueue(parentActivity);
                queue.add(deleteRequest);
            }
        });

        return v;
    }
}
