package app;

import people.Person;
import mail.Mail;
import mail.MailCreator;
import parsers.*;
import people.Group;
import smtpclient.EmailSender;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PrankGenerator {
    public static void main(String... args) {

        //Reading and testing configuration file
        ConfigParser configParser;
        try {
            configParser = new ConfigParser(new File("resources/smtp.config"));
        } catch (IOException e) {
            System.out.println("Invalid configuration file, aborting program");
            return;
        }

        //Reading the list of victims
        VictimParser vp;
        try {
            vp = new VictimParser(new File("resources/victims.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Invalid victims file, aborting program");
            return;
        }

        //Reading the number of groups
        int numberOfGroups = configParser.getNumberOfGroups();
        System.out.println("Number of groups : " + numberOfGroups);

        //Creating groups
        ArrayList<Person> victims = vp.getVictims();

        int numberOfPeopleByGroup = victims.size() / numberOfGroups;
        if(numberOfPeopleByGroup*numberOfGroups != victims.size())
            numberOfPeopleByGroup++;
        ArrayList<Group> groups = new ArrayList<>();
        while(!victims.isEmpty()) {
            ArrayList<Person> groupVictims = new ArrayList<>();
            for(int i = 0; !victims.isEmpty() && i < numberOfPeopleByGroup; i++) {
                groupVictims.add(victims.remove(0));
            }
            groups.add(new Group(groupVictims));
        }

        for(Group g : groups)
            System.out.println(g);

        //Reading and testing contents
        EmailContentParser ecp = null;

        try {
            ecp = new EmailContentParser(new File("resources/emailContents.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Creating the Mail instances to be sent
        ArrayList<Mail> mailsToSend = new MailCreator(groups, ecp.getContents()).generateMails();
        EmailSender emailSender;
        try {
            emailSender = new EmailSender(mailsToSend, configParser);
        } catch (IOException e) {
            System.out.println("Connection couldn't be established, aborting probram");
            e.printStackTrace();
            return;
        }
        //Sending emails
        try {
            emailSender.sendEmails();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to send emails");
        }
    }
}