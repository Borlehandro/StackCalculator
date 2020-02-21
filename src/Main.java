import commands.ArgumentsList;
import commands.CalculationContext;
import commands.types.Command;
import commands.CommandFactory;
import exceptions.*;

import java.io.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String filename = "../res/default.txt";
        if (args.length != 0)
            filename = args[0];
        else {
            try (BufferedReader reader = new BufferedReader(System.console().reader())) {
                filename = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        CommandFactory factory = new CommandFactory();
        CalculationContext context = new CalculationContext();

        long stepCount = 0;
        try (Parser parser = new Parser(filename)) {
            while (parser.ready()) {

                stepCount++;

                try {
                    Map.Entry<String, ArgumentsList> commandLine = parser.parseLine();
                    Command command = factory.create(commandLine.getKey());
                    command.execute(commandLine.getValue(), context);
                } catch (InvalidVarNameException | InvalidArgumentTypeException | InvalidArgumentsCountException
                        | CalculationStackException | UnknownCommandException e) {

                    // Todo can i send step into exception?
                    System.err.println("Skip step " + stepCount + ":");
                    System.err.println(e.getMessage());

                }

                // And I just continue it!

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
