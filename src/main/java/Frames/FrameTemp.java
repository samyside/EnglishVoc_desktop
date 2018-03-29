package Frames;

import Service.Actions;
import Service.DataBase.Database;

import javax.swing.*;
import java.awt.*;

public class FrameTemp extends JFrame {
    private JPanel panelMain;
    private JPanel panelTop;
    private JPanel panelBottom;
    private JPanel panelLeft;
    private JPanel panelCenter;
    private JPanel panelContent;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JTextField textInput;
    private JLabel labelOutput;


    private Database database = new Database();
    private Actions action = new Actions(this);

    public FrameTemp() {
        super("Title name");
        setContentPane(panelMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 350));
        setMaximumSize(new Dimension(800,500));
        setLocationRelativeTo(null);

        textInput.addActionListener(action);
        textInput.addFocusListener(action);
        button1.addActionListener(action);
        button2.addActionListener(action);
        button3.addActionListener(action);
        button4.addActionListener(action);
        button5.addActionListener(action);

        database.createConnection();
        labelOutput.setText(database.getFirstWord());

        
    }

    public Database getDatabase() {
        return database;
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public JButton getButton5() {
        return button5;
    }

    public JTextField getTextInput() {
        return textInput;
    }

    public JLabel getLabelOutput() {
        return labelOutput;
    }
}
