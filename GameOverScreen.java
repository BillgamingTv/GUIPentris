import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JFrame {
    public GameOverScreen() {
        ImageIcon playIcon = new ImageIcon("images/game_over_screen/refresh-regular-60.png");
        ImageIcon exitIcon = new ImageIcon("images/game_over_screen/exit-solid-60.png");

        JButton playButton = new JButton(playIcon);
        JButton exitButton = new JButton(exitIcon);

        playButton.setBorder(BorderFactory.createEmptyBorder());
        playButton.setContentAreaFilled(false);

        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setContentAreaFilled(false);

        setContentPane(new BackgroundPanel()); // sets the background which contains the welcome to pentris text and the
                                               // pentominoes art.

        // Adding ActionListener to buttons
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to execute when play button is clicked
                System.out.println("replay button clicked!");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // exits if exit button is clicked
                System.out.println("Exit button clicked!");
                System.exit(0);
            }
        });

        // Layout setup
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        //needs to be removed
        JLabel gameOverLabel = new JLabel(""); //is not being used
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER); //not being used


        gbc.weightx = 1;//width between icons
        add(playButton, gbc);
        gbc.gridx = 1; // Second column
        add(exitButton, gbc);

        // Window Properties
        ImageIcon img = new ImageIcon("images/pentomino_logo.png");
        setIconImage(img.getImage());
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 30));
        setTitle("Game Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null); // Center on screen
        setSize(520, 636);
        setVisible(true);
    }

    // Custom JPanel class for the pentominoes background + the text
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        // Constructor to load the image
        public BackgroundPanel() {
            backgroundImage = new ImageIcon("images/game_over_screen/game_over_background.png").getImage();
        }

        // Override paintComponent
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    public static void main(String[] args) {
        // Ensuring GUI is created on Event Dispatch Thread because apparently it is
        // better
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOverScreen();
            }
        });
    }
}