package pl.iwona.securityweek3.model;

public enum Role {
    USER,
    ADMIN,
    MODERATOR;

    public String getName() {
      return this.name();
    }
}
