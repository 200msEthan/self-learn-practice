package Practice4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ChooseFrame extends JFrame implements ActionListener{

    /*
    output: 1 = 2P mode, 2 = CPU mode
    question textfield to show the question
    twoPlayers and CPU buttons for options
     */
    private int output = 0;
    JTextField question = new JTextField();
    JButton twoPlayers = new JButton();
    JButton CPU = new JButton();
    ChooseFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setResizable(false);
        this.add(question);
        this.add(twoPlayers);
        this.add(CPU);
        //exits on close, no layout, 500x500, not resizable, adds the textfield and buttons

        question.setText("2P or CPU?");
        question.setFont(new Font("Arial", Font.PLAIN, 40));
        question.setBounds(145, 90, 250, 100);
        question.setFocusable(false);
        question.setEditable(false);
        question.setBorder(null);
        question.setVisible(true);
        //question textfield properties

        twoPlayers.setText("2P");
        twoPlayers.setFont(new Font("Arial", Font.PLAIN, 40));
        twoPlayers.setBounds(100, 190, 100, 50);
        twoPlayers.setBackground(Color.blue);
        twoPlayers.setFocusable(false);
        twoPlayers.setBorder(null);
        twoPlayers.addActionListener(this);
        twoPlayers.setVisible(true);

        CPU.setText("CPU");
        CPU.setFont(new Font("Arial", Font.PLAIN, 40));
        CPU.setBounds(270, 190, 100, 50);
        CPU.setBackground(Color.red);
        CPU.setFocusable(false);
        CPU.setBorder(null);
        CPU.addActionListener(this);
        CPU.setVisible(true);
        //twoPlayers and CPU button properties

        this.setVisible(true);
        //show the ChooseFrame
    }

    public int getOutput() {
        return output;
    }
    //getter

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == twoPlayers){
            output = 1;
        }else{
            output = 2;
        }
    }
    //determine which button is pressed, and change output accordingly
}
