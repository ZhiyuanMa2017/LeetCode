// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {
    Integer peekElememt;
    Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (peekElememt == null) {
            peekElememt = iterator.next();
        }
        return peekElememt;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (peekElememt != null) {
            int res = peekElememt;
            peekElememt = null;
            return res;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return peekElememt != null || iterator.hasNext();
    }
}
