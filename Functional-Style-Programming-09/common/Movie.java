import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Movie {

    private String name;
    private double rating;
    private String genre;

    @Override
    public String toString() {
        return "Movie{" + name + '}';
    }

    public Movie(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public Movie(String name, double rating, String genre) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
    }
}
