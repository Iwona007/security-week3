package pl.iwona.securityweek3.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogin {

    @Id
    private String series;

    @Column(name= "username", nullable = false)
    private String username;

    @Column(name= "token", nullable = false)
    private String token;

    @Column(name = "task_used", nullable = false)
    private LocalDate lastUsed;

    public PersistentLogin() {
    }

    public PersistentLogin(String series, String username, String token, LocalDate lastUsed) {
    this.series = series;
    this.username = username;
    this.token = token;
    this.lastUsed = lastUsed;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDate getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDate lastUsed) {
        this.lastUsed = lastUsed;
    }
}
