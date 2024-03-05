import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class BingoGame implements Runnable {
    boolean bingo;
    static boolean[] result;
    List<BingoCard> cards;

    public BingoGame() {
        result = new boolean[76];
        result[0] = true; // Index 0 reserved for FREE
        bingo = false;
        cards = new ArrayList<>();
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many players? ");
        int numPlayers = sc.nextInt();

        for(int i = 1; i<=numPlayers; i++){
            cards.add(new BingoCard(i));
        }
        // TODO get a number and create that number of cards
        // TODO and store them in the list of cards.
        for (BingoCard card : cards) {
            System.out.println("Card " + card.id);
            System.out.println(card);
        }
        List<Thread> threads = new ArrayList<>();
        for (BingoCard card : cards) {
            threads.add(new Thread(new BingoPatternPlus(card)));
        }for (Thread t : threads) {
            t.start();
        }

        while(!bingo) {
            Random random = new Random();
            int num = random.nextInt(75) + 1;

            System.out.println("Number chosen: " + num);

            System.out.println("Numbers chosen: ");
            for (int i = 1; i < result.length; i++) {
                if (result[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            result[num] = true;

            synchronized (this) {
                notifyAll();
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

            System.out.println("Numbers chosen:");
            for (int i = 1; i < result.length; i++) {
                if (result[i]) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();

            for (Thread t : threads) {
                t.interrupt();
            }



    }
}
