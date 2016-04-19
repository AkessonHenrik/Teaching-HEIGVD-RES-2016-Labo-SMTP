package smtpclient;

import mail.Mail;
import parsers.ConfigParser;
import sun.net.smtp.SmtpClient;

import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Henrik on 19.04.2016.
 */
public class EmailSender {
    private final ArrayList<Mail> mails;
    private final ConfigParser config;

    public EmailSender(ArrayList<Mail> mailsToSend, ConfigParser config) {
        this.mails = mailsToSend;
        this.config = config;
    }

    public void sendEmails() {

    }
}
