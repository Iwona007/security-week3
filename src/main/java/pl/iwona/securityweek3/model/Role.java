package pl.iwona.securityweek3.model;

public enum Role {
    USER,
    ADMIN,
    MODERATOR;

    public String getName() {
      return this.name();
    }

//public static Role getName(String role) {
//    return Role.getName(role)[role]
//    }
}
