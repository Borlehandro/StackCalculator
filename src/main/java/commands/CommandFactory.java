package commands;

import commands.types.Command;
import exceptions.UnknownCommandException;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class CommandFactory {

    private static Logger logger = Logger.getLogger(CommandFactory.class);

    public Command create(String type) throws UnknownCommandException {
        try {

            logger.info("Try to create command with type \"" + type +"\"");

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

            if(className==null) {
                logger.error("Unknown command \"" + type +"\". Throw exception.");
                throw new UnknownCommandException(type);
            }
            logger.info("Create command of class \"" + className + "\"");
            return (Command)Class.forName(className).getDeclaredConstructor().newInstance();

        } catch (IOException | ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            logger.error(e.getMessage());
            System.err.println(e.getMessage());
            return null;
        }
    }
}
