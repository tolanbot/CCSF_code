/**
 * A class that implements a list of objects using an array.
 * Entries in a list have positions that begin with 0. Entries can only be added
 * to the front or Back of the list.
 * Duplicate entries are allowed.
 * 
 * @author Chris Tolan
 * @version 2.0
 */
public class ArrayFrontBackCappedList<T> implements FrontBackCappedListInterface<T> {
    private T[] list;
    private int numberOfElements;
    private static final int MAX_SIZE = 10000;

    public ArrayFrontBackCappedList() {
        this(MAX_SIZE);
    }

    @SuppressWarnings("unchecked")
    public ArrayFrontBackCappedList(int maxSize) {
        if (capacityOK(maxSize)) {
            list = (T[]) new Object[maxSize];
            numberOfElements = 0;
        }
    }

    public boolean addFront(T newEntry) {
        if (!isFull() && numberOfElements<=size()) {
            makeRoom(0);
            list[0] = newEntry;
            numberOfElements++;
            return true;
        } else {
            return false;
        }
    }
  
    public boolean addBack(T newEntry) {
        if (!isFull()) {
            numberOfElements++;
            list[size() - 1] = newEntry;
            return true;
        } else {
            return false;
        }
    }

    public T removeFront() {
        T removedItem;
        if (!isEmpty()) {
            removedItem = list[0];
            makeRoom(1);
            numberOfElements--;
            return removedItem;
        } else {
            return null;
        }
    }

    public T removeBack() {
        T removedItem;
        if (!isEmpty()) {
            removedItem = list[size() - 1];
            numberOfElements--;
            return removedItem;
        } else {
            return null;
        }
    }

    public void clear() {
        for (int i = numberOfElements-1; i >= 0; i--) {
            list[i] = null;
            numberOfElements--;
        }
    }

    public T getEntry(int givenIndex) {
        if (givenIndex >= 0 && givenIndex < numberOfElements) {
            T entry = list[givenIndex];
            return entry;
        }
        return null;
    }

    public int indexOf(T anEntry) {
        int index = -1;
        if (!isEmpty()) {
            for (int i = 0; i < numberOfElements; i++) {
                if (anEntry.equals(list[i])) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }

    public int lastIndexOf(T anEntry) {
        int index = -1;
        if (!isEmpty()) {
            for (int i = numberOfElements-1; i >= 0; i--) {
                if (anEntry.equals(list[i])) {
                    index = i;
                    return index;
                }
            }
        }
        return index;
    }

    public boolean isFull() {
        return numberOfElements >= list.length;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean contains(T key) {
        boolean found = false;
        int index = 0;
        while (!found && index < numberOfElements) {
            if (key.equals(list[index])) {
                found = true;
            }
            index++;
        }
        return found;
    }

    public int size() {
        return this.numberOfElements;
    }

    private boolean isValid(int givenIndex) {
        if ((givenIndex >= 0) && (givenIndex <= numberOfElements + 1)) {
            return true;
        } else {
            return false;
        }
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfElements];
        for (int index = 0; index < numberOfElements; index++) {
            result[index] = list[index];
        }
        return result;
    }

    private void makeRoom(int givenIndex) {
        if (isValid(givenIndex)) {
            if (givenIndex == 0) {
                int newIndex = givenIndex;
                int lastIndex = numberOfElements;
                for (int index = lastIndex-1; index >= newIndex; index--) {
                    list[index + 1] = list[index];
                }
            }
            if (givenIndex == 1) {
                int lastIndex = numberOfElements;
                for (int index = 0; index < lastIndex-1; index++) {
                    list[index] = list[index + 1];
                }
            }
        }
    }

    private boolean capacityOK(int capacity) {
        if (capacity > MAX_SIZE) {
            throw new IllegalStateException(
                    "Maximum Size Exceeded: Cannot create requested List.");
        }
        return true;
    }

    @SuppressWarnings("hiding")
    private <T> String displayList(T[] list) {
        String contents = "";
        String finalString = "";
        String comma = ", ";
        String opening = "[";
        String closing = "]";
        int numberOfItems = this.numberOfElements;
        if (numberOfItems == 0) {
            finalString = opening + closing;
        }
        for (int i = 0; i < numberOfItems; i++) {
            if (i != numberOfItems - 1) {
                contents += list[i] + comma;
                finalString = opening + contents;
            } else {
                contents += list[i];
                finalString = opening + contents + closing;
            }
        }
        return finalString;
    }

    @Override
    public String toString() {
        String listString = "size=" + numberOfElements + ";" + " capacity=" + list.length + ";   " + displayList(list);
        return listString;
    }
}
