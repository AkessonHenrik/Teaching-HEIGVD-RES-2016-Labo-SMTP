package parsers;

import java.io.*;

/**
 * Created by Henrik on 18.04.2016.
 */

//Reads the configuration file, and interprets its content
public class ConfigParser {
    private String server;
    private int port;
    private int numberOfGroups;
    private String witness;
    private long timeOut;
    public ConfigParser(File file) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(file));

        server = reader.readLine();
        server = server.substring(server.indexOf("=") + 1);
        System.out.println("Server is: " + server);

        line = reader.readLine();
        port = Integer.parseInt(line.substring(line.indexOf("=") + 1));
        System.out.println("Port is: " + port);

        line = reader.readLine();
        numberOfGroups = Integer.parseInt(line.substring(line.indexOf("=") + 1));
        System.out.println("Number of groups is: " + numberOfGroups);

        line = reader.readLine();
        witness = line.substring(line.indexOf("=") + 1);
        System.out.println("Witness is: " + witness);

        line = reader.readLine();
        timeOut = Long.parseLong(line.substring(line.indexOf('=')+1));
        System.out.println("Timeout is " + timeOut);
    }

    public String getServer() {
        return server;
    }

    public int getPort() {
        return port;
    }

    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    public String getWitness() {
        return witness;
    }

    public long getTimeOut() {
        return timeOut;
    }

}
