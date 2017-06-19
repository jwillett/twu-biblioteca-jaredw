package com.twu.biblioteca;

public class Movie extends LibraryItem {

    private final static int UNRATED = 0;

    private String name;
    private int year;
    private String director;
    private int rating = UNRATED;

    public Movie(String name, int year, String director, int rating) {
        this(name, year, director);
        if (rating >= 1 && rating <= 10) this.rating = rating;
    }

    public Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
    }

    public String getMovieInfo() {
        return getName() + '\t' + getYear() + '\t' + getDirector() + '\t' + getRating();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        if (rating != 0) {
            return Integer.toString(rating);
        } else {
            return "Unrated";
        }
    }

}
