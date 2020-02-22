package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.CalculationStackException;
import exceptions.InvalidArgumentsCountException;
import org.apache.log4j.Logger;

public class PrintCommand implements Command {

    private static Logger logger = Logger.getLogger(DefineCommand.class);

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, CalculationStackException {

        logger.info("Try to print value from stack");

        if(argumentsList.size()!=0) {
            logger.error("Invalid number of arguments: " + argumentsList.size()
                    + "instead of NO ARGUMENTS. Throw exception." );
            throw new InvalidArgumentsCountException("PRINT", 0, argumentsList.size(), context.getStep());
        }

        System.out.println(context.getTop());

        // Non exception
        logger.info("Printed top: " + context.getTop());
    }
}
