package app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@NamedQueries(
        {@NamedQuery(name = "findUserByNickname", query = "from User users where users.nickname = :nickname"),
                @NamedQuery(name = "findUserByNameAndPassword", query = "from User users where users.name = :name and users.password=:password"),
                @NamedQuery(name = "findUserById", query = "from User users where users.id = :id"),
                @NamedQuery(name = "findAllUsers", query = "from User")
        }
)
public class User implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String password;
    private String name;
    private String nickname;
    private Integer noGames = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    private Game favoriteGame = null;
    private Double balance = 0.0;
    private Integer noFriends = 0;
    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> games;
    @Column
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> friends;

    public Integer getNoFriends() {
        return noFriends;
    }

    public void setNoFriends(Integer noFriends) {
        this.noFriends = noFriends;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer userID) {
        this.id = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getNoGames() {
        return noGames;
    }

    public void setNoGames(Integer noGames) {
        this.noGames = noGames;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public Game getFavoriteGame() {
        return favoriteGame;
    }

    public void setFavoriteGame(Game favoriteGame) {
        this.favoriteGame = favoriteGame;
    }
}
