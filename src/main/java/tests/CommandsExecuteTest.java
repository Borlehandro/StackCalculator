package tests;

import commands.ArgumentsList;
import commands.CalculationContext;
import commands.types.*;
import exceptions.CalculationStackException;
import exceptions.InvalidArgumentTypeException;
import exceptions.InvalidArgumentsCountException;
import exceptions.InvalidVarNameException;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class CommandsExecuteTest {

    private static PrintStream originalOut;
    private static ByteArrayOutputStream testOut = new ByteArrayOutputStream();

    // All System.out data will be in testOut
    @BeforeAll
    static void setStreams() {
        originalOut = System.out;
        System.setOut(new PrintStream(testOut));
    }

    @AfterAll
    static void setStreamsBack() {
        System.setOut(originalOut);
    }

    @BeforeEach
    void clearStream() {
        testOut.reset();
    }

    @Test
    void testPlus() {
        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();
        context.push(2d);
        context.push(2d);

        try {
            new PlusCommand().execute(list, context);
            assertEquals(context.getTop(),4d);
        } catch (InvalidArgumentsCountException | CalculationStackException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testMinus() {
        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();
        context.push(2d);
        context.push(2d);

        try {
            new MinusCommand().execute(list, context);
            assertEquals(context.getTop(),0d);
        } catch (InvalidArgumentsCountException | CalculationStackException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void testMultiply() {
        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();
        context.push(5d);
        context.push(5d);

        try {
            new MultiplyCommand().execute(list, context);
            assertEquals(context.getTop(),25d);
        } catch (InvalidArgumentsCountException | CalculationStackException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testDivide() {
        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();
        context.push(4d);
        context.push(2d);

        try {
            new DivideCommand().execute(list, context);
            assertEquals(context.getTop(),0.5d);
        } catch (InvalidArgumentsCountException | CalculationStackException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void testSqrt() {
        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();
        context.push(4d);

        try {
            new SqrtCommand().execute(list, context);
            assertEquals(context.getTop(),2d);
        } catch (InvalidArgumentsCountException | CalculationStackException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testDefine() {

        ArgumentsList list = new ArgumentsList("Variable", "2");
        CalculationContext context = new CalculationContext();

        try {
            new DefineCommand().execute(list, context);
            assertEquals(context.getValue("Variable"), 2d);
        } catch (InvalidArgumentsCountException | InvalidArgumentTypeException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void testComment() {

        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();

        new CommentCommand().execute(list,context);

        assertTrue(testOut.toString().equals("//Comment line\r\n")
                || testOut.toString().equals("//Comment line\n"));
    }

    @Test
    void testPop() {

        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();

        context.push(2048d);

        try {
            new PopCommand().execute(list,context);

            assertTrue(testOut.toString().equals(2048d + "\r\n")
                    || testOut.toString().equals(2048d + "\n"));

            assertThrows(CalculationStackException.class, () -> new PopCommand().execute(list,context));

        } catch (InvalidArgumentsCountException | CalculationStackException e) {
            fail(e.getMessage());
        }

    }

    @Test
    void testPush() {

        ArgumentsList list = new ArgumentsList("2048");
        CalculationContext context = new CalculationContext();

        try {

            new PushCommand().execute(list, context);

            assertEquals(context.getTop(), 2048d);

        } catch (InvalidArgumentsCountException | InvalidVarNameException | CalculationStackException e) {
            fail(e.getMessage());
        }
    }

    @Test
    void testPrint() {

        ArgumentsList list = new ArgumentsList();
        CalculationContext context = new CalculationContext();

        context.push(1024d);

        try {

            new PrintCommand().execute(list, context);

            assertTrue(testOut.toString().equals(1024d + "\r\n")
                    || testOut.toString().equals(1024d + "\n"));

        } catch (InvalidArgumentsCountException | CalculationStackException e) {
            fail(e.getMessage());
        }
    }
}
