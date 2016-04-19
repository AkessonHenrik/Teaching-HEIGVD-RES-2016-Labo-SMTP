package smtpclient;

import mail.Mail;

import java.util.ArrayList;

/**
 * Created by Henrik on 19.04.2016.
 */
public class EmailSender {
    private final ArrayList<Mail> mails;

    public EmailSender(ArrayList<Mail> mailsToSend) {
        this.mails = mailsToSend;
    }

    public void sendEmails() {
        
    }
}
