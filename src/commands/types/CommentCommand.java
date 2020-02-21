package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;

public class CommentCommand implements Command {

    // Todo output real comments!
    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context) {
        System.out.println("//Comment line");
    }
}
