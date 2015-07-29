package com.downeydarragh.popularmovies;

import android.media.Image;

/**
 * Created by Darragh on 25/07/2015.
 */
public class Movie {
    private String title;
    private String synopsis;
    private int releaseYear;
    private int poster;

    public Movie(String title, int poster, int releaseYear, String synopsis) {
        this.title = title;
        this.poster = poster;
        this.releaseYear = releaseYear;
        this.synopsis = synopsis;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) { this.poster = poster; }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}
