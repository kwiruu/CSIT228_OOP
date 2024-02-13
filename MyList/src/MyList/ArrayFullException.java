package MyList;

class ArrayFullException extends Exception {
    public ArrayFullException(String message) {
        super(message);
    }

    public ArrayFullException(int num) {
        super("The array is full and " + num + " cannot be inserted.");
    }

    public ArrayFullException(Cat cat) {
        super("The array is full and " + cat.name + " cannot be inserted.");
    }
}
