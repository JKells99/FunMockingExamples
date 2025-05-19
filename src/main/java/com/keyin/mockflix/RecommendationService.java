package com.keyin.mockflix;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecommendationService {
    private final TvShowClient tvShowClient;
    private Random random = new Random();


    public RecommendationService(TvShowClient tvShowClient) {
        this.tvShowClient = tvShowClient;

    }

    public String recommendTvShow(String genre) {
        Optional<TvShow> match = tvShowClient.getTvShows().stream()
                .filter(tvShow -> tvShow.getGenre().equalsIgnoreCase(genre))
                .findFirst();
        return match.map(TvShow::getTitle).orElse("No Show Avaible");


    }
    public void recommendRandomTVShowByGenre(String genre) {
        List<TvShow> tvShows = tvShowClient.getTvShows().stream()
                .filter(tvShow -> tvShow.getGenre().equalsIgnoreCase(genre))
                .toList();

        if (tvShows.isEmpty()) {
            System.out.println("No shows available in this genre.");
            return;
        }

        int randomIndex = random.nextInt(tvShows.size());
        TvShow randomTvShow = tvShows.get(randomIndex);
        System.out.println("Random TV Show: " + randomTvShow.getTitle() + " (" + randomTvShow.getGenre() + ")");
    }



    public List<String> listTvShowsByGenre(String genre) {
        return tvShowClient.getTvShows().stream()
                .filter(show -> show.getGenre().equalsIgnoreCase(genre))
                .map(TvShow::getTitle)
                .toList();

    }
    public List<String> listAllShowsByFirstCharacter(char character) {
        return tvShowClient.getTvShows().stream()
                .filter(show -> show.getTitle().charAt(0) == character)
                .map(TvShow::getTitle)
                .toList();

    }
}
