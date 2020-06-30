package pl.iwona.securityweek3.exception;

public class TokenNotFoundException extends RuntimeException {
    public TokenNotFoundException(String value) {
        super(String.format("Token with value %S not exist", value));
    }
}
