package com.example.gameflix.service;

import com.example.gameflix.model.Game;

import java.util.List;

public interface GameService {

    List<Game> getAllGames();

    Game getGameById(Long id);

    Game saveGame(Game game);

}