package Practice4;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CPUFrame extends GameFrame{

    /*
    cpuClosed to pass into main for disposing
    cpu object to handle randomly choosing
    status array to represent the grid with ints
     */
    private boolean cpuClosed = false;
    CPU cpu = new CPU(this);
    private Integer[][] status = getStatus();


    public boolean isCpuClosed() {
        return cpuClosed;
    }
    //getter

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JButton button : buttons) {
            if (e.getSource() == button) {
                if (!button.getText().isEmpty()) return;
                playerMove(button);
                if (checkGameEnd()) return;
                cpuMove();
            }
        }
    }
    //determine the button, if its not empty, player moves, if hasn't ended, cpu moves

    private void playerMove(JButton button) {
        button.setText("O");
        updateStatus(Integer.parseInt(button.getActionCommand()), "O");
        printStatus();
    }
    //set the button to O, update the status

    private void cpuMove() {
        int move = cpu.getRandomMove();
        buttons[move].setText("X");
        updateStatus(move, "X");
        printStatus();
        checkGameEnd();
    }
    //choose a random square, set it to x, update the status, and check if that wins

    private void updateStatus(int value, String player) {
        int OorX = player.equals("O") ? 1 : 2;
        status[value / 3][value % 3] = OorX;
    }
    //same as GameFrame

    private boolean checkGameEnd() {
        int result = winChecker.check(status);
        if (result != 0) {
            String winner = result == 1 ? "O" : "X";
            String message = (result == 3) ? "It's a tie!" : winner + " wins!";
            while(JOptionPane.showOptionDialog(this, message, null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 5) == 5){
            }
            cpuClosed = true;
            return true;
        }
        return false;
    }
    //same as GameFrame, but with cpuClosed = false instead of gameClosed

    private void printStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(status[i][j]);
            }
            System.out.println();
        }
    }
    //same as GameFrame
}
