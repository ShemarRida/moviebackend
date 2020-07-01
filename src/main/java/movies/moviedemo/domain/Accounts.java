package movies.moviedemo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {

    @Id
    private Long userId;

    private String first_name;
    private String last_name;
    private String username;
    private String password;
    private Boolean staySignedIn;

    public Accounts(){ }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStaySignedIn() {
        return staySignedIn;
    }

    public void setStaySignedIn(Boolean staySignedIn) {
        this.staySignedIn = staySignedIn;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "userId=" + userId +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", staySignedIn=" + staySignedIn +
                '}';
    }
}
