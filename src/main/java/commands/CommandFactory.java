package commands;

import commands.types.Command;
import exceptions.UnknownCommandException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CommandFactory {

    public Command create(String type) throws UnknownCommandException {
        try {
            Properties prop = new Properties();
            InputStream in = this.getClass().getResourceAsStream("/commands_config.properties");
            prop.load(in);
            String className;

            // Todo Is it good idea?
            if(type.startsWith("#"))
                className = prop.getProperty("#");
            else
                className = prop.getProperty(type);

            // System.out.println(type + "-" + className);

            if(className==null)
                throw new UnknownCommandException(type);
            return (Command)Class.forName(className).getDeclaredConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }
}
