package app.controller.gui;

import app.model.Game;
import app.model.User;
import app.service.GameService;
import app.service.UserService;
import app.service.implementation.GameServiceImpl;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.RepositorySinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.GameDetailsView;
import app.view.LibraryView;
import org.jboss.logging.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryController {
    private LibraryView libraryView;

    public void startLogic(User user)
    {
        libraryView = new LibraryView();

        GUIFrameSinglePointAccess.changePanel(libraryView.getPanel1(), "GameGO");

        for(int i = 0; i < user.getNoGames(); i++)
        {
            libraryView.getComboLabel().addItem(user.getGames().get(i).getName());
        }

        libraryView.getDetailsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = libraryView.getComboLabel().getSelectedItem().toString();

                GameService gameService = ServiceSinglePointAccess.getGameService();
                Game savedGame = gameService.findByName(name);

                GameDetailsController gameDetailsController = new GameDetailsController();
                gameDetailsController.startLogic(user, savedGame);
            }
        });

        libraryView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuController menuController = new MenuController();
                menuController.startLogic(user);
            }
        });

        libraryView.getFavoriteButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = libraryView.getComboLabel().getSelectedItem().toString();

                GameService gameService = ServiceSinglePointAccess.getGameService();
                Game savedGame = gameService.findByName(name);

                UserService userService = ServiceSinglePointAccess.getUserService();
                userService.addFavoriteGame(user, savedGame);

                userService.update(user);

                GUIFrameSinglePointAccess.showDialogMessage("'" + savedGame.getName() + "' is now your favorite game!");
            }
        });
    }
}
