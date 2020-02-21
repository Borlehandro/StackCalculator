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
        try (Parser parser = new Parser(filename)) {
            while (parser.ready()) {
                Map.Entry<String, ArgumentsList> commandLine = parser.parseLine();
                Command command = factory.create(commandLine.getKey());
                command.execute(commandLine.getValue(), context);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidVarNameException e) {
            System.err.println("Invalid var name");
            System.err.println(e.getMessage());
        } catch (InvalidArgumentTypeException e) {
            System.err.println("Invalid arg type");
            System.err.println(e.getMessage());
        } catch (InvalidArgumentsCountException e) {
            System.err.println("Invalid arg count");
            System.err.println(e.getMessage());
            e.printStackTrace();
        } catch (CalculationStackException e) {
            System.err.println("STACK");
        } catch (UnknownCommandException e) {
            System.err.println("Unknown command");
        }
        /*catch (IOException e) {
            System.err.println("Can not parse file");
            System.err.println(e.getMessage());
        } catch (InvalidArgumentsCountException e) {
            System.err.println("Invalid arguments count");
            // e.printStackTrace();
        } catch (InvalidArgumentTypeException e) {
            System.err.println("Invalid argument type");
            // e.printStackTrace();
        } catch (InvalidVarNameException e) {
            System.err.println("Invalid variable");
            // e.printStackTrace();
        } catch (EmptyStackException e) {
            System.err.println("Empty stack");
            // e.printStackTrace();
        }
        }*/

        // System.err.println(command.getClass());
    }
}
