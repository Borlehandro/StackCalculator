package commands;

import exceptions.InvalidArgumentTypeException;
import exceptions.InvalidArgumentsCountException;

public interface Command {

void execute(ArgumentsList argumentsList, CalculationContext context) throws InvalidArgumentsCountException,
        InvalidArgumentTypeException;

}
