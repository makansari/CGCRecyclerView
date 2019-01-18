package com.ansari.cgcrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    List<Movie> movies;

    public MyAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mycardview_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie myMovie = movies.get(position);
        holder.titleTextView.setText(myMovie.getTitle());
        holder.genereTextView.setText(myMovie.getGenere());
        holder.yearTextView.setText(myMovie.year);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleTextView,genereTextView,yearTextView;
        public MyViewHolder(View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.textViewTitle);
            genereTextView = itemView.findViewById(R.id.textViewGenere);
            yearTextView = itemView.findViewById(R.id.textViewYear);
        }
    }
}
