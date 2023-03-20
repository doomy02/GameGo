package app.controller.gui;

import app.model.User;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.FavoriteGameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FavoriteGameController {
    private FavoriteGameView favoriteGameView;
    public void startLogic(User user) {
        favoriteGameView = new FavoriteGameView();
        GUIFrameSinglePointAccess.changePanel(favoriteGameView.getFavoriteGamePanel(), "GameGO");

        favoriteGameView.getNameValue().setText(user.getFavoriteGame().getName());
        favoriteGameView.getPriceValue().setText(String.valueOf(user.getFavoriteGame().getPrice()));
        favoriteGameView.getNoReviewsValue().setText(String.valueOf(user.getFavoriteGame().getNoReviews()));
        favoriteGameView.getTagValue().setText(user.getFavoriteGame().getTag());

        favoriteGameView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuController menuController = new MenuController();
                menuController.startLogic(user);
            }
        });
    }
}
