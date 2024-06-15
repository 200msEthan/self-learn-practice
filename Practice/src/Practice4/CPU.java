package Practice4;

import java.util.Random;

public class CPU {

    /*
    random obj for rng
    status 2d array to determine where it can place
     */
    private Random random;
    private Integer[][] status;

    public CPU(GameFrame gameFrame) {
        this.random = new Random();
        this.status = gameFrame.getStatus();
    }
    //constructor to pass in values

    public int getRandomMove() {
        int move;
        do {
            move = random.nextInt(9);
        } while (!isCellEmpty(move));
        return move;
    }
    //gens a num between 0~8, corresponding to the 9 squares
    //making sure the square is not already filled

    private boolean isCellEmpty(int move) {
        int row = move / 3;
        int col = move % 3;
        return status[row][col] == null || status[row][col] == 0;
    }
    //check if the square is empty by using the status array
}
