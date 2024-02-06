import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidAgeException {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        Person p=null;

        System.out.print("ENTER NAME OF PERSON: ");
        String name = sc.nextLine();

        try {
            System.out.print("ENTER AGE OF PERSON: ");
            int age = sc.nextInt();

           p = new Person(age,name);
            System.out.println("Age of person is: "+ p.age);

            p.Birthday();
        }
        catch(InputMismatchException e){
            System.out.println("NOT A NUMBER!");
        }
        catch (ArithmeticException e) {
            System.err.println("Wow arithmetic error");
        }
        catch (InvalidAgeException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(p);
        }






    }
}