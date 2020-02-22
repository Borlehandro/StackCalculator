package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.InvalidArgumentTypeException;
import exceptions.InvalidArgumentsCountException;
import exceptions.InvalidVarNameException;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class DefineCommand implements Command {

    private static Logger logger = Logger.getLogger(DefineCommand.class);

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, InvalidArgumentTypeException, InvalidVarNameException {

        logger.info("Try to define " + argumentsList.get(0) + "=" + argumentsList.get(1));

        if (argumentsList.size() != 2) {
            logger.error("Invalid number of arguments: " + argumentsList.size()
                    + "instead of" + 2 + ". Throw exception." );
            throw new InvalidArgumentsCountException("DEFINE", 2, argumentsList.size(), context.getStep());
        }
            Pattern patternDouble = Pattern.compile("-?\\d+(\\.\\d+)?");
            Pattern patternLetter = Pattern.compile("^[a-zA-Z]*$");

            if(patternLetter.matcher(argumentsList.get(0)).matches()) {
                // Double to var
                if (patternDouble.matcher(argumentsList.get(1)).matches()) {
                    context.define(argumentsList.get(0), Double.valueOf(argumentsList.get(1)));
                }
                // Copy value of another var
                else if(patternLetter.matcher(argumentsList.get(1)).matches()) {
                    if(context.containsVar(argumentsList.get(1))) {

                        logger.info("Copy value of variable "  + argumentsList.get(1)
                                + " to variable " + argumentsList.get(0) );
                        context.define(argumentsList.get(0), context.getValue(argumentsList.get(1)));
                    }
                    else {
                        logger.error("Invalid name of var for copping: \""
                                + argumentsList.get(1) +"\". Throw exception.");
                        throw new InvalidVarNameException(argumentsList.get(1), context.getStep());
                    }
                }
                else {

                    logger.error("Invalid type of argument \""
                            + argumentsList.get(0) + "=" + argumentsList.get(1) + "\"");
                    throw new InvalidArgumentTypeException("DEFINE", "Letter or double", "String",
                            argumentsList.get(1), context.getStep());

                }
            } else {
                logger.error("Invalid type of argument \""
                        + argumentsList.get(0) + "=" + argumentsList.get(1) + "\"");
                throw new InvalidArgumentTypeException("DEFINE", "Letter", "Double",
                        argumentsList.get(0), context.getStep());
            }
    }
}
