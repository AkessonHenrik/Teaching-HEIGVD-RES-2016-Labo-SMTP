package app;

import parsers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PrankGenerator {
    public static void main(String... args) {
        VictimParser vp = null;
        try {
            vp = new VictimParser(new File("resources/victims.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int numberOfGroups = 2;

        //Creating groups

        ArrayList<Person> victims = vp.getVictims();

        Group g1 = new Group(victims);
        System.out.println(g1);

        try {
            EmailContentParser ecp = new EmailContentParser(new File("resources/emailContents.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}