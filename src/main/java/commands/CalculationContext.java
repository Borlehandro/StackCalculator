package commands;

import exceptions.CalculationStackException;
import org.apache.log4j.Logger;

import java.util.*;

public class CalculationContext {

    private static Logger logger = Logger.getLogger(CalculationContext.class);

    private LinkedList<Double> stack = new LinkedList<>();
    private Map<String, Double> definitions = new HashMap<>();
    private long step = 0;

    public void define(String name, Double value) {
        definitions.put(name, value);
    }

    public void push(Double s) {
        stack.push(s);
    }

    public Double pop() throws CalculationStackException {
        if(stack.size() == 0) {
            throw new CalculationStackException(step);
        }
        return stack.pop();
    }

    public Double getTop() throws CalculationStackException {

        if(stack.size() == 0) {
            throw new CalculationStackException(step);
        }

        return stack.peek();
    }

    public Double getValue(String key) {
        return definitions.get(key);
    }

    public boolean containsVar(String key) {
        return definitions.containsKey(key);
    }

    public void next() {
        step++;
        logger.info("Next calculation step. Step counter == " + step);
    }

    public long getStep() {
        return step;
    }

}