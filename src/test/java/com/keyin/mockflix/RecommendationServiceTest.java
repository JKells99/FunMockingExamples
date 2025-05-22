package com.keyin.mockflix;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class RecommendationServiceTest {

   List<TvShow> tvShows;
    @BeforeEach
    void setUp() {
        tvShows = List.of(
                new TvShow("Chuck", "Action"),
                new TvShow("Psych", "Medical"),
                new TvShow("Reacher", "Action")
        );

    }
    @AfterEach
    void tearDown() {
        tvShows = null;
    }
    @Test
    void testRecAction(){
        TvShowClient mockClient = Mockito.mock(TvShowClient.class);
        when(mockClient.getTvShows()).thenReturn(tvShows);
        RecommendationService recommendationService = new RecommendationService(mockClient);
        String rec = recommendationService.recommendTvShow("Action");
        assertEquals("Chuck",rec);
    }

    @Test
    void shouldReturnAllTvShowsMatchingGenre() {
        // Arrange
        TvShowClient mockClient = Mockito.mock(TvShowClient.class);

        when(mockClient.getTvShows()).thenReturn(tvShows);

        RecommendationService recommendationService = new RecommendationService(mockClient);

        // Act
        List<String> actionShows = recommendationService.listTvShowsByGenre("Action");

        // Assert
        assertEquals(2, actionShows.size(), "Should return 2 action shows");
        assertEquals(List.of("Chuck", "Reacher"), actionShows);
    }
    @Test
    void shouldReturnAllTvShowsMatchingFirstCharacter() {
        // Arrange
        TvShowClient mockClient = Mockito.mock(TvShowClient.class);

        when(mockClient.getTvShows()).thenReturn(tvShows);

        RecommendationService recommendationService = new RecommendationService(mockClient);

        // Act
        List<String> showsWithC = recommendationService.listAllShowsByFirstCharacter('C');

        // Assert
        assertEquals(1, showsWithC.size(), "Should return 1 show starting with 'C'");
        assertEquals(List.of("Chuck"), showsWithC);
    }


}
