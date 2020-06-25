package pl.iwona.securityweek3.exception;

public class TokenNotFind extends RuntimeException {
    public TokenNotFind(String value) {
        super(String.format("Token with value %S not exist", value));
    }
}
