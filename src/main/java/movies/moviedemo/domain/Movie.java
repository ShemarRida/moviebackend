package movies.moviedemo.domain;

import javax.persistence.*;

@Entity
public class Movie {
    @Id
    private Long id;

    private String title;
    private String description;
    private Boolean recommended;
    private String cast;

//    private Character rating;
//    private Double score_average;

    public Movie() {
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

//    public Character getRating() {
//        return rating;
//    }
//
//    public void setRating(Character rating) {
//        this.rating = rating;
//    }
//
//    public Double getScore_average() {
//        return score_average;
//    }
//
//    public void setScore_average(Double score_average) {
//        this.score_average = score_average;
//    }

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

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", recommended=" + recommended +
                ", cast=" + cast +
//                ", rating=" + rating +
//                ", score_average=" + score_average +
                '}';
    }
}
