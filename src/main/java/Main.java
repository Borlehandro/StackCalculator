import commands.ArgumentsList;
import commands.CalculationContext;
import commands.types.Command;
import commands.CommandFactory;
import exceptions.*;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Map;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        String filename = null;

        if (args.length != 0)
            filename = args[0];
        else {
            try (BufferedReader reader = new BufferedReader(System.console().reader())) {
                logger.info("Try to get filename from console");
                filename = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        CommandFactory factory = new CommandFactory();
        CalculationContext context = new CalculationContext();

        try (Parser parser = new Parser(filename)) {
            while (parser.ready()) {

                context.next();

                try {

                    Map.Entry<String, ArgumentsList> commandLine = parser.parseLine();
                    Command command = factory.create(commandLine.getKey());
                    command.execute(commandLine.getValue(), context);

                } catch (ExecuteTimeException | UnknownCommandException e) {
                    logger.error("Catch exception: " + e.getMessage());
                    System.err.println(e.getMessage());
                }

                // And I just continue it!

            }
        } catch (IOException e) {

            logger.error("IOException while reading data: " + e.getMessage());

            e.printStackTrace();
        }
    }
}