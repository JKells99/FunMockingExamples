package com.keyin.bookrecsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class BookRecommender {

    private  BookCatalog bookCatalog;
    private  Random rand = new Random();
    private String[] GENRES = {"Fiction","Fiction/Thriller", "Non-Fiction", "Science Fiction", "Fantasy", "Mystery", "Romance"};

    public BookRecommender(BookCatalog bookCatalog) {
        this.bookCatalog = bookCatalog;
    }

    public Book recommendByGenre(String genre) {
        try {
            if(!List.of(GENRES).contains(genre)) {
                throw new IllegalArgumentException("Invalid genre: " + genre);
            }
            List<Book> filtered = bookCatalog.getAllBooks().stream()
                    .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                    .toList();

            if (filtered.isEmpty()) return null;
            return filtered.get(rand.nextInt(filtered.size()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
