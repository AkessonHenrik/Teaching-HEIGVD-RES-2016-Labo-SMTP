package parsers;

import app.Person;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Henrik on 18.04.2016.
 */
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
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> getVictims() {
        return victims;
    }
}
