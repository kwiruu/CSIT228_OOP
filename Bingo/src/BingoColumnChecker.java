public class BingoColumnChecker extends BingoChecker {
    private int col;

    public BingoColumnChecker(BingoCard card, int col) {
        super(card);
        this.col = col;
    }

    @Override
    public void run() {
        synchronized (BingoGame.result) {
            for (int row = 0; row < 5; row++) {
                int num = card.nums[row][col];

                while (!BingoGame.result[num]) {
                    try {
                        BingoGame.result.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("BingoColumnChecker for element " + num + " was interrupted.");
                        return;
                    }
                }
            }
        }
    }
}
