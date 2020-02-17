import commands.ArgumentsList;
import commands.CalculationContext;
import commands.Command;
import commands.factorys.CommandFactory;
import exceptions.InvalidArgumentTypeException;
import exceptions.InvalidArgumentsCountException;

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
        try (Parser parser = new Parser(filename)) {
            while (parser.ready()) {
                Map.Entry<String, ArgumentsList> commandLine = parser.parseLine();

                // Is it good idea?
                // System.err.println(commandLine.getKey());
                Command command = factory.create(commandLine.getKey());
                command.execute(commandLine.getValue(), context);
            }
        } catch (IOException e) {
            System.err.println("Can not parse file");
            System.err.println(e.getMessage());
        } catch (InvalidArgumentsCountException e) {
            System.err.println("Invalid arguments count");
            e.printStackTrace();
        } catch (InvalidArgumentTypeException e) {
            System.err.println("Invalid argument type");
            e.printStackTrace();
        }

        // System.err.println(command.getClass());
    }
}
