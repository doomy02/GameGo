package app.controller.gui;

import app.model.Game;
import app.model.User;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.GameDetailsView;
import app.view.LibraryView;
import app.view.SampleDetailsGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDetailsController {
    private GameDetailsView gameDetailsView;

    public void startLogic(User user, Game game)
    {
        gameDetailsView = new GameDetailsView();
        GUIFrameSinglePointAccess.changePanel(gameDetailsView.getDetailsPanel(), "GameGO");

        gameDetailsView.getNameValue().setText(game.getName());
        gameDetailsView.getPriceValue().setText(String.valueOf(game.getPrice()));
        gameDetailsView.getNoReviewsValue().setText(String.valueOf(game.getNoReviews()));
        gameDetailsView.getTagValue().setText(game.getTag());

        gameDetailsView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LibraryController libraryController = new LibraryController();
                libraryController.startLogic(user);
            }
        });
    }
}
