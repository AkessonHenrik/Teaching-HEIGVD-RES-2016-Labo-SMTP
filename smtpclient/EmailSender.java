package smtpclient;

import mail.Mail;
import parsers.ConfigParser;
import people.Person;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

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

    public void sendEmails() throws IOException {
        System.out.println("port: <" + config.getPort() + ">");
        System.out.println("Server: <" + config.getServer() + ">");
        Socket socket = new Socket(config.getServer(), config.getPort());
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        if (in == null || out == null)
            System.out.println("Couldn't connect");
        PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
        System.out.println(socket.getInputStream());
        for (Mail m : mails) {
            pr.println("EHLO");
            pr.println("MAIL FROM: " + m.getFrom().getEmail());
//                System.out.println("Sending to: " + p.getEmail());
            for (Person p : m.getTo()) {
                pr.println("RCPT TO: " + p.getEmail());
            }
            pr.println("DATA");
            pr.println("From: " + m.getFrom().getEmail());
            pr.print("To: ");
            for(Person p : m.getTo()) {
                pr.print(p.getEmail()+", ");
            }
            pr.print('\n');
            pr.println("Cc: " + config.getWitness());
            pr.println("Subject: " + m.getSubject() + '\n');
            pr.println(m.getBody());
            pr.println(".");
            pr.println("quit");

            try {
                sleep(config.getTimeOut());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
