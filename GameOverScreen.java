import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverScreen extends JFrame {
    public GameOverScreen() {
        ImageIcon playIcon = new ImageIcon("images/game_over_screen/refresh-regular-60.png");
        ImageIcon exitIcon = new ImageIcon("images/game_over_screen/exit-solid-60.png");
        ImageIcon backArrowIcon = new ImageIcon("images/bot_options_menu/left-arrow-circle-solid-60.png");

        JButton playButton = new JButton(playIcon);
        JButton exitButton = new JButton(exitIcon);
        JButton backArrowButton = new JButton(backArrowIcon);

        playButton.setBorder(BorderFactory.createEmptyBorder());
        playButton.setContentAreaFilled(false);

        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setContentAreaFilled(false);

        backArrowButton.setBorder(BorderFactory.createEmptyBorder());
        backArrowButton.setContentAreaFilled(false);

        JLabel emptyLabel = new JLabel("");

        paintBackground backgroundPanel = new paintBackground("images/game_over_screen/game_over_background.png");
        this.setContentPane(backgroundPanel);

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

        backArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("going back to main menu");
                openMainMenu();
                
            }
        });

        // Layout setup
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // needs to be removed
        JLabel gameOverLabel = new JLabel(""); // is not being used
        gameOverLabel.setHorizontalAlignment(JLabel.CENTER); // not being used

        gbc.weightx = 1;// width between icons
        add(playButton, gbc);
        gbc.gridx = 1; // Second column
        add(exitButton, gbc);

        // Spacer
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20; // increase the internal padding
        add(emptyLabel, gbc);
        gbc.ipady = 0; // reset ipady



        // Back Button
        gbc.gridx = 0; // start from the first column
        gbc.gridy = 4;
        gbc.gridwidth = 3; // span across all columns
        gbc.fill = GridBagConstraints.NONE; // do not stretch horizontally
        gbc.anchor = GridBagConstraints.CENTER; // center alignment

        add(backArrowButton, gbc);

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

    private void openMainMenu() {
        Point location = this.getLocation();
        MainMenu MainMenu = new MainMenu();
        MainMenu.setLocation(location);
        this.dispose();
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