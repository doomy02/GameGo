package app.single_point_access;

import app.service.GameService;
import app.service.StoreService;
import app.service.UserService;
import app.service.implementation.GameServiceImpl;
import app.service.implementation.StoreServiceImpl;
import app.service.implementation.UserServiceImpl;

public class ServiceSinglePointAccess {

    private static UserService userService;
    private static GameService gameService;
    private static StoreService storeService;

    static {
        userService = new UserServiceImpl();
        gameService = new GameServiceImpl();
        storeService = new StoreServiceImpl();
    }

    public static UserService getUserService() {
        return userService;
    }

    public static GameService getGameService() {
        return gameService;
    }

    public static StoreService getStoreService(){return storeService;}
}
