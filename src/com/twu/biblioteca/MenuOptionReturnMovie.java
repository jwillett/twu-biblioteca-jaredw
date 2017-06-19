package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOptionReturnMovie extends MenuOption {

    private ArrayList<Movie> movies;

    public MenuOptionReturnMovie(ArrayList<Movie> movies) {
        this.movies = movies;
        setName("Return Movie");
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select number of movie to return");

        for (Movie movie: movies) {
            if (movie.isCheckedOut()) {
                System.out.println((movies.indexOf(movie) + 1) + "\t" + movie.getMovieInfo());
            }
        }

        String option = scanner.nextLine();

        try {
            int optionNumber = Integer.parseInt(option);
            Movie selectedMovie = movies.get(optionNumber - 1);
            selectedMovie.returnItem();
            System.out.println("Thank you for returning the movie.");
        } catch (Exception e) {
            System.out.println("That is not a valid movie to return.");
        }
        System.out.println("Please select an option from the main menu.");
    }
}
