package Main;

import Frames.FrameTemp;

public class Main {
    public static FrameTemp frame = new FrameTemp();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
    }
}
