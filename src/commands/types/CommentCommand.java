package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;

public class CommentCommand implements Command {

    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context) {
        if(argumentsList.size()!=0) {
            System.out.print("// ");
            for (String arg : argumentsList)
                System.out.print(arg + " ");
            System.out.println();
        }
    }
}
