package Service;

import Frames.FrameTemp;
import Service.DataBase.Database;
import Service.Element.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

public class Actions extends FocusAdapter implements ActionListener {
    private FrameTemp frame;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textInput;
    private JLabel labelOutput;
    private Database database;
    private List<Word> words;

    public Actions(FrameTemp frame) {
        this.frame = frame;
        button1 = this.frame.getButton1();
        button2 = this.frame.getButton2();
        button3 = this.frame.getButton3();
        button4 = this.frame.getButton4();
        button5 = this.frame.getButton5();
        textInput = this.frame.getTextInput();
        labelOutput = this.frame.getLabelOutput();
        database = this.frame.getDatabase();
        words = this.frame.getWords();
    }

    @Override
    public void focusGained(FocusEvent e) {
        textInput.setText("");
    }

    @Override
    public void focusLost(FocusEvent e) {
        textInput.setText("Enter the your answer");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int count = 0;

        if (e.getSource().equals(button1)) {
            labelOutput.setText("The button#1 has been pressed");
        } else if (e.getSource().equals(button2)) {
            labelOutput.setText("The button#2 has been pressed");
        } else if (e.getSource().equals(button3)) {
            labelOutput.setText("The button#3 has been pressed");
        } else if (e.getSource().equals(button4)) {
            labelOutput.setText("The button#4 has been pressed");
        } else if (e.getSource().equals(button5)) {
            labelOutput.setText("The button#5 has been pressed");
        } else if (e.getSource().equals(textInput)) {
            System.out.println("actionPerformed for textInput works");
            if (labelOutput.getText().equals(words.get(count).getRusWord())) {
                System.out.println("Right!");
                labelOutput.setText(words.get(count).getEngWord());
            } else {
                System.out.println("Wrong!");
            }
        }
    }
}
