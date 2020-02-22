package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.InvalidArgumentsCountException;
import exceptions.InvalidVarNameException;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class PushCommand implements Command {

    private static Logger logger = Logger.getLogger(DefineCommand.class);

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, InvalidVarNameException {

        logger.info("Try to push value");

        if(argumentsList.size()!=1) {
            logger.error("Invalid number of arguments: " + argumentsList.size()
                    + "instead of" + 1 + ". Throw exception." );
            throw new InvalidArgumentsCountException("PUSH", 1, argumentsList.size(), context.getStep());
        }

        String argument = argumentsList.get(0);
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

        if(pattern.matcher(argument).matches()) {
            logger.info("Push double " + argument);
            context.push(Double.parseDouble(argumentsList.get(0)));
        }

        else if(context.containsVar(argument)) {
            logger.info("Push value of variable " + argument);
            context.push(context.getValue(argument));
        }

        else {
            logger.error("Invalid name of var: \"" + argument +"\". Throw exception.");
            throw new InvalidVarNameException(argument, context.getStep());
        }
    }
}
