package Frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel message;

    SimpleDialog(String msg) {
        super((Frame) null, "Message");
        setContentPane(contentPane);
        setSize(new Dimension(160, 90));
        setResizable(false);
        setLocationRelativeTo(null);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        message.setText(msg);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });
        pack();

    }


    private void onOK() {
        // add your code here
        dispose();
    }
}
