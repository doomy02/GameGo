package app.service;

import app.model.Game;
import app.model.Store;

public interface StoreService {
    Store findById(Integer id);
    void addGameStore(Store store, Game game);
    Store save(Store store);
}
