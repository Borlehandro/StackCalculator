package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.InvalidArgumentTypeException;
import exceptions.InvalidArgumentsCountException;
import org.apache.log4j.Logger;

public class DefineCommand implements Command {

    private static Logger logger = Logger.getLogger(DefineCommand.class);

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, InvalidArgumentTypeException {

        logger.info("Try to define " + argumentsList.get(0) + "=" + argumentsList.get(1));

        if (argumentsList.size() != 2) {
            logger.error("Invalid number of arguments: " + argumentsList.size()
                    + "instead of" + 2 + ". Throw exception." );
            throw new InvalidArgumentsCountException("DEFINE", 2, argumentsList.size(), context.getStep());
        }
        try {
            context.define(argumentsList.get(0), Double.valueOf(argumentsList.get(1)));
        } catch (NumberFormatException e) {
            // Todo Fix! Can be number before letter.
            logger.error("Invalid type of argument \""
                    + argumentsList.get(0) + "=" + argumentsList.get(1) + "\"");
            throw new InvalidArgumentTypeException("DEFINE", "Double", "String", argumentsList.get(1), context.getStep());
        }
    }
}
