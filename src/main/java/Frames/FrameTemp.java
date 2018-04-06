package Frames;

import Service.Actions;
import Service.DataBase.Database;
import Service.Element.Word;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    private ArrayList<Word> words = new ArrayList<>();

    private Database database = new Database();

    public FrameTemp() {
        super("Title name");
        setContentPane(panelMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 350));
        setMaximumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);

        Actions action = new Actions(this);
        textInput.addActionListener(action);
        textInput.addFocusListener(action);
        button1.addActionListener(action);
        button2.addActionListener(action);
        button3.addActionListener(action);
        button4.addActionListener(action);
        button5.addActionListener(action);


        database.createConnection();
        labelOutput.setText(database.getFirstWord());

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/words.db");
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT engWord, rusWord FROM table_words");

            while (rset.next()) {
                words.add(new Word(
                        rset.getString("engWord"),
                        rset.getString("rusWord"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Word word : words) {
            System.out.println(word.getEngWord());
            System.out.println(word.getRusWord());
        }
    }

    public List<Word> getWords() {
        return words;
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
