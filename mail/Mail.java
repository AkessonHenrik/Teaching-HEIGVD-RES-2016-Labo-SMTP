package mail;

import people.Person;

import java.util.ArrayList;

public class Mail extends MailContent {
    private Person from;
    private ArrayList<Person> to;

    public Mail(Person from, ArrayList<Person> to, String subject, String body) {
        super(subject, body);
        this.from = from;
        this.to = to;
    }

    public ArrayList<Person> getTo() {
        return to;
    }

    public Person getFrom() {
        return from;
    }
}