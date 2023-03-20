package app.model;

import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table
@NamedQuery(name = "findStoreById", query = "from Store store where store.id = :id")
public class Store {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Game> games;

    private Integer noGames = 0;

    public Integer getNoGames() {
        return noGames;
    }

    public void setNoGames(Integer noGames) {
        this.noGames = noGames;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Game> getGames() {
        return this.games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}

