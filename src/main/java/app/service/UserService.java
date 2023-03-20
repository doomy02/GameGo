package app.service;

import app.model.Game;
import app.model.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User update(User user);

    List<User> findAll();

    User findById(Integer id);

    User findByNickname(String nickname);

    boolean delete(User user);

    void addGame(User user, Game game);

    void addFavoriteGame(User user, Game game);

    void addFriend(User user, User user2);

    User register(String name, String password, String nickname);

    User login(String name, String password);

    void addBalance(User user, Double balance);
}

