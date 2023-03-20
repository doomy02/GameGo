package app.model;

import lombok.Data;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table
@NamedQueries(
        {@NamedQuery(name = "findGameById", query = "from Game game where game.id = :id"),
        @NamedQuery(name = "findGameByName", query = "from Game game where game.name =: name")
        })
public class Game  implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer id;
    @Column
    private String name;
    @Column
    private String tag;
    @Column
    private String about;
    @Column
    private Integer noReviews = 0;
    @Column
    private Double price;

    public Game() {
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer gameID) {
        this.id = gameID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getNoReviews() {
        return this.noReviews;
    }

    public void setNoReviews(Integer noReviews) {
        this.noReviews = noReviews;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTag() {
        return this.tag;
    }
    public void setTag(String tag)
    {
        this.tag = tag;
    }
}
