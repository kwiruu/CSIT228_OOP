import java.util.ArrayList;
import java.util.List;

public abstract class BingoPattern extends BingoGame implements Runnable {
    List<BingoChecker> checkers;
    BingoCard card;
    boolean bingo;

    public BingoPattern(BingoCard card) {
        this.card = card;
        checkers = new ArrayList<>();
    }

    @Override
    public void run() {
        List<Thread> checkerThreads = new ArrayList<>();

        for (BingoChecker checker : checkers) {
            Thread checkerThread = new Thread(checker);
            checkerThreads.add(checkerThread);
            checkerThread.start();
        }

        try {
            for (Thread checkerThread : checkerThreads) {
                checkerThread.join();
            }

            // Check if Bingo pattern is complete
            if (bingo) {
                // Declare bingo
                System.out.println("Card " + card.id + " completes pattern");

                // Output all elements in card form
                System.out.println(card);
            }
        } catch (InterruptedException e) {
            // If interrupted, output "Card [id] loses" and restore the interrupted status
            System.out.println("Card " + card.id + " loses");
            Thread.currentThread().interrupt();
        }
    }

    // Abstract method to be implemented by specific pattern checkers
}
