package app.repository;

import app.model.User;

public interface UserRepository extends CRUDRepository<User, Integer> {
    User findByNickame(String nickname);

    User findByNameAndPassword(String name, String password);

    User findFavoriteGame();

    User register(String name, String password, String nickname);
}
