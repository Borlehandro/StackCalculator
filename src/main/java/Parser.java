import commands.ArgumentsList;

import java.io.*;
import java.util.Map;

public class Parser implements AutoCloseable {

    public BufferedReader in;

    public Parser(String filename) throws FileNotFoundException {
        in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
    }

    public Map.Entry<String, ArgumentsList> parseLine() throws IOException {
        String line = in.readLine();

        ArgumentsList list = null;

        if(line.contains(" "))
            list = new ArgumentsList(line.substring(line.indexOf(" ") + 1).split(" "));

        return Map.entry(line.substring(0, line.contains(" ") ? line.indexOf(" ") : line.length()), list != null ? list : ArgumentsList.empty());
    }

    public boolean ready() throws IOException {
        return in.ready();
    }

    @Override
    public void close() throws IOException {
        in.close();
    }
}
