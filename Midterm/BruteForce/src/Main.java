import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static final char[] LETTERS = {'a', 'e', 'i', 'o', 'u'};
    public static void main(String[] args) {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter password to crack bwahaha: ");
        BruteForceRunnable.pass = sc.nextLine();

        ArrayList<Thread> threads = new ArrayList<>();


        for(int i = 0; i < BruteForceRunnable.pass.length(); i++) {
            for(int j = 0; j < 5; j++) {
                count++;
                threads.add(new Thread(new BruteForceRunnable(count, LETTERS[j], i)));
            }
        }
        for(Thread t : threads){
            t.start();
        }

        for(int i = 0; i < 5; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
            }
        }
    }
}