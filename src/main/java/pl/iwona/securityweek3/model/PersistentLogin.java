package pl.iwona.securityweek3.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persistent_logins")
public class PersistentLogin {
    @Id
    private String series;

    private String username;
    private String token;
    @Column(name= "last_used")
    private LocalDate lastUsed;

}
