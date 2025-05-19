package com.keyin.mockflix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the TvShow class.
 */
public class TvShowTest {
    // Instance of TvShow used in the tests
    TvShow tvShow;

    /**
     * Sets up a TvShow instance before each test.
     */
    @BeforeEach
    public void setUp() {
        tvShow = new TvShow("Breaking Bad", "Drama");
    }

    /**
     * Tests the getTitle method to ensure it returns the correct title.
     */
    @Test
    public void testGetTitle() {
        assertEquals("Breaking Bad", tvShow.getTitle());
    }

    /**
     * Tests the getGenre method to ensure it returns the correct genre.
     */
    @Test
    public void testGetGenre() {
        assertEquals("Drama", tvShow.getGenre());
    }

    /**
     * Tests the setTitle method to ensure it updates the title correctly.
     */
    @Test
    public void testSetTitle() {
        tvShow.setTitle("Game of Thrones");
        assertEquals("Game of Thrones", tvShow.getTitle());
    }

    /**
     * Tests the setGenre method to ensure it updates the genre correctly.
     */
    @Test
    public void testSetGenre() {
        tvShow.setGenre("Fantasy");
        assertEquals("Fantasy", tvShow.getGenre());
    }

    /**
     * Tests the toString method to ensure it returns the correct string representation.
     */
    @Test
    public void testToString() {
        assertEquals("TvShow{title='Breaking Bad', genre='Drama'}", tvShow.toString());
    }
}