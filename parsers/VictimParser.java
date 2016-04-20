package parsers;

import people.Person;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Henrik on 18.04.2016.
 */

//Reads the victims list file and interprets it
public class VictimParser {
    private ArrayList<Person> victims;

    public VictimParser(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        victims = new ArrayList<>();
        String str = "";
        try {
            while (str != null) {
                str = reader.readLine();
                if (str == null)
                    break;
                Person p = new Person(str);
                victims.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> getVictims() {
        return victims;
    }
}
