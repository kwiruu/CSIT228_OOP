public class BingoColChecker extends BingoChecker {
    int col;
    public BingoColChecker(BingoCard card, int row) {
        super(card);
        this.col = col-1;
    }

    @Override
    public void run() {
        for(int row=0; row < 5; row++){
            int num = card.nums[row][col];
            while(!BingoGame.result[num]){
                try {
                    synchronized(BingoGame.result) {
                        BingoGame.result.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("Card + " + card.id + " done: " + card);
    }
}
