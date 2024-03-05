public class BingoRowChecker extends BingoChecker {
    private int row;

    public BingoRowChecker(BingoCard card, int row) {
        super(card);
        this.row = row ;
    }

    @Override
    public void run() {
        synchronized (BingoGame.result) {
            for (int col = 0; col < 5; col++) {
                int num = card.nums[row][col];

                while (!BingoGame.result[num]) {
                    try {
                        BingoGame.result.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("BingoRowChecker for element " + num + " was interrupted.");
                        return;
                    }
                }
            }
        }
    }
}
