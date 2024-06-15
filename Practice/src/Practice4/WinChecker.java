package Practice4;

public class WinChecker {
    public int check(Integer[][] status){

        int output = 0; //0 = nope, 1 = O wins, 2 = X wins, 3 = tie
        //check if its a tie, allFull is checked at the very end
        boolean allFull = true;
        for (int row = 0; row < 3; row++){
            for (int column = 0; column < 3; column++) {
                if(status[row][column] == 0){
                    allFull = false;
                }
            }
        }
        //check for horizontal wins
        for (int row = 0; row < 3; row++) {
            if (!(status[row][0] == 0) &&
                    status[row][0].equals(status[row][1]) &&
                    status[row][1].equals(status[row][2])) {
                if (status[row][0] == 1) {
                    output = 1;
                }else{
                    output = 2;
                }break;
            }
        }
        if (output != 0){
            return output;
        }

        //check for vertical wins
        for (int column = 0; column < 3; column++) {
            if (!(status[0][column] == 0) &&
                    status[0][column].equals(status[1][column]) &&
                    status[1][column].equals(status[2][column])) {
                if (status[0][column] == 1) {
                    output = 1;
                }else{
                    output = 2;
                }break;
            }
        }
        if (output != 0){
            return output;
        }

        //check for diagonal wins
        if (!(status[0][0] == 0) &&
                (status[0][0].equals(status[1][1])) &&
                (status[1][1].equals(status[2][2]))){
            if (status[0][0] == 1) {
                output = 1;
            }else{
                output = 2;
            }
        }
        if (output != 0){
            return output;
        }
        if (!(status[0][2] == 0) &&
                (status[0][2].equals(status[1][1])) &&
                (status[1][1].equals(status[2][0]))){
            if (status[0][2] == 1) {
                output = 1;
            }else{
                output = 2;
            }
        }

        //if no wins, and its all full, its a tie
        if(allFull && output == 0) output = 3;

        return output;
    }
}
