import commands.ArgumentsList;
import commands.CalculationContext;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Map;

public class Parser implements AutoCloseable {

    private static Logger logger = Logger.getLogger(CalculationContext.class);

    public BufferedReader in;

    public Parser(String filename) throws FileNotFoundException {
        logger.info("Create parser for file: \"" + filename + "\"");
        in = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
    }

    public Map.Entry<String, ArgumentsList> parseLine() throws IOException {

        String line = in.readLine();

        logger.info("Parse new line: \"" + line + "\"");

        ArgumentsList list = null;

        if(line.contains(" "))
            list = new ArgumentsList(line.substring(line.indexOf(" ") + 1).split(" "));

        return Map.entry(line.substring(0, line.contains(" ") ? line.indexOf(" ") : line.length()), list != null ? list : ArgumentsList.empty());
    }

    public boolean ready() throws IOException {
        logger.info(in.ready() ? "Parser is ready." : "Parser is not ready.");
        return in.ready();
    }

    @Override
    public void close() throws IOException {
        logger.info("Close parser.");
        in.close();
    }
}
