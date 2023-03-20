package app;

import app.controller.gui.LoginController;
import app.model.Game;

import app.model.Store;
import app.model.User;
import app.service.GameService;

import app.service.StoreService;
import app.service.UserService;
import app.service.implementation.UserServiceImpl;
import app.single_point_access.ServiceSinglePointAccess;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


@SpringBootApplication
public class Main {

    private static final String APPLICATION_CONFIGURATION_FILE = "app.configuration.properties";

    public static void main(String[] args) {

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream(APPLICATION_CONFIGURATION_FILE)) {
            Properties properties = new Properties();
            properties.load(input);

            // Decide app mode from file
            String mode = properties.getProperty("mode");

            if (mode.equals("web")) {
                SpringApplication.run(Main.class, args);
            } else {
                LoginController loginController = new LoginController();
                loginController.startLogic();
            }
        } catch (Exception ex) {
            System.out.println("Error at starting application...");
            ex.printStackTrace();
        }

         //Test implementation
        Game g1 = new Game();
        g1.setName("Slay the Spire");
        g1.setPrice(16.9);
        g1.setTag("Deckbuilder");

        Game g2 = new Game();
        g2.setName("Fallout 4");
        g2.setPrice(30.0);
        g2.setTag("RPG");

        Game g3 = new Game();
        g3.setName("Skyrim");
        g3.setPrice(15.99);
        g3.setTag("RPG");

        Game g4 = new Game();
        g4.setName("FIFA23");
        g4.setTag("Sports");
        g4.setPrice(60.0);

        Game g5 = new Game();
        g5.setName("The Witcher 3");
        g5.setPrice(30.0);
        g5.setTag("RPG");

        Game g6 = new Game();
        g6.setName("Project Zomboid");
        g6.setPrice(15.99);
        g6.setTag("Survival");

        Game g7 = new Game();
        g7.setName("Terraria");
        g7.setPrice(10.0);
        g7.setTag("Sandbox");

        Game g8 = new Game();
        g8.setName("Dead Cells");
        g8.setPrice(12.3);
        g8.setTag("Roguelike");

        Game g9 = new Game();
        g9.setName("Subnautica");
        g9.setPrice(23.5);
        g9.setTag("Open World");

        Game g10 = new Game();
        g10.setName("Elden Ring");
        g10.setPrice(60.0);
        g10.setTag("Soulslike");

        User u = new User();
        u.setName("Sebica");
        u.setPassword("1234");
        u.setNickname("Doomy");

        GameService gameService = ServiceSinglePointAccess.getGameService();
        gameService.save(g1);
        gameService.save(g2);
        gameService.save(g3);
        gameService.save(g4);
        gameService.save(g5);
        gameService.save(g6);
        gameService.save(g7);
        gameService.save(g8);
        gameService.save(g9);
        gameService.save(g10);

        Store s = new Store();
        StoreService storeService = ServiceSinglePointAccess.getStoreService();
        storeService.save(s);
        storeService.addGameStore(s, g1);
        storeService.addGameStore(s, g2);
        storeService.addGameStore(s, g3);
        storeService.addGameStore(s, g4);
        storeService.addGameStore(s, g5);
        storeService.addGameStore(s, g6);
        storeService.addGameStore(s, g7);
        storeService.addGameStore(s, g8);
        storeService.addGameStore(s, g9);
        storeService.addGameStore(s, g10);

        UserService userService = ServiceSinglePointAccess.getUserService();
        userService.save(u);
    }
}
