package movies.moviedemo.domain;

import movies.moviedemo.enums.Genre;
import movies.moviedemo.enums.Rating;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    private Long id;

    private String title;
    private String description;
    private Boolean recommended;
    private String cast;

    @Enumerated(EnumType.STRING)
    private Rating rating;
    private Genre genre;

//    private Double score_average;

    public Movie() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getRecommended() {
        return recommended;
    }

    public void setRecommended(Boolean recommended) {
        this.recommended = recommended;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", recommended=" + recommended +
                ", cast='" + cast + '\'' +
                ", rating=" + rating +
                ", genre=" + genre +
                '}';
    }
}
