package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.EmptyStackException;
import exceptions.InvalidArgumentTypeException;
import exceptions.InvalidArgumentsCountException;
import exceptions.InvalidVarNameException;

public interface Command {

void execute(ArgumentsList argumentsList, CalculationContext context) throws InvalidArgumentsCountException,
        InvalidArgumentTypeException, InvalidVarNameException, EmptyStackException;

}
