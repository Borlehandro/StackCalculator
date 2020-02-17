package commands;

import commands.factorys.CommandFactory;

public class CommentCommand implements Command {

    public CommentCommand() {
        System.out.println("CREATE COMMENT");
    }

    @Override
    public void execute(ArgumentsList argumentsList) {
        System.err.println("JUST COMMENT");

    }

    /*static class CommentFactory /*implements CommandFactory<CommentCommand> {

        public CommentCommand create(){
            return new CommentCommand();
        }
    } */
}
