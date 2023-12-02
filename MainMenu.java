import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        ImageIcon playIcon = new ImageIcon("images/main_menu/play-regular-60.png");
        ImageIcon exitIcon = new ImageIcon("images/main_menu/exit-solid-60.png");
        ImageIcon botIcon = new ImageIcon("images/main_menu/bot-solid-60.png");

        JButton playButton = new JButton(playIcon);
        JButton exitButton = new JButton(exitIcon);
        JButton botButton = new JButton(botIcon);

        playButton.setBorder(BorderFactory.createEmptyBorder());
        playButton.setContentAreaFilled(false);

        exitButton.setBorder(BorderFactory.createEmptyBorder());
        exitButton.setContentAreaFilled(false);

        botButton.setBorder(BorderFactory.createEmptyBorder());
        botButton.setContentAreaFilled(false);

        setContentPane(new BackgroundPanel()); // sets the background which contains the welcome to pentris text and the
                                               // pentominoes art.

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

        // Layout setup
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1; // width between buttons
        add(playButton, gbc); // first column
        gbc.gridx = 1;
        add(botButton, gbc); // second column
        gbc.gridx = 2;
        add(exitButton, gbc); // third column

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

    // class for the pentominoes background importation
    class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        // constructor
        public BackgroundPanel() {
            backgroundImage = new ImageIcon("images/main_menu/background_with_pentominoes_and_font_revision3.png")
                    .getImage();
        }

        //override paintComponent
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }

    private void openBotOptionsScreen() {
        Point location = this.getLocation();
        this.dispose();
        botOptionsScreen botOptionsScreen = new botOptionsScreen();
        ImageIcon img = new ImageIcon("images/pentomino_logo.png");
        botOptionsScreen.setIconImage(img.getImage());
        botOptionsScreen.setLocation(location);
        botOptionsScreen.setSize(520,636);
        botOptionsScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        botOptionsScreen.setResizable(false);
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