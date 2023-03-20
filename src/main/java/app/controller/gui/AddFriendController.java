package app.controller.gui;

import app.model.User;
import app.service.UserService;
import app.service.implementation.UserServiceImpl;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.AddFriendView;
import net.bytebuddy.asm.Advice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AddFriendController {
    private AddFriendView addFriendView;

    public void startLogic(User user)
    {
        addFriendView = new AddFriendView();

        GUIFrameSinglePointAccess.changePanel(addFriendView.getPanel1(), "GameGO");

        addFriendView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FriendListController friendListController = new FriendListController();
                friendListController.startLogic(user);
            }
        });

        addFriendView.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String friendNickname = addFriendView.getTextField1().getText();

                UserService userService = ServiceSinglePointAccess.getUserService();
                User friend = userService.findByNickname(friendNickname);

                Boolean ok = true;
                for(int i = 0; i < user.getNoFriends(); i++)
                {
                    if(Objects.equals(friendNickname, user.getFriends().get(i).getNickname()))
                    {
                        GUIFrameSinglePointAccess.showDialogMessage(friendNickname + " is already your friend!");
                        addFriendView.getTextField1().setText("");
                        ok = false;

                        FriendListController friendListController = new FriendListController();
                        friendListController.startLogic(user);
                    }
                }

                if(Objects.equals(user.getName(), friend.getName()))
                {
                    GUIFrameSinglePointAccess.showDialogMessage("You can not add yourself as a friend!");
                    addFriendView.getTextField1().setText("");
                    ok = false;
                }

                if(Objects.equals(friendNickname, ""))
                {
                    GUIFrameSinglePointAccess.showDialogMessage("Please enter a nickname!");
                    addFriendView.getTextField1().setText("");
                    ok = false;
                }

                if(friend == null)
                {
                    GUIFrameSinglePointAccess.showDialogMessage("Nickname '" +friendNickname + "' does not exist!");
                    addFriendView.getTextField1().setText("");
                    ok = false;
                }

                if(ok)
                {
                    if(friend != null)
                    {
                        userService.addFriend(user, friend);
                        GUIFrameSinglePointAccess.showDialogMessage("Friend added!");

                        FriendListController friendListController = new FriendListController();
                        friendListController.startLogic(user);
                    }
                    else
                    {
                        GUIFrameSinglePointAccess.showDialogMessage("Nickname '" +friendNickname + "' does not exist!");
                        addFriendView.getTextField1().setText("");
                    }
                }

            }
        });
    }
}
