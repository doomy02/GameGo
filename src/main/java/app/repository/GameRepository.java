package app.repository;

import app.model.Game;

public interface GameRepository  extends CRUDRepository<Game, Integer>{
    Game findByName(String id);
}
