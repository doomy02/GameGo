package app.service.implementation;

import app.model.Game;
import app.model.User;
import app.repository.GameRepository;
import app.service.GameService;
import app.single_point_access.RepositorySinglePointAccess;

import java.util.List;

public class GameServiceImpl implements GameService {
    private GameRepository gameRepository = RepositorySinglePointAccess.getGameRepository();

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game update(Game game) {
        return gameRepository.update(game);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game findById(Integer id) {
        return gameRepository.findById(id);
    }

    @Override
    public Game findByName(String id) {
        return gameRepository.findByName(id);
    }

    @Override
    public boolean delete(Game game) {
        return gameRepository.delete(game);
    }
}
