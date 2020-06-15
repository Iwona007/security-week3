package pl.iwona.securityweek3.model;

public enum Role {
    USER,ADMIN;

    private String getName() {
      return  this.name();
    }
}
