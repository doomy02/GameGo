package app.controller.gui;

import app.model.User;
import app.service.UserService;
import app.single_point_access.GUIFrameSinglePointAccess;
import app.single_point_access.ServiceSinglePointAccess;
import app.view.LoginView;
import app.view.MenuView;
import app.view.SampleLogin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {

    private SampleLogin sampleLogin;
    private MenuView menuView;

    private UserService userService = ServiceSinglePointAccess.getUserService();

    public void startLogic() {
        sampleLogin = new SampleLogin();
        GUIFrameSinglePointAccess.changePanel(sampleLogin.getLoginPanel(), "GameGO");

        sampleLogin.getLogInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = sampleLogin.getTextFieldName().getText();
                String password = new String(sampleLogin.getPasswordField().getPassword());

                User user = userService.login(name, password);
                if (user != null) {
                    MenuController menuController = new MenuController();
                    menuController.startLogic(user);
                } else {
                    GUIFrameSinglePointAccess.showDialogMessage("Invalid username or password");
                }
            }
        });

        sampleLogin.getRegisterButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterController registerController = new RegisterController();
                registerController.startLogic();
            }
        });
    }
}
