package app.service.implementation;

import app.model.Game;
import app.model.User;

import app.repository.GameRepository;
import app.repository.UserRepository;
import app.service.UserService;
import app.single_point_access.RepositorySinglePointAccess;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository = RepositorySinglePointAccess.getUserRepository();
    private GameRepository gameRepository = RepositorySinglePointAccess.getGameRepository();

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        return userRepository.update(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean delete(User user) {
        return userRepository.delete(user);
    }

    @Override
    public User findByNickname(String nickname)
    {
        return userRepository.findByNickame(nickname);
    }

    @Override
    public User register(String name, String password, String nickname){return userRepository.register(name, password, nickname);}

    @Override
    public void addGame(User user, Game game) {
        if (user.getGames() == null) {
            user.setGames(new ArrayList<>());
        }

        if (game.getId() == null || gameRepository.findById(game.getId()) == null) {
            game = gameRepository.save(game);
        }

        user.getGames().add(game);
        Integer aux = user.getNoGames() + 1;
        game.setNoReviews(game.getNoReviews() + 1);
        user.setNoGames(aux);

        userRepository.update(user);
        gameRepository.update(game);
    }

    @Override
    public void addFriend(User user, User user2)
    {
        if (user.getNoFriends() == null) {
            user.setFriends(new ArrayList<>());
        }

        List<User> aux = new ArrayList<>();
        aux.add(user2);
        if(user.getFriends() != null)
        {
            for (User friends: user.getFriends()) {
            aux.add(friends);
            }
        }

        List<User> aux2 = new ArrayList<>();
        aux2.add(user);
        if(user2.getFriends() != null)
        {
            for (User friends: user2.getFriends()) {
                aux2.add(friends);
            }
        }

        user.setFriends(aux);
        user2.setFriends(aux2);

        user.setNoFriends(user.getNoFriends() + 1);
        user2.setNoFriends(user2.getNoFriends() + 1);

        userRepository.update(user);
        userRepository.update(user2);
    }


    @Override
    public void addFavoriteGame(User user, Game game)
    {
        if(user.getFavoriteGame() == null)
        {
            user.setFavoriteGame(new Game());
        }

        user.setFavoriteGame(game);

        userRepository.update(user);
    }

    @Override
    public void addBalance(User user, Double balance)
    {
        Double money = user.getBalance();
        money += balance;
        user.setBalance(money);

        userRepository.update(user);
    }

    @Override
    public User login(String name, String password) {
        return userRepository.findByNameAndPassword(name, password);
    }


}
