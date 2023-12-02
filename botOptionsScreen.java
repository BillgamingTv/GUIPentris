import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class botOptionsScreen extends JFrame {
    public botOptionsScreen() {
        ImageIcon dumbBotIcon = new ImageIcon("images/bot_options_menu/dizzy-solid-60.png");
        ImageIcon trainedBotIcon = new ImageIcon("images/bot_options_menu/cloud-lightning-solid-60.png");
        ImageIcon trainYourBotIcon = new ImageIcon("images/bot_options_menu/edit-alt-solid-60.png");

        JButton dumbBotButton = new JButton(dumbBotIcon);
        JButton trainedBotButton = new JButton(trainedBotIcon);
        JButton trainYourBotButton = new JButton(trainYourBotIcon);

        dumbBotButton.setBorder(BorderFactory.createEmptyBorder());
        dumbBotButton.setContentAreaFilled(false);

        trainedBotButton.setBorder(BorderFactory.createEmptyBorder());
        trainedBotButton.setContentAreaFilled(false);

        trainYourBotButton.setBorder(BorderFactory.createEmptyBorder());
        trainYourBotButton.setContentAreaFilled(false);

        JLabel dumbBotLabel = new JLabel("Dumb Bot");
        JLabel trainedBotLabel = new JLabel("Trained Bot");
        JLabel trainYourBotLabel = new JLabel("Train your Bot");
        this.getContentPane().add(dumbBotLabel);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Common settings for all components
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.NONE; // No stretching

        // Adding labels in the first row
        gbc.anchor = GridBagConstraints.CENTER; // Center alignment
        gbc.gridy = 0; // First row

        gbc.gridx = 0; // First column
        add(dumbBotLabel, gbc);

        gbc.gridx = 1; // Second column
        add(trainedBotLabel, gbc);

        gbc.gridx = 2; // Third column
        add(trainYourBotLabel, gbc);

        // Adding buttons in the second row
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow horizontal stretching
        gbc.gridy = 1; // Second row

        gbc.gridx = 0; // First column
        add(dumbBotButton, gbc);

        gbc.gridx = 1; // Second column
        add(trainedBotButton, gbc);

        gbc.gridx = 2; // Third column
        add(trainYourBotButton, gbc);

        // JLabel label = new JLabel("This is the Bot Options Screen");
        // this.getContentPane().add(label);
        this.setTitle("Bot Options Screen");
        this.setVisible(true);

    }
}
