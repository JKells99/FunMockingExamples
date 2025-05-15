package com.keyin.mockflix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecommendationServiceTest {
    @Test
    void testRecAction(){
        TvShowClient mockClient = Mockito.mock(TvShowClient.class);
        List<TvShow> mockShows = List.of(
                new TvShow("Chuck", "Action"),
                new TvShow("Psych","Medical")
        );
        when(mockClient.getTvShows()).thenReturn(mockShows);
        RecommendationService recommendationService = new RecommendationService(mockClient);
        String rec = recommendationService.recommendTvShow("Action");
        assertEquals("Chuck",rec);
    }

    @Test
    void shouldReturnAllTvShowsMatchingGenre() {
        // Arrange
        TvShowClient mockClient = Mockito.mock(TvShowClient.class);
        List<TvShow> mockShows = List.of(
                new TvShow("Chuck", "Action"),
                new TvShow("Psych", "Medical"),
                new TvShow("Reacher", "Action")
        );
        when(mockClient.getTvShows()).thenReturn(mockShows);

        RecommendationService recommendationService = new RecommendationService(mockClient);

        // Act
        List<String> actionShows = recommendationService.listTvShowsByGenre("Action");

        // Assert
        assertEquals(2, actionShows.size(), "Should return 2 action shows");
        assertEquals(List.of("Chuck", "Reacher"), actionShows);
    }


}
