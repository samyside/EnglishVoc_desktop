package Service;

import Frames.FrameTemp;
import Service.Element.Word;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

public class Actions extends FocusAdapter implements ActionListener {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textInput;
    private JLabel labelOutput;
    private ArrayList<Word> words;

    public Actions(FrameTemp frame) {
        button1 = frame.getButton1();
        button2 = frame.getButton2();
        button3 = frame.getButton3();
        button4 = frame.getButton4();
        button5 = frame.getButton5();
        textInput = frame.getTextInput();
        labelOutput = frame.getLabelOutput();
        words = frame.getWords();
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (textInput.getText().equals("Enter the answer")) {
            textInput.setText("");
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (textInput.getText().equals("")) {
            textInput.setText("Enter the answer");
        }
    }

    private int count;
    @Override
    public void actionPerformed(ActionEvent e) {

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
            try {
                if (textInput.getText().equals(words.get(count).getRusWord())) {
                    System.out.println(words.get(count).getRusWord() + " - Right!");
                    count++;
                    labelOutput.setText(words.get(count).getEngWord());
                    textInput.setText("");
                } else {
                    System.out.println(textInput.getText() + " - Wrong!");
                }
            } catch (IndexOutOfBoundsException ex) {
                ex.printStackTrace();
                labelOutput.setText("Список слов закончился");
            }
        }
    }
}
