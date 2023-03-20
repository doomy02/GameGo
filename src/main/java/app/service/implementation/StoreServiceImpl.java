package app.service.implementation;

import app.configuration.HibernateConfiguration;
import app.model.Game;
import app.model.Store;
import app.repository.GameRepository;
import app.repository.StoreRepository;
import app.service.GameService;
import app.service.StoreService;
import app.single_point_access.RepositorySinglePointAccess;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StoreServiceImpl implements StoreService {
    private StoreRepository storeRepository = RepositorySinglePointAccess.getStoreRepository();
    private GameRepository gameRepository = RepositorySinglePointAccess.getGameRepository();

    @Override
    public Store findById(Integer id) {return storeRepository.findById(id);}

    @Override
    public Store save(Store store){return storeRepository.save(store);}

    @Override
    public void addGameStore(Store store, Game game)
    {
        if (store.getGames() == null) {
            store.setGames(new ArrayList<>());
        }
        if (game.getId() == null || gameRepository.findById(game.getId()) == null) {
            game = gameRepository.save(game);
        }

        store.getGames().add(game);
        Integer aux = store.getNoGames() + 1;
        store.setNoGames(aux);

        storeRepository.update(store);
    }
}
