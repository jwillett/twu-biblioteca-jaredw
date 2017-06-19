package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuOptionCheckoutMovie extends MenuOption {

    private ArrayList<Movie> movies;

    public MenuOptionCheckoutMovie(ArrayList<Movie> movies) {
        this.movies = movies;
        setName("Checkout Movie");
    }

    public void execute() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please select number of movie to checkout");

        for (Movie movie : movies) {
            if (!movie.isCheckedOut()) {
                System.out.println((movies.indexOf(movie) + 1) + "\t" + movie.getMovieInfo());
            }
        }

        String option = scanner.nextLine();

        try {
            int optionNumber = Integer.parseInt(option);
            Movie selectedMovie = movies.get(optionNumber - 1);
            selectedMovie.checkout();
            System.out.println("Thank you! Enjoy the movie");
        } catch (Exception e) {
            System.out.println("That movie is not available.");
        }
        System.out.println("Please select an option from the main menu.");
    }
}
