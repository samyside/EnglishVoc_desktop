package Frames;

import Service.Actions;
import Service.DataBase.DatabaseCheck;

import javax.swing.*;
import java.awt.*;

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

    private JLabel labelOutput;

    private Actions action = new Actions();
    private SimpleDialog dialogRight = new SimpleDialog("Right!");
    private DatabaseCheck database = new DatabaseCheck();

    public FrameTemp() {
        super("Title name");
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 350));
        setLocationRelativeTo(null);

        enterTheAnswerTextField.addActionListener(action);
        button1.addActionListener(action);
        enterTheAnswerTextField.addFocusListener(action);
        enterTheAnswerTextField.addFocusListener(action);

        labelOutput.setText(database.getFirstName());


    }

}
