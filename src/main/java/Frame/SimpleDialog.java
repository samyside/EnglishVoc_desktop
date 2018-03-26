package Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel yourAnswer;

    SimpleDialog() {
        super((Frame) null, "Title name");
        setContentPane(contentPane);
        setSize(new Dimension(160, 90));
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        setVisible(true);
    }

    SimpleDialog(String title) {
        this();
        setTitle(title);

        yourAnswer.setText("... is right!");
        setVisible(true);
    }


    private void onOK() {
        // add your code here
        dispose();
    }
}
