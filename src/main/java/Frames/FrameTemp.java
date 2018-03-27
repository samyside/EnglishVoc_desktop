package Frames;

import Service.Actions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.*;

public class FrameTemp extends JFrame {
    private JPanel panel1;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JPanel panelLeft;
    private JPanel panelCenter;
    private JPanel panelContent;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button1;
    private JTextField enterTheAnswerTextField;
    private JButton button5;

    public JLabel labelOutput;

    private Actions action = new Actions();

    private SimpleDialog dialogRight = new SimpleDialog("Right!");

    public FrameTemp() {
        super("Title name");
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 350));
        setLocationRelativeTo(null);



        enterTheAnswerTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        // clear inputTextField when it focused
        enterTheAnswerTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                enterTheAnswerTextField.setText("");
            }
        });

        enterTheAnswerTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                enterTheAnswerTextField.setText("put a text here");
            }
        });
    }

    public static JFrame getThisFrame() {
        return null;
    }

}
