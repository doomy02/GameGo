package app.single_point_access;

import app.repository.GameRepository;
import app.repository.StoreRepository;
import app.repository.UserRepository;

import app.repository.implemetation.GameRepositoryImpl;
import app.repository.implemetation.StoreRepositoryImpl;
import app.repository.implemetation.UserRepositoryImpl;

public class RepositorySinglePointAccess {

    private static UserRepository userRepository;
    private static GameRepository gameRepository;

    private static StoreRepository storeRepository;

    static {
        userRepository = new UserRepositoryImpl();
        gameRepository = new GameRepositoryImpl();
        storeRepository = new StoreRepositoryImpl();
    }

    public static UserRepository getUserRepository() {
        return userRepository;
    }

    public static GameRepository getGameRepository() {
        return gameRepository;
    }

    public static StoreRepository getStoreRepository(){return storeRepository;}
}
