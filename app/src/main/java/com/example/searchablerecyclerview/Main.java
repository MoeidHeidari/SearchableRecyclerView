package com.example.searchablerecyclerview;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity
{
    RecyclerView mainRecyclerView;
    EditText mainSearchBar;
    ListAdapter adapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<ViewModel> items = new ArrayList<>();
        items.add(new ViewModel("Moeid","Heidari"));
        items.add(new ViewModel("Hamid","Amiri"));
        items.add(new ViewModel("Ghasem","Jabari"));
        items.add(new ViewModel("Pouria","Akbari"));
        mainRecyclerView=findViewById(R.id.MainRecyclerView);
        mainSearchBar=findViewById(R.id.SearchBar);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter(this, items);
        mainRecyclerView.setAdapter(adapter);



    }
}
