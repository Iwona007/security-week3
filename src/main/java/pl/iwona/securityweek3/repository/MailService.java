package pl.iwona.securityweek3.repository;

public interface MailService {

    void sendMail(String to, String subject, String text,
                  boolean isHtmlContent);
}
