package app.controller.gui;

import app.model.Game;
import app.model.Store;
import app.model.User;
import app.service.GameService;
import app.service.UserService;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.StoreView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class StoreController {
    private StoreView storeView;

    public void startLogic(User user, Store store)
    {
        storeView = new StoreView();

        GUIFrameSinglePointAccess.changePanel(storeView.getStorePanel(), "GameGO");
        storeView.getBalanceValue().setText(String.valueOf(String.format("%.2f", user.getBalance())));

        for(int i = 0; i < store.getNoGames(); i++)
        {
            storeView.getComboBox1().addItem(store.getGames().get(i).getName());
        }

        storeView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuController menuController = new MenuController();
                menuController.startLogic(user);
            }
        });

        storeView.getAddBalanceButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double money = Double.valueOf(storeView.getBalanceTextFileld().getText());

                UserService userService = ServiceSinglePointAccess.getUserService();
                userService.addBalance(user, money);

                storeView.getBalanceValue().setText(String.valueOf(String.format("%.2f", user.getBalance())));
                storeView.getBalanceTextFileld().setText("");
            }
        });

        storeView.getViewDetailsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = storeView.getComboBox1().getSelectedItem().toString();

                GameService gameService = ServiceSinglePointAccess.getGameService();
                Game savedGame = gameService.findByName(name);

                storeView.getPriceValue().setText(String.valueOf(savedGame.getPrice()));
                storeView.getReviewsValue().setText(String.valueOf(savedGame.getNoReviews()));
                storeView.getTagValue().setText(savedGame.getTag());
            }
        });

        storeView.getBuyButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double money = user.getBalance();

                String name = storeView.getComboBox1().getSelectedItem().toString();
                GameService gameService = ServiceSinglePointAccess.getGameService();
                Game savedGame = gameService.findByName(name);

                Double gameValue = savedGame.getPrice();
                Boolean ok = true;
                if(money - gameValue >= 0)
                {
                    for(int i = 0; i < user.getNoGames(); i++)
                    {
                        if(Objects.equals(savedGame.getName(), user.getGames().get(i).getName()))
                        {
                            ok = false;
                            break;
                        }
                    }

                    if(ok) {
                        UserService userService = ServiceSinglePointAccess.getUserService();
                        userService.addGame(user, savedGame);
                        user.setBalance(money - gameValue);

                        userService.update(user);
                        storeView.getBalanceValue().setText(String.valueOf(String.format("%.2f", user.getBalance())));
                        storeView.getReviewsValue().setText(String.valueOf(savedGame.getNoReviews()));
                    }
                    else
                    {
                        GUIFrameSinglePointAccess.showDialogMessage("This game is already in your library!");
                    }
                }
                else
                {
                    GUIFrameSinglePointAccess.showDialogMessage("Insufficient balance!");
                }
            }
        });

    }
}
