package people;

import java.util.ArrayList;
import java.util.Random;

//Defines groups, which contain a sender and an array of victims
public class Group {
    private Person sender;
    private ArrayList<Person> victims;

    public Group(ArrayList<Person> victims) {
        this.victims = victims;
        Random r = new Random();
        this.sender = victims.remove(Math.abs(r.nextInt()) % victims.size());
    }
    @Override
    public String toString() {
        String result = "Sender is " + sender.getEmail() + "\n" + "Victims are: \n";
        for (Person p : victims) {
            result += "\t - " + p.getEmail() + '\n';
        }
        return result;
    }

    public Person getSender() {
        return sender;
    }

    public ArrayList<Person> getVictims() {
        return victims;
    }
}