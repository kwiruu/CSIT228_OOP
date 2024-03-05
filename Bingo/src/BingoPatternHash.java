public abstract class BingoPatternHash extends BingoPattern {
    public BingoPatternHash(BingoCard card) {
        super(card);
        checkers.add(new BingoRowChecker(card, 1)); // Second row
        checkers.add(new BingoRowChecker(card, 3)); // Fourth row
        checkers.add(new BingoColumnChecker(card, 1)); // Second column
        checkers.add(new BingoColumnChecker(card, 3)); // Fourth column
    }
}
