package mail;

//Contains the subject and body of an email
public class MailContent {
    private String subject;

    private String body;

    public String getBody() {
        return body;
    }

    public MailContent(String subject, String body) {
        this.body = body;
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
