package app.controller.gui;

import app.model.User;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.view.FriendDetailsView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FriendController {
    private FriendDetailsView friendDetailsView;

    public void startLogic(User user, User user2)
    {
        friendDetailsView = new FriendDetailsView();

        GUIFrameSinglePointAccess.changePanel(friendDetailsView.getFriendListPanel(), "GameGO");

        friendDetailsView.getNicknameValue().setText(user2.getNickname());
        friendDetailsView.getNoGamesValue().setText(String.valueOf(user2.getNoGames()));
        friendDetailsView.getNoFriendsValue().setText(String.valueOf(user2.getNoFriends()));
        if(user2.getFavoriteGame() != null)
        {
            friendDetailsView.getFavoriteGameValue().setText(user2.getFavoriteGame().getName());
        }
        else
        {
            friendDetailsView.getFavoriteGameValue().setText("Non");
        }

        friendDetailsView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FriendListController friendListController = new FriendListController();
                friendListController.startLogic(user);
            }
        });
    }
}
