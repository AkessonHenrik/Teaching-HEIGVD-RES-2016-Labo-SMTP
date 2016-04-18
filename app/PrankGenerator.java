package app;

import jdk.nashorn.internal.runtime.regexp.joni.Config;
import parsers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

public class PrankGenerator {
    public static void main(String... args) {

        //Reading and testing configuration file
        ConfigParser configParser;
        try {
            configParser = new ConfigParser(new File("resources/smtp.config"));
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        //Reading and testing victims
        VictimParser vp = null;
        try {
            vp = new VictimParser(new File("resources/victims.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGroups = configParser.getNumberOfGroups();
        System.out.println("In main: number of groups is : " + numberOfGroups);


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
        try {
            EmailContentParser ecp = new EmailContentParser(new File("resources/emailContents.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}