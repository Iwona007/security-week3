package pl.iwona.securityweek3.model;

import javax.persistence.*;

@Entity
public class VerificationToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;
    private String valueAdmin;

    @OneToOne
    private ApiUser apiUser;

    public VerificationToken() {
    }

    public ApiUser getApiUser() {
        return apiUser;
    }

    public void setApiUser(ApiUser apiUser) {
        this.apiUser = apiUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueAdmin() {
        return valueAdmin;
    }

    public void setValueAdmin(String valueAdmin) {
        this.valueAdmin = valueAdmin;
    }
}
