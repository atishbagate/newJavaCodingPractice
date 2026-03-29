package DesignPatterns.BehavioralPatterns.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

interface Iterator {
    boolean hasNext();

    Object next();
}

interface ChannalCollection {
    Iterator getIterator();
}

class TVStation implements ChannalCollection {
    private List<String> channals;

    public TVStation() {
        channals = new ArrayList<>();
    }

    public void addChannal(String name) {
        channals.add(name);
    }

    @Override
    public Iterator getIterator() {
        return new ChannalIterator(channals);
    }

    public Iterator getReverseIterator() {
        return new reverseIterator(channals);
    }

    // inner class : actual Iterator logic
    private class ChannalIterator implements Iterator {
        private List<String> channals;
        private int index = 0;

        public ChannalIterator(List<String> channals) {
            this.channals = channals;
        }

        @Override
        public boolean hasNext() {
            return index < channals.size();
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return channals.get(index++);
            }
            return null;
        }
    }

    // inner class for reverse iterator
    private class reverseIterator implements Iterator {
        private List<String> channals;
        private int index = 0;

        public reverseIterator(List<String> channals) {
            this.channals = channals;
            // start at last index.
            this.index = channals.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return channals.get(index--);
            }
            return null;
        }
    }
}

public class TVChannalExOne {
    public static void main(String[] args) {

        TVStation tvStation = new TVStation();
        tvStation.addChannal("nick");
        tvStation.addChannal("star sport");

//        get iterator
        Iterator iterator = tvStation.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Iterator reverseIterator = tvStation.getReverseIterator();
        while (reverseIterator.hasNext()) {
            System.out.println(reverseIterator.next());
        }
    }
}
