import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseScreen extends JFrame {
    public PauseScreen() {
        ImageIcon exitIcon = new ImageIcon("images/pause_menu/exit-solid-60.png");

        JButton exitButton = new JButton(exitIcon);

        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setContentAreaFilled(false);

        paintBackground backgroundPanel = new paintBackground("images/pause_menu/pause_menu_background1.png");
        this.setContentPane(backgroundPanel);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to execute when play button is clicked
                System.out.println("exiting button clicked");
                System.exit(0);
            }
        });
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1; // width between buttons
        add(exitButton, gbc); // first column
        ImageIcon img = new ImageIcon("images/pentomino_logo.png");
        setIconImage(img.getImage());
        setTitle("Paused");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null); // Center on screen
        setSize(520, 636);
        setVisible(true);
        add(exitButton);
    }

    public static void main(String[] args) {
        // Ensuring GUI is created on Event Dispatch Thread because apparently it is
        // better
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PauseScreen();
            }
        });
    }
}