package com.ansari.cgcrecyclerview;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Movie> movies;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    ProgressDialog progressDialog;
    Movie myMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        movies = new ArrayList<>();
        recyclerView = findViewById(R.id.myRecyclerview);


        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        getDataFromServer();

        //addData();
    }



    private void getDataFromServer() {

        String url = "https://api.androidhive.info/contacts/";

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Downloading data from server !!!!");
        progressDialog.show();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {

             @Override
            public void onResponse(String response) {

                progressDialog.cancel();
                try {
                    JSONObject jsonObj = new JSONObject(response);
                    JSONArray contancts = jsonObj.getJSONArray("contacts");

                    for(int i=0; i<contancts.length();i++){
                        JSONObject data = contancts.getJSONObject(i);
                        String name = data.getString("name");
                        String email = data.getString("email");
                        String gender = data.getString("gender");

                        myMovie = new Movie(name,email,gender);
                        movies.add(myMovie);

                    }
                    myAdapter = new MyAdapter(movies);
                    recyclerView.setAdapter(myAdapter);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });



        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);




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
