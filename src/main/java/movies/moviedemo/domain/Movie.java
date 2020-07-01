package movies.moviedemo.domain;

import movies.moviedemo.enums.Genre;
import movies.moviedemo.enums.Rating;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
public class Movie {
    @Id
    private Long id;

    private String title;
    private String description;
    private Boolean recommended;
    private String cast;
    private String release_date;
    private Integer duration;

    @Enumerated(EnumType.STRING)
    private Rating rating;
    private Genre genre;

    @ManyToOne
    private Accounts accounts;

    public Movie() { }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

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

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
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
                ", release_date='" + release_date + '\'' +
                ", duration=" + duration +
                ", rating=" + rating +
                ", genre=" + genre +
                ", accounts=" + accounts +
                '}';
    }
}
