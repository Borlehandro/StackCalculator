package commands;

import java.util.*;

public class CalculationContext {

    private LinkedList<Double> stack = new LinkedList<>();
    private Map<String, Double> definitions = new HashMap<>();

    public void define(String name, Double value) {
        definitions.put(name, value);
    }

    public void push(Double s) {
        stack.push(s);
    }

    public Double pop() {
        return stack.pop();
    }

    public Double getTop() {
        return stack.peek();
    }

    public Double getValue(String key) {
        return definitions.get(key);
    }
}