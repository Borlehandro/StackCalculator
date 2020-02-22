package commands.types;

import commands.ArgumentsList;
import commands.CalculationContext;
import org.apache.log4j.Logger;

public class CommentCommand implements Command {

    private static Logger logger = Logger.getLogger(CommentCommand.class);

    // Todo output real comments!
    @Override
    public void execute(ArgumentsList argumentsList, CalculationContext context) {
        logger.info("Comment in line " + context.getStep());
        System.out.println("//Comment line " + context.getStep());
    }
}
