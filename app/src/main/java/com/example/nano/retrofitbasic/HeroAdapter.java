package com.example.nano.retrofitbasic;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Nano on 3/23/2018.
 */

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.MovieViewHolder> {

    private List<Hero> movies;
    private int rowLayout;
    private Context context;

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;
        ImageView imageView;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (RelativeLayout)v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            data = (TextView) v.findViewById(R.id.subtitle);
            movieDescription = (TextView) v.findViewById(R.id.description);
            rating = (TextView) v.findViewById(R.id.rating);
            imageView=(ImageView)v.findViewById(R.id.rating_image);
        }

    }

        public HeroAdapter(List<Hero> movies, int rowLayout, Context context) {
            this.movies = movies;
            this.rowLayout = rowLayout;
            this.context = context;
        }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, final int position) {
            holder.movieTitle.setText(movies.get(position).getName());
            holder.data.setText(movies.get(position).getCreatedby());
            holder.movieDescription.setText(movies.get(position).getFirstappearance());
            holder.rating.setText(movies.get(position).getBio().toString());
           // holder.imageView.setImageResource(movies.get(position).getImageurl());
           // Picasso.with(context).load(url).into(holder.imageView);

          //  String imgURL = get(position).get();
          //  Picasso.with(context).load().into(holder.imageView);

           // Picasso.with(context).load(g).into(holder.imageView);

         //   Picasso.with(context).load(movies.get(position).getImageurl()).into(imageView);

            Glide.with(context).load(movies.get(position).getImageurl()).into(holder.imageView);
        }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
