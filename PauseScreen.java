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

        setContentPane(new BackgroundPanel()); // sets the background which contains the welcome to pentris text and the
                                               // pentominoes art.

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
         gbc.weightx = 1; //width between buttons
         add(exitButton, gbc); //first column
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

        //class for the pentominoes background importation
        class BackgroundPanel extends JPanel {
            private Image backgroundImage;
    
            //constructor
            public BackgroundPanel() {
                backgroundImage = new ImageIcon("images/pause_menu/pause_menu_background1.png").getImage();
            }
    
            //override paintComponent
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the background image
                g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
            }
        }  

    public static void main(String[] args) {
        new PauseScreen();
    }
}
