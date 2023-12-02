import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class botOptionsScreen extends JFrame {
    public botOptionsScreen() {
        JLabel label = new JLabel("This is the Bot Options Screen");
        this.getContentPane().add(label);
        this.setTitle("Bot Options Screen");
        this.setVisible(true);
    }
}
