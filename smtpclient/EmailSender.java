package smtpclient;

import mail.Mail;
import parsers.ConfigParser;

import java.io.*;
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

    public void sendEmails() throws IOException {
        System.out.println("port: <"+config.getPort()+">");
        System.out.println("Server: <"+config.getServer()+">");
        Socket socket = new Socket(config.getServer(), config.getPort());
        OutputStream out = socket.getOutputStream();
        InputStream in = socket.getInputStream();
        if(in == null || out == null)
            System.out.println("Couldn't connect");
        PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
        pr.println("EHLO");
        System.out.println(socket.getInputStream());
        pr.println("MAIL FROM: caca.boudin@caca.boudin");
        pr.println("RCPT TO: henrikake@gmail.com");
        pr.println("DATA");
        pr.println("Subject: caca\n");
        pr.println("From: caca\n");
        pr.println("oasidjoaisjdoaijsoidj");
        pr.println(".");
        pr.println("quit");
//        socket.close();
    }
}
