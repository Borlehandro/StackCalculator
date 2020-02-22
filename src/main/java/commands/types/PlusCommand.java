package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.CalculationStackException;
import exceptions.InvalidArgumentsCountException;
import org.apache.log4j.Logger;

import java.util.EmptyStackException;

public class PlusCommand implements Command {

    private static Logger logger = Logger.getLogger(DefineCommand.class);

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, EmptyStackException, CalculationStackException {

        if (argumentsList.size() != 0) {
            logger.error("Invalid number of arguments: " + argumentsList.size()
                    + "instead of NO ARGUMENTS. Throw exception." );
            throw new InvalidArgumentsCountException("+", 0, argumentsList.size(), context.getStep());
        }

        logger.info("Try to push sum result");

        context.push(context.pop() + context.pop());
    }
}
