import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        ImageIcon playIcon = new ImageIcon("images/main_menu/play-regular-60.png");
        ImageIcon exitIcon = new ImageIcon("images/main_menu/exit-solid-60.png");
        ImageIcon botIcon = new ImageIcon("images/main_menu/bot-solid-60.png");
        ImageIcon helpIcon = new ImageIcon("images/help_menu/info-circle-solid-60.png");

        JButton playButton = new JButton(playIcon);
        JButton exitButton = new JButton(exitIcon);
        JButton botButton = new JButton(botIcon);
        JButton helpButton = new JButton(helpIcon);

        // removing blue frame of buttons

        playButton.setBorder(BorderFactory.createEmptyBorder());
        playButton.setContentAreaFilled(false);

        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setContentAreaFilled(false);

        botButton.setBorder(BorderFactory.createEmptyBorder());
        botButton.setContentAreaFilled(false);

        helpButton.setBorder(BorderFactory.createEmptyBorder());
        helpButton.setContentAreaFilled(false);

        paintBackground backgroundPanel = new paintBackground(
                "images/main_menu/background_with_pentominoes_and_font_revision3.png");
        this.setContentPane(backgroundPanel);

        // Adding ActionListener to buttons
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // code to execute when play button is clicked
                System.out.println("play button clicked");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // exits if exit button is clicked
                System.out.println("exit button clicked");
                System.exit(0);
            }
        });

        botButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("opening bot options JFrame");
                openBotOptionsScreen();

            }
        });

        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("opening info menu");
                openHelpMenu();

            }
        });

        // Layout setup
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1; // width between buttons
        add(playButton, gbc); // first column
        gbc.gridx = 1;
        add(botButton, gbc); // second column
        gbc.gridx = 2;
        add(exitButton, gbc); // third column
        // GridBag constraints for the new icon
        gbc.gridx = 1; // second column (the center)
        gbc.gridy = 2; // second row
        gbc.gridwidth = 1; // width
        gbc.anchor = GridBagConstraints.CENTER; // centering icon
        gbc.insets = new Insets(25, 0, 0, 0); // a way of leaving space between rows
        add(helpButton, gbc);

        // Window Properties
        ImageIcon img = new ImageIcon("images/pentomino_logo.png");
        setIconImage(img.getImage());
        setTitle("Pentris Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null); // Center on screen
        setSize(520, 636);
        setVisible(true);
    }

    // public void setBackGround(String backgroundPath) {
    // paintBackground paintBackground = new paintBackground();
    // paintBackground.BackgroundPanel(backgroundPath);
    // }

    // could probaly use 1 method here to open all panels
    private void openBotOptionsScreen() {
        Point location = this.getLocation();
        botOptionsScreen botOptionsScreen = new botOptionsScreen();
        ImageIcon img = new ImageIcon("images/pentomino_logo.png");
        botOptionsScreen.setIconImage(img.getImage());
        botOptionsScreen.setLocation(location);
        botOptionsScreen.setSize(520, 636);
        botOptionsScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botOptionsScreen.setResizable(false);
        this.dispose();
    }

    private void openHelpMenu() {
        helpMenu help = new helpMenu();
        //centering window
        Point mainWindowLocation = this.getLocation();
        Dimension mainWindowSize = this.getSize();
        int x = mainWindowLocation.x + (mainWindowSize.width - help.getWidth()) / 2;
        int y = mainWindowLocation.y + (mainWindowSize.height - help.getHeight()) / 2;
        help.setLocation(x, y);
        help.setVisible(true);
    }
}