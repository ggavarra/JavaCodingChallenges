package com.gg.designpatterns.bridge;

public class BridgeMain {
    public static void main(String[] args) {

        Movie movie= new Movie();
        //print a movie in a specified format.

        MoviePrinter printer= new MoviePrinter();
        printer.print(movie);

    }
}
