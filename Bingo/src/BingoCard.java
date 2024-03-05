import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BingoCard {
    List<Integer> numbers;
    int[][] nums;
    int id;

    public BingoCard(int id) {
        this.id = id;
        this.numbers = generateRandomNumbers();
        this.nums = new int[5][5];
        fillNumsArray();
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> cardNumbers = new ArrayList<>();

        // Generate random numbers for B: 01-15
        for (int i = 1; i <= 5; i++) {
            cardNumbers.add(randomInRange(1, 15));
        }

        // Generate random numbers for I: 16-30
        for (int i = 1; i <= 5; i++) {
            cardNumbers.add(randomInRange(16, 30));
        }

        // Generate random numbers for N: 31-45 (3rd element is 0)
        for (int i = 1; i <= 4; i++) {
            cardNumbers.add(randomInRange(31, 45));
        }
        cardNumbers.add(0); // 3rd element is 0

        // Generate random numbers for G: 46-60
        for (int i = 1; i <= 5; i++) {
            cardNumbers.add(randomInRange(46, 60));
        }

        // Generate random numbers for O: 61-75
        for (int i = 1; i <= 5; i++) {
            cardNumbers.add(randomInRange(61, 75));
        }

        // Shuffle the list to randomize the order
        Collections.shuffle(cardNumbers);

        return cardNumbers;
    }

    private int randomInRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    private void fillNumsArray() {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                nums[row][col] = numbers.get(row * 5 + col);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
