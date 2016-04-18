package parsers;


import java.io.*;
import java.util.ArrayList;

/**
 * Created by Henrik on 18.04.2016.
 */
public class EmailContentParser {
    private ArrayList<String> contents;
    public EmailContentParser(File file) throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        contents = new ArrayList<>();
        String str = "";
        String content = "";
        try {
            while (str != null) {
                str = reader.readLine();
                if(str == null)
                    break;
                if(str.equals("===")) {
                    contents.add(content);
                    content = "";
                } else {
                    content += str + '\n';
                }
            }
            for(String s : contents) {
                System.out.println("Content number " + contents.indexOf(s));
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
