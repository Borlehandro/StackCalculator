package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.CalculationStackException;
import exceptions.InvalidArgumentsCountException;

import java.util.EmptyStackException;

public class PopCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws InvalidArgumentsCountException, EmptyStackException, CalculationStackException {

        if(argumentsList.size()!=0)
            throw new InvalidArgumentsCountException("POP", 0, argumentsList.size(), context.getStep());

        System.out.println(context.pop());

    }
}
