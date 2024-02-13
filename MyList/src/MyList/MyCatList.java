package MyList;

import java.util.Objects;

public class MyCatList {
    Cat[] array;
    int size;

    public MyCatList() {
        array = new Cat[5];
        size = 0;
    }

    void add(Cat cat) throws ArrayFullException {
        try {
            array[size] = cat;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayFullException(cat);
        }
    }

    void addAt(int pos, Cat cat) throws ArrayFullException {
        if (pos > size + 1) {
            throw new InvalidPositionException(size + 1);
        }
        if (size == 5) {
            throw new ArrayFullException(cat);
        }
        for (int i = size; i >= pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos - 1] = cat;
        size++;
    }

    boolean remove(String name) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == null) {
                break;
            }
            if (Objects.equals(array[i].name, name)) {
                index = i;
                flag = true;
                size--;
                break;
            }
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        return flag;
    }

    Cat removeAt(int pos) {
        if (pos > size) {
            throw new InvalidPositionException(size);
        }
        Cat removed = array[pos - 1];
        for (int i = pos - 1; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removed;
    }

    boolean contains(String name) {
        for (int i = 0; i < size; i++) {
            if (array[i].name == name) {
                return true;
            }
        }
        return false;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    Cat get(int pos) {
        if (pos > size || (pos - 1) < 0) {
            throw new InvalidPositionException(size);
        }
        return array[pos - 1];
    }

    Cat set(int pos, Cat cat) {
        if (pos > size || (pos - 1) < 0) {
            throw new InvalidPositionException(size);
        }
        Cat replaced = array[pos - 1];
        array[pos - 1] = cat;
        return replaced;
    }
}