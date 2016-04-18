package app;

public class Mail {
    private String from;
    private String to;
    private String subject;
    private String body;
    private String viewFrom;
    private String viewTo;

    public Mail(String from, String to, String subject, String body, String viewFrom, String viewTo) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.viewFrom = viewFrom;
        this.viewTo = viewTo;
    }
}