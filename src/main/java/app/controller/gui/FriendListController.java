package app.controller.gui;

import app.model.User;
import app.service.UserService;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.FriendListView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FriendListController {
    private FriendListView friendListView;

    public void startLogic(User user)
    {
        friendListView = new FriendListView();

        GUIFrameSinglePointAccess.changePanel(friendListView.getFriendListPanel(), "GameGO");
        for(int i = 0; i < user.getNoFriends(); i++)
        {
            friendListView.getComboBox1().addItem(user.getFriends().get(i).getNickname());
        }

        friendListView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MenuController menuController = new MenuController();
                menuController.startLogic(user);
            }
        });

        friendListView.getShowDetailsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nickname = friendListView.getComboBox1().getSelectedItem().toString();

                UserService userService = ServiceSinglePointAccess.getUserService();
                User savedUser = userService.findByNickname(nickname);

                FriendController friendController = new FriendController();
                friendController.startLogic(user, savedUser);
            }
        });

        friendListView.getAddFriendButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddFriendController addFriendController = new AddFriendController();
                addFriendController.startLogic(user);
            }
        });
    }
}
