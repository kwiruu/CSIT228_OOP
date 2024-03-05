import java.util.ArrayList;
import java.util.List;

public class BingoPatternPlus extends BingoPattern {
    public BingoPatternPlus(BingoCard card) {
        super(card);
        checkers.add(new BingoRowChecker(card, 3));
        checkers.add(new BingoColumnChecker(card, 3));
    }
}

