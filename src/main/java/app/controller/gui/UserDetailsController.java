package app.controller.gui;

import app.model.User;
import app.service.UserService;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.SampleDetailsPerson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDetailsController {

    private SampleDetailsPerson sampleDetailsPerson;

    private UserService userService = ServiceSinglePointAccess.getUserService();


    public void startLogic(User user) {
        sampleDetailsPerson = new SampleDetailsPerson();
        GUIFrameSinglePointAccess.changePanel(sampleDetailsPerson.getPanel1(), "GameGO");

        sampleDetailsPerson.getNameValue().setText(user.getName());
        sampleDetailsPerson.getNicknameValue().setText(user.getNickname());
        sampleDetailsPerson.getNoGamesValue().setText(String.valueOf(user.getNoGames()));
        sampleDetailsPerson.getBalanceValue().setText(String.valueOf(String.format("%.2f", user.getBalance())));
        sampleDetailsPerson.getNoFriendsValue().setText(String.valueOf(user.getNoFriends()));

        sampleDetailsPerson.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuController menuController = new MenuController();
                menuController.startLogic(user);
            }
        });
    }
}

