package commands;

import exceptions.InvalidArgumentsCountException;

import java.util.regex.Pattern;

public class PushCommand implements Command {
    @Override
    public void execute(ArgumentsList argumentsList,CalculationContext context)
            throws InvalidArgumentsCountException {

        if(argumentsList.size()!=1)
            throw new InvalidArgumentsCountException();
        String argument = argumentsList.get(0);
        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        if(pattern.matcher(argument).matches())
            context.push(Double.parseDouble(argumentsList.get(0)));
        else
            context.push(context.getValue(argument));
    }
}
