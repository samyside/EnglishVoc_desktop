package Frame;

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
    private JLabel labelOutput;

    private Connection conn;
    private Statement stmt;
    private ResultSet res;

    public FrameTemp() {
        super("Title name");
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(500, 350));
        setLocationRelativeTo(null);

        connectToDB();
        showTable();
        close();
        enterTheAnswerTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SimpleDialog();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (labelOutput.getText().equals(enterTheAnswerTextField.getText())) {
                    new SimpleDialog("Your answer...");
                }
            }
        });

        // clear inputTextField when focused
        enterTheAnswerTextField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                enterTheAnswerTextField.setText("");
            }
        });
    }

    private void connectToDB() {
        try {
            final String URL = "jdbc:sqlite:src/main/resources/database.db";
            conn = DriverManager.getConnection(URL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void showTable() {
        String sql = "SELECT name, password FROM temp_table";
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);

            labelOutput.setText(res.getString("name"));

            while (res.next()) {
                System.out.println(res.getString("name") + "\t" +
                        res.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Handled exception\n" +
                    "See details: ");
            e.printStackTrace();
        }
    }

}
