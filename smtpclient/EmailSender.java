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
        System.out.println("port: <"+config.getPort()+">");
        System.out.println("Server: <"+config.getServer()+">");
        Socket socket = new Socket(config.getServer(), config.getPort());
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        if(in == null || out == null)
            System.out.println("Couldn't connect");
        PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
        System.out.println(socket.getInputStream());
//        pr.println("MAIL FROM: caca.boudin@caca.boudin");
//        for(int i = 0; i < 10; i++) {
//            pr.println("EHLO");
//            pr.println("MAIL FROM: henrik.akesson@heig-vd.ch");
//            pr.println("RCPT TO: fabien.salathe@heig-vd.ch");
//            pr.println("RCPT TO: fabacrans@gmail.com");
//            pr.println("RCPT TO: henrikake@gmail.com");
//            pr.println("DATA");
//            pr.println("Subject: caca\n");
//            pr.println("memekeemekemekemek");
//            pr.println(".");
//            pr.println("quit");
//        }
        for(Mail m: mails) {
            for(Person p: m.getTo()) {
                pr.println("EHLO");
                pr.println("MAIL FROM: " + m.getFrom().getEmail());
//                System.out.println("Sending to: " + p.getEmail());
                pr.println("RCPT TO: " + p.getEmail());
                pr.println("DATA");
                pr.println("Subject: " + m.getSubject() +"\n");
                pr.println(m.getBody());
                pr.println(".");
                pr.println("quit");

                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }}
        }
    }
}
