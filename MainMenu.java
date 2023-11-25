import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        ImageIcon playIcon = new ImageIcon("images/play-regular-60.png");
        ImageIcon exitIcon = new ImageIcon("images/exit-solid-60.png");

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
                System.out.println("Play button clicked!");
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

        // Label with text
        JLabel welcomeLabel = new JLabel(""); //is not being used
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER); //not being used

        //constraints for the label for the icons
        gbc.gridx = 0; // Column 0
        gbc.gridy = 0; // Row 0
        gbc.gridwidth = GridBagConstraints.REMAINDER; // component spans all columns
        gbc.anchor = GridBagConstraints.CENTER; // center alignment
        gbc.weightx = 1;
        gbc.weighty = 0.1; // Adjust the vertical weight as needed

        // Adding text pentris label to the gbc
        add(welcomeLabel, gbc);

        // Resetting constraints for buttons
        gbc.gridwidth = 1; // Reset to default
        gbc.gridy = 1; // Move to the next row
        gbc.weighty = 1; // Adjust for button spacing

        // play button
        gbc.gridx = 0; // First column
        add(playButton, gbc);

        // exit button
        gbc.gridx = 1; // Second column
        add(exitButton, gbc);

        // Window Properties
        ImageIcon img = new ImageIcon("images/pentomino_logo.png");
        setIconImage(img.getImage());
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 30));
        setTitle("Pentris Main Menu");
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
            backgroundImage = new ImageIcon("images/background_with_pentominoes_and_font.png").getImage();
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
                new MainMenu();
            }
        });
    }
}