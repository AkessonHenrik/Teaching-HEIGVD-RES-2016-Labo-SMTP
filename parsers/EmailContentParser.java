package parsers;


import mail.MailContent;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Henrik on 18.04.2016.
 */
public class EmailContentParser {
    private ArrayList<MailContent> contents;

    public EmailContentParser(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        contents = new ArrayList<MailContent>();
        String str="";
        String content;
        String subject;
        while(str != null) {
            str = reader.readLine();
            if(str == null)
                break;
            subject = str.substring(str.indexOf(':')+1);
            content = "";
            while(!str.equals("===")) {
                str = reader.readLine();
                if(!str.equals("==="))
                    content += str + "\n";
            }
//            System.out.println("Subject:<"+subject+">");
//            System.out.println("content:<"+content+">");
            contents.add(new MailContent(subject, content));
        }
    }

    public ArrayList<MailContent> getContents() {
        return contents;
    }
}
