package com.keyin.mockflix;

import java.util.List;
import java.util.Optional;

public class RecommendationService {
    private final TvShowClient tvShowClient;

    public RecommendationService(TvShowClient tvShowClient) {
        this.tvShowClient = tvShowClient;

    }

    public String recommendTvShow(String genre) {
        Optional<TvShow> match = tvShowClient.getTvShows().stream()
                .filter(tvShow -> tvShow.getGenre().equalsIgnoreCase(genre))
                .findFirst();
        return match.map(TvShow::getTitle).orElse("No Show Avaible");


    }

    public List<String> listTvShowsByGenre(String genre) {
        return tvShowClient.getTvShows().stream()
                .filter(show -> show.getGenre().equalsIgnoreCase(genre))
                .map(TvShow::getTitle)
                .toList();

    }
}
