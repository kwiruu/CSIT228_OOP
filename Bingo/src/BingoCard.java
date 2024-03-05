import java.util.Random;

public class BingoCard {
    int[][] nums;
    int id;


    public BingoCard(int id) {
        this.id = id;
        nums = new int[5][5];


        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int randomValue = 0;
                Random random = new Random();

                do {
                    if (j == 0) {
                        randomValue = random.nextInt(15)+1;
                    } else if (j == 1) {
                        randomValue = random.nextInt(15)+16;
                    } else if (j == 2 && i != 2) {
                        randomValue = random.nextInt(15)+32;
                    } else if (j == 3) {
                        randomValue = random.nextInt(15)+48;
                    } else if(j==4){
                        randomValue = random.nextInt(15)+64;
                    }
                } while (isParehow(randomValue, i, j));

                nums[i][j] = randomValue;
            }
        }

    }

    public boolean isParehow(int num, int upperbound, int col){
        for(int i=0;i<upperbound;i++) {
            if(nums[i][col] == num){
                return true;
            }
        }
        return false;
    }

    private int randomRange(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int row = 0; row < 5; row++){
            for(int col = 0; col < 5; col++){
                sb.append(nums[row][col]).append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
