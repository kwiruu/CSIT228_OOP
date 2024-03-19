
import java.util.Scanner;

public class Main{
    public static Thread[] thrds;
    public static int[] res;
    public static void main(String[] args) {
        int i=0;
        int num;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Fibonacci: ");
        num = sc.nextInt();

        thrds = new Thread[num];
        res = new int[num];

        for(i = 0; i < num; i++){
            thrds[i] = new Thread(new FibonacciRunnable(i+1));
        }

        thrds[num - 1].start();

        for(i = 0; i < num; i++){
            try {
                thrds[i].join();

            } catch (InterruptedException ea) {
                throw new RuntimeException(ea);
            }
        }

        i=0;
        while(i < num){
            System.out.print(res[i] + " ");
            i++;
        }

    }
}