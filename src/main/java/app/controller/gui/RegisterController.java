package app.controller.gui;

import app.model.User;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.RegisterView;
import app.service.UserService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterController {
    private RegisterView registerView;
    private UserService userService = ServiceSinglePointAccess.getUserService();

    public void startLogic()
    {
        registerView = new RegisterView();
        GUIFrameSinglePointAccess.changePanel(registerView.getPanel1(), "GameGO");

        registerView.getBackButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        });

        registerView.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = registerView.getNameTextLabel().getText();
                String nickname = registerView.getNicknameTextLabel().getText();
                String password = registerView.getPasswordTextLabel().getText();
                Boolean details = true;
                if (registerView.getNameTextLabel().getText().isEmpty() || registerView.getNicknameTextLabel().getText().isEmpty() || registerView.getPasswordTextLabel().getText().isEmpty()) {
                    GUIFrameSinglePointAccess.showDialogMessage("Please fill in your account details!!");
                    details = false;
                }

                if (details) {
                    User user = userService.login(name, password);
                    if (user != null) {
                        GUIFrameSinglePointAccess.showDialogMessage("Username or nickname already in use!");
                    } else {
                        UserService userService = ServiceSinglePointAccess.getUserService();
                        User savedUser = userService.register(name, password, nickname);

                        registerView.getNameTextLabel().setText("");
                        registerView.getPasswordTextLabel().setText("");
                        registerView.getNicknameTextLabel().setText("");

                        GUIFrameSinglePointAccess.showDialogMessage("Welcome " + savedUser.getNickname() + "!");
                    }
                }
            }
        });
    }
}
