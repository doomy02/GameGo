package app.controller.gui;

import app.model.Store;
import app.model.User;
import app.service.StoreService;
import app.service.UserService;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController {
    private MenuView menuView;
    private LoginView loginView;
    private FavoriteGameView favoriteGameView;

    private StoreView storeView;
    private LibraryView libraryView;

    private UserService userService = ServiceSinglePointAccess.getUserService();

    public void startLogic(User user) {
        menuView = new MenuView();
        loginView = new LoginView();
        favoriteGameView = new FavoriteGameView();
        libraryView = new LibraryView();

        GUIFrameSinglePointAccess.changePanel(menuView.getMenuPanel(), "GameGO");

        menuView.getLogoutButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        menuView.getAccountDetailsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserDetailsController personDetailsController = new UserDetailsController();
                personDetailsController.startLogic(user);
            }
        });

        menuView.getFavoriteGameButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(user.getFavoriteGame() != null)
                {
                    FavoriteGameController favoriteGameController = new FavoriteGameController();
                    favoriteGameController.startLogic(user);
                }
               else
                {
                    GUIFrameSinglePointAccess.showDialogMessage("No favorite game!");
                }
            }
        });

        menuView.getLibraryButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibraryController libraryController = new LibraryController();
                libraryController.startLogic(user);
            }
        });

        menuView.getFriendsListButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FriendListController friendListController = new FriendListController();
                friendListController.startLogic(user);
            }
        });

        menuView.getStoreButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StoreService storeService = ServiceSinglePointAccess.getStoreService();
                Store store = storeService.findById(1);

                StoreController storeController = new StoreController();
                storeController.startLogic(user, store);
            }
        });

    }
}
