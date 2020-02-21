package tests;

import commands.CommandFactory;
import commands.types.*;
import exceptions.UnknownCommandException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {

    @Test
    void createCommandExcept() {

        CommandFactory factory = new CommandFactory();

        // Some incorrect commands examples
        assertThrows(UnknownCommandException.class, () -> factory.create("t"));
        assertThrows(UnknownCommandException.class, () -> factory.create("e"));
        assertThrows(UnknownCommandException.class, () -> factory.create("$"));
        assertThrows(UnknownCommandException.class, () -> factory.create("\n"));
        assertThrows(UnknownCommandException.class, () -> factory.create(";"));
        assertThrows(UnknownCommandException.class, () -> factory.create("t"));
        assertThrows(UnknownCommandException.class, () -> factory.create("\0"));
    }

    @Test
    void createCommandCorrect() {

        CommandFactory factory = new CommandFactory();

        try {
            assertEquals(factory.create("+").getClass(), PlusCommand.class);
            assertEquals(factory.create("-").getClass(), MinusCommand.class);
            assertEquals(factory.create("*").getClass(), MultiplyCommand.class);
            assertEquals(factory.create("/").getClass(), DivideCommand.class);
            assertEquals(factory.create("SQRT").getClass(), SqrtCommand.class);
            assertEquals(factory.create("DEFINE").getClass(), DefineCommand.class);
            assertEquals(factory.create("POP").getClass(), PopCommand.class);
            assertEquals(factory.create("PUSH").getClass(), PushCommand.class);
            assertEquals(factory.create("PRINT").getClass(), PrintCommand.class);
            assertEquals(factory.create("#").getClass(), CommentCommand.class);
            assertEquals(factory.create("#+").getClass(), CommentCommand.class);

        } catch (UnknownCommandException e) {
            fail(e.getMessage());
        }
    }
}
