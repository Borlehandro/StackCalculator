package commands;

import commands.types.Command;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CommandFactory {
    public Command create(String type) {
        try {
            Properties prop = new Properties();
            InputStream in = this.getClass().getResourceAsStream("/commands/commands_config.properties");
            prop.load(in);
            String className = prop.getProperty(type);
            // System.out.println(type + "-" + className);
            return (Command)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
