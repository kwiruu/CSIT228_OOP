
public class Main {
    public static void main(String[] args) {

        Arithmetic arithmetic = new Arithmetic(5,2.1);

        System.out.println(arithmetic.add());
        System.out.println(arithmetic.subtract());
        System.out.println(arithmetic.multiply());
        System.out.println(arithmetic.divide());
        System.out.println(arithmetic.getMin());
        System.out.println(arithmetic.getMax());

        MyMap<Integer, String> myMap = new MyMap<>();
        myMap.put(1, "one");
        myMap.put(2, "shiloh");
        myMap.put(3, "burgerz");
        myMap.put(1,"savel");

        System.out.println(myMap.get(2));
        System.out.println(myMap.get(5));
        System.out.println(myMap.get(1));
        System.out.println(myMap.get(3));
        myMap.put(3,"jvm");
        System.out.println(myMap.remove(3));
        System.out.println(myMap.get(3));


    }
}