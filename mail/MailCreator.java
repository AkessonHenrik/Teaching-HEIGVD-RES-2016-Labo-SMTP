package mail;

import people.Group;

import java.util.ArrayList;

//Creates a list of e-mail instances from a list of contents and a list of groups
public class MailCreator {
    private ArrayList<MailContent> contents;
    private ArrayList<Group> groups;

    public MailCreator(ArrayList<Group> groups, ArrayList<MailContent> contents) {
        this.groups = groups;
        this.contents = contents;
    }
    public ArrayList<Mail> generateMails() {
        ArrayList<Mail> mails = new ArrayList<Mail>();
        for(int i = 0; i < groups.size(); i++) {
            Mail mail = new Mail(groups.get(i).getSender(), groups.get(i).getVictims(), contents.get(i % contents.size()).getSubject(), contents.get(i % contents.size()).getBody());
            mails.add(mail);
        }
        return mails;
    }

}
