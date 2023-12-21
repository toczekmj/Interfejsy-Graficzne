package pl.interfejsygraficzne.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movieId;
    @NotNull(message = "Pole nie może zostać puste.")
    private String title;
    @NotNull
    private String director;
    @NotNull
    @Range(min = 1800, max = 2024)
    private Integer productionYear;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rating_id", referencedColumnName = "ratingId")
    private Rating rating;

    @NotNull
    private String description;
    @ManyToMany(mappedBy = "movies", cascade = CascadeType.REMOVE)
    private List<Actor> actors;


    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<Comment> comments;

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addActor(Actor actor){
        actors.add(actor);
        actor.getMovies().add(this);
    }

    public void removeActor(Actor actor){
        this.actors.remove(actor);
        actor.getMovies().remove(this);
    }
}
