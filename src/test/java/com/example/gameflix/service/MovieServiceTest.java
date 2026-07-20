package com.example.gameflix.service;

import com.example.gameflix.model.Movie;
import com.example.gameflix.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    private MovieService movieService;

    @BeforeEach
    void setUp() {
        movieService = new MovieServiceImpl(movieRepository);
    }

    @Test
    void getAllMovies_ShouldReturnList() {
        List<Movie> expectedMovies = List.of(
                new Movie(1L, "The Matrix", "Science Fiction"),
                new Movie(2L, "The Godfather", "Crime")
        );

        when(movieRepository.findAll()).thenReturn(expectedMovies);

        List<Movie> actualMovies = movieService.getAllMovies();

        assertNotNull(actualMovies);
        assertEquals(2, actualMovies.size());
        assertEquals("The Matrix", actualMovies.get(0).getTitle());
    }

    @Test
    void getMovieById_ShouldReturnMovie() {
        Movie expectedMovie = new Movie(1L, "The Matrix", "Science Fiction");

        when(movieRepository.findById(1L)).thenReturn(Optional.of(expectedMovie));

        Movie actualMovie = movieService.getMovieById(1L);

        assertNotNull(actualMovie);
        assertEquals(1L, actualMovie.getId());
        assertEquals("The Matrix", actualMovie.getTitle());
        assertEquals("Science Fiction", actualMovie.getGenre());
    }

    @Test
    void getMovieById_ShouldReturnNull() {
        when(movieRepository.findById(99L)).thenReturn(Optional.empty());

        Movie actualMovie = movieService.getMovieById(99L);

        assertNull(actualMovie);
    }
}