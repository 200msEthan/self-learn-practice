package Practice4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements ActionListener {

    /*
    gameClosed to update Main on when to dispose
    buttons for easy initializing and detecting actions from the buttons
    status to represent the status of the entire board in a 2d array
    winChecker to check if there is a win, or tie
    isO to determine whether it should place an O or X on the buttons
     */
    private boolean gameClosed = false;
    JButton[] buttons = new JButton[9]; //array of all 9 buttons
    private Integer[][] status = new Integer[3][3]; //2d array of ints to represent the status of the buttons
    WinChecker winChecker = new WinChecker(); //object to check if there's a win
    Boolean isO = true; //bool to check if its O or X

    GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3, 10, 10));
        this.setSize(500, 500);
        this.setResizable(false);
        //frame settings: exit on close, 3x3, 500x500, not resizable

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this);
            buttons[i].setActionCommand(String.valueOf(i));
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 50));
            buttons[i].setFocusable(false);
            this.add(buttons[i]);
        }
        //initializing buttons, adding actionlisteners and action commands
        //setting the font, and focusable properties

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                status[i][j] = 0;
            }
        }
        //zeroing the values of status

        this.setVisible(true);
        //finally making the frame visible
    }

    public Integer[][] getStatus() {
        return status;
    }

    public boolean isGameClosed() {
        return gameClosed;
    }
    //a few getters

    @Override
    public void actionPerformed(ActionEvent e) {
        for(JButton button : buttons){
            if (e.getSource() == button) {
                if (!button.getText().isEmpty()) return;
                playerMove(button);
                checkGameEnd();
                break;
            }
        }
    }
    //on press, determine the button, if it's not empty, make a move, and check for win

    private void playerMove(JButton button) {
        button.setText(isO ? "O" : "X");
        updateStatus(Integer.parseInt(button.getActionCommand()), isO ? "O" : "X");
        isO = !isO;
        printStatus();
    }
    //passing in a button, set the text according to isO, update the status array
    //flip the isO boolean, then print the status into console (debug)

    private void updateStatus(int value, String player) {
        int OorX = player.equals("O") ? 1 : 2;
        status[value/3][value%3] = OorX; //update the status val in the grid
    }
    //updating the 2d array's values with OorX depending on if the
    //pressed button was an O or X

    private boolean checkGameEnd() {
        int result = winChecker.check(status);
        if (result != 0) {
            String winner = result == 1 ? "O" : "X";
            String message = (result == 3) ? "It's a tie!" : winner + " wins!";
            while(JOptionPane.showOptionDialog(this, message, null, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, 5) == 5){
            }
            gameClosed = true;
            return true;
        }
        return false;
    }
    //result = win or not, winner and message are for notifying who the winner is
    //updates gameClosed to pass into main

    private void printStatus() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(status[i][j]);
            }
            System.out.println();
        }
    }
    //prints the status array, debug
}
