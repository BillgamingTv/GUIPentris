import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class botOptionsScreen extends JFrame {
    public botOptionsScreen() {
        // icon setup
        ImageIcon dumbBotIcon = new ImageIcon("images/bot_options_menu/dizzy-solid-60.png");
        ImageIcon trainedBotIcon = new ImageIcon("images/bot_options_menu/cloud-lightning-solid-60.png");
        ImageIcon trainYourBotIcon = new ImageIcon("images/bot_options_menu/edit-alt-solid-60.png");
        ImageIcon backArrowIcon = new ImageIcon("images/bot_options_menu/left-arrow-circle-solid-60.png");

        // button setup
        JButton dumbBotButton = new JButton(dumbBotIcon);
        JButton trainedBotButton = new JButton(trainedBotIcon);
        JButton trainYourBotButton = new JButton(trainYourBotIcon);
        JButton backArrowButton = new JButton(backArrowIcon);

        // set button borders to be invisble
        dumbBotButton.setBorder(BorderFactory.createEmptyBorder());
        dumbBotButton.setContentAreaFilled(false);

        trainedBotButton.setBorder(BorderFactory.createEmptyBorder());
        trainedBotButton.setContentAreaFilled(false);

        trainYourBotButton.setBorder(BorderFactory.createEmptyBorder());
        trainYourBotButton.setContentAreaFilled(false);

        backArrowButton.setBorder(BorderFactory.createEmptyBorder());
        backArrowButton.setContentAreaFilled(false);

        // create labels
        JLabel dumbBotLabel = new JLabel("Dumb Bot");
        JLabel trainedBotLabel = new JLabel("Trained Bot");
        JLabel trainYourBotLabel = new JLabel("Train your Bot");
        JLabel backLabel = new JLabel("Go Back To Main Menu");
        JLabel emptyLabel = new JLabel("");
        this.getContentPane().add(dumbBotLabel);

        paintBackground backgroundPanel = new paintBackground(
                "images/bot_options_menu/background_bot_options_revesion2.png");
        this.setContentPane(backgroundPanel);

        // layout setup
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // common settings for layout
        gbc.weightx = 1;
        // adding labels in the first row
        gbc.anchor = GridBagConstraints.CENTER; // center alignment
        gbc.gridy = 0; // first row

        gbc.gridx = 0; // first column
        add(dumbBotLabel, gbc);

        gbc.gridx = 1; // second column
        add(trainedBotLabel, gbc);

        gbc.gridx = 2; // third column
        add(trainYourBotLabel, gbc);

        // adding buttons in the second row
        gbc.fill = GridBagConstraints.HORIZONTAL; // allow horizontal stretch
        gbc.gridy = 1; // second row

        gbc.gridx = 0; // first column
        add(dumbBotButton, gbc);

        gbc.gridx = 1; // second column
        add(trainedBotButton, gbc);

        gbc.gridx = 2; // third column
        add(trainYourBotButton, gbc);

        // Spacer
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20; // increase the internal padding
        add(emptyLabel, gbc);
        gbc.ipady = 0; // reset ipady

        // Back Label
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3; // span across all columns
        gbc.fill = GridBagConstraints.NONE; // do not stretch horizontally
        gbc.anchor = GridBagConstraints.CENTER; // center alignment
        add(backLabel, gbc);

        // Back Button
        gbc.gridx = 0; // start from the first column
        gbc.gridy = 4;
        gbc.gridwidth = 3; // span across all columns
        gbc.fill = GridBagConstraints.NONE; // do not stretch horizontally
        gbc.anchor = GridBagConstraints.CENTER; // center alignment

        add(backArrowButton, gbc);

        // action listeners
        dumbBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("run dumb bot button");
            }
        });

        trainedBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("run trained bot");
            }
        });

        trainYourBotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("train your bot activated");
                // int input pop up
                String input = JOptionPane.showInputDialog(botOptionsScreen.this, "Enter an integer:");
                // int test (we might need to switch it to double values)
                try {
                    int number = Integer.parseInt(input);
                    JOptionPane.showMessageDialog(botOptionsScreen.this, "You entered: " + number);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(botOptionsScreen.this,
                            "Invalid input. Please enter an integer.");
                }

            }
        });

        backArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("going back to main menu");
                openMainMenu();
                
            }
        });


        this.setTitle("Bot Options Screen");
        this.setVisible(true);

    }


    private void openMainMenu() {
        Point location = this.getLocation();
        MainMenu MainMenu = new MainMenu();
        MainMenu.setLocation(location);
        this.dispose();
    }
}
