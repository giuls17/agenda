import javax.swing.*;

public abstract class UIComponent {
    protected JFrame frame;

    public UIComponent() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
    }

    public JFrame getFrame() {
        return frame;
    }
}
