package Frame;

import javax.swing.*;
import java.awt.*;

public class FrameInit extends JFrame {
    public FrameInit() throws HeadlessException {
        super("Untitled");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500, 350));
        setSize(new Dimension(600, 400));

        setVisible(true);
    }
}
