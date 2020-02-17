package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import exceptions.InvalidArgumentsCountException;

import java.util.EmptyStackException;

public class PopCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context)
            throws EmptyStackException, InvalidArgumentsCountException {

        if(argumentsList.size()!=0)
            throw new InvalidArgumentsCountException();
        // Todo exception
        System.out.println(context.pop());

    }
}
