package com.downeydarragh.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darragh on 25/07/2015.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {
    private static final String TAG = MovieAdapter.class.getSimpleName();

    /**
     * Constructor
     *
     * @param context
     * @param movies
     */
    public MovieAdapter(Context context, ArrayList<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // getItem iterates over each Movie in the MovieAdapter
        Movie movie = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_movie, parent, false);
        }

        ImageView posterView = (ImageView) convertView.findViewById(R.id.movie_image);
        posterView.setImageResource(movie.getPoster());

        TextView movieTitle = (TextView) convertView.findViewById(R.id.movie_title);
        movieTitle.setText(movie.getTitle() + " (" + movie.getReleaseYear() + ") ");

        return convertView;
    }
}
