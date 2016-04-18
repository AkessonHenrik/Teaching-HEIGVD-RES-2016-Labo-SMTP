package app;

import java.util.ArrayList;
import java.util.Random;

public class Group {
    Person sender;
    ArrayList<Person> victims;

    public Group(ArrayList<Person> victims) {
        this.victims = victims;
        Random r = new Random();
        this.sender = victims.remove(Math.abs(r.nextInt()) % victims.size());
    }

    @Override
    public String toString() {
        String result = "Sender is " + sender.getEmail() + "\n" + "Victims are: \n";
        for (Person p : victims) {
            result += "\t - " + p.getEmail() + ": " + p.getFirstName() + " " + p.getLastName() + '\n';
        }
        return result;
    }

}