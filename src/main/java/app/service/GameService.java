package app.service;

import app.model.Game;

import java.util.List;

public interface GameService {
    Game save(Game game);

    Game update(Game game);

    List<Game> findAll();

    Game findById(Integer id);

    Game findByName(String id);

    boolean delete(Game game);
}
