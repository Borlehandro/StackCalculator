import commands.ArgumentsList;
import commands.Command;
import commands.factorys.CommandFactory;

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

        try (Parser parser = new Parser(filename)) {
            while (parser.ready()) {
                Map.Entry<String, ArgumentsList> commandLine = parser.parseLine();
                // Is it good idea?
                System.err.println(commandLine.getKey());
                Command command = factory.create(commandLine.getKey());
                command.execute(commandLine.getValue());
            }
        } catch (IOException e) {
            System.err.println("Can not parse file");
            System.err.println(e.getMessage());
        }

        // System.err.println(command.getClass());
    }
}
