package com.example.gameflix.service;

import com.example.gameflix.model.Game;
import com.example.gameflix.repository.GameRepository;
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
class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    private GameService gameService;

    @BeforeEach
    void setUp() {
        gameService = new GameServiceImpl(gameRepository);
    }

    @Test
    void getAllGames_ShouldReturnList() {
        Game game1 = new Game(1L, "The Legend of Zelda", "Adventure");
        Game game2 = new Game(2L, "Minecraft", "Sandbox");

        List<Game> expectedGames = List.of(game1, game2);

        when(gameRepository.findAll()).thenReturn(expectedGames);

        List<Game> actualGames = gameService.getAllGames();

        assertEquals(2, actualGames.size());
        assertEquals("The Legend of Zelda", actualGames.get(0).getTitle());
        assertEquals("Minecraft", actualGames.get(1).getTitle());
    }

    @Test
    void getGameById_ShouldReturnGame() {
        Game expectedGame =
                new Game(1L, "The Legend of Zelda", "Adventure");

        when(gameRepository.findById(1L))
                .thenReturn(Optional.of(expectedGame));

        Game actualGame = gameService.getGameById(1L);

        assertNotNull(actualGame);
        assertEquals(1L, actualGame.getId());
        assertEquals("The Legend of Zelda", actualGame.getTitle());
        assertEquals("Adventure", actualGame.getGenre());
    }

    @Test
    void getGameById_ShouldReturnNull() {
        when(gameRepository.findById(99L))
                .thenReturn(Optional.empty());

        Game actualGame = gameService.getGameById(99L);

        assertNull(actualGame);
    }
}