package app.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(
        name = "LIBRARY"
)
public class Library {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer userID;
    @Column(
            name = "GAMES"
    )
    @OneToMany
    private List<Game> games;

    public Library() {
    }

    public Integer getUserID() {
        return this.userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
