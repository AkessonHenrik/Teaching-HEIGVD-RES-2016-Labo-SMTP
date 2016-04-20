package smtpclient;

import mail.Mail;
import parsers.ConfigParser;
import people.Person;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class EmailSender {

    private final ArrayList<Mail> mails;
    private final ConfigParser config;
    private PrintWriter pr;

    public EmailSender(ArrayList<Mail> mailsToSend, ConfigParser config) throws IOException {

        this.mails = mailsToSend;
        this.config = config;
        Socket socket = new Socket(config.getServer(), config.getPort());
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        if (in == null || out == null)
            System.out.println("Couldn't connect");

        //We wrap the outputstream with a PrintWriter, since we will be writing text to it
        pr = new PrintWriter(socket.getOutputStream(), true);
    }

    public void sendEmails() throws IOException {

        //For all mails in list
        for (Mail m : mails) {

            pr.println("EHLO");
            pr.println("MAIL FROM: " + m.getFrom().getEmail());

            //One "RCPT TO: <email address>" for each victim
            for (Person p : m.getTo()) {
                pr.println("RCPT TO: " + p.getEmail());
            }
            pr.println("DATA");
            pr.println("From: " + m.getFrom().getEmail());
            pr.print("To: ");
            for (Person p : m.getTo()) {
                pr.print(p.getEmail() + ", ");
            }
            pr.print('\n');
            pr.println("Cc: " + config.getWitness());
            pr.println("Subject: " + m.getSubject() + '\n');
            pr.println(m.getBody());
            pr.println(".");
            pr.println("quit");

            //The program sleeps for the amount of time specified in the config file
            try {
                sleep(config.getTimeOut());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
