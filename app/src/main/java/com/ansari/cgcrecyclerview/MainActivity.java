package com.ansari.cgcrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Movie> movies;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = new ArrayList<>();
        recyclerView = findViewById(R.id.myRecyclerview);

        myAdapter = new MyAdapter(movies);

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(myAdapter);



        addData();
    }

    private void addData() {

        Movie movie1 = new Movie("TITLE 1"," GENEER 1", "1940");
        movies.add(movie1);
        Movie movie2 = new Movie("TITLE 2"," GENEER 2", "1945");
        movies.add(movie1);
        Movie movie3 = new Movie("TITLE 3"," GENEER 3", "1950");
        movies.add(movie1);
        Movie movie4 = new Movie("TITLE 4"," GENEER 4", "1970");
        movies.add(movie1);
    }
}
