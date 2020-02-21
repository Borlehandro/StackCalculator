package commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArgumentsList implements Iterable<String> {

    private List<String> list = new ArrayList<>();
    private int size;

    public ArgumentsList() {
        size = 0;
    }

    public ArgumentsList(String... args) {
        list.addAll(Arrays.asList(args));
        size = list.size();
    }

    public String get(int i) {
        return list.get(i);
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<String> iterator() {
        return list.iterator();
    }

    public static ArgumentsList empty() {
        return new ArgumentsList();
    }
}
