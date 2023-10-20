package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView user_rv;
    ArrayList<User> UserList;
    UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_rv=findViewById(R.id.users);
        UserList = new ArrayList<>();
        userAdapter = new UserAdapter(this,UserList);
        user_rv.setAdapter(userAdapter);
    }
}