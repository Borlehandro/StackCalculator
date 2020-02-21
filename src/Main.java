import commands.ArgumentsList;
import commands.CalculationContext;
import commands.types.Command;
import commands.CommandFactory;
import exceptions.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String filename = "../res/default.txt";
        if(args.length!=0)
            filename = args[0];
        else {
            // Todo replace with console
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
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
                Map.Entry<String, ArgumentsList> commandLine = parser.parseLine();
                Command command = factory.create(commandLine.getKey());
                command.execute(commandLine.getValue(), context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidVarNameException | InvalidArgumentTypeException | InvalidArgumentsCountException
                | CalculationStackException | UnknownCommandException e) {

            // Todo can i send step into exception?
            System.err.println("Terminated in step " + stepCount + ":");
            System.err.println(e.getMessage());
        }
    }
}
