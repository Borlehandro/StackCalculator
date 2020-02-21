package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.CalculationStackException;
import exceptions.InvalidArgumentsCountException;
import org.apache.log4j.Logger;

public class SqrtCommand implements Command {

    private static Logger logger = Logger.getLogger(DefineCommand.class);

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, CalculationStackException {

        if (argumentsList.size() != 0) {
            logger.error("Invalid number of arguments: " + argumentsList.size()
                    + "instead of NO ARGUMENTS. Throw exception." );
            throw new InvalidArgumentsCountException("SQRT", 0, argumentsList.size(), context.getStep());
        }

        // Todo complex square?
        context.push(Math.sqrt(context.pop()));

    }
}
