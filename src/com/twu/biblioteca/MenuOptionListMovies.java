package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuOptionListMovies extends MenuOption {

    private ArrayList<Movie> movies;

    public MenuOptionListMovies(ArrayList<Movie> movies) {
        this.movies = movies;
        setName("List Movies");
    }

    public void execute() {
        for (Movie movie : movies) {
            if (!movie.isCheckedOut()) {
                System.out.println(movie.getMovieInfo());
            }
        }
    }

}
