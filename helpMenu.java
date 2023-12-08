import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class helpMenu extends JFrame {
    public helpMenu() {

        ImageIcon backArrowIcon = new ImageIcon("images/bot_options_menu/left-arrow-circle-solid-60.png");
        JButton backArrowButton = new JButton(backArrowIcon);

        backArrowButton.setBorder(BorderFactory.createEmptyBorder());
        backArrowButton.setContentAreaFilled(false);

        String helpText = "<html><center>p - Pause<br>o - Resume<br>r - Rotate<br>Space - Drop Piece<br>a - Move Piece Left<br>d - Move Piece Right<br>s - Move Piece Down Faster</center></html>";
        JLabel helpLabel = new JLabel(helpText);
        helpLabel.setFont(new Font("Arial", Font.BOLD, 20));
        // background
        paintBackground backgroundPanel = new paintBackground(
                "images/help_menu/help_menu_background.png");

        backArrowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("going back to main menu");
                openMainMenu();

            }
        });
        // layout and window setup
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();


        gbc.weightx = 1;// width between icons
        add(helpLabel, gbc);
        // Back Button
        gbc.gridx = 0; // start from the first column
        gbc.gridy = 4;
        gbc.gridwidth = 3; // span across all columns
        gbc.fill = GridBagConstraints.NONE; // do not stretch horizontally
        gbc.anchor = GridBagConstraints.CENTER; // center alignment
        gbc.insets = new Insets(25, 0, 0, 0);

        add(backArrowButton, gbc);
        this.setContentPane(backgroundPanel);
        this.setTitle("Help Menu");
        this.setLayout(new BorderLayout());
        this.add(helpLabel);
        this.add(backArrowButton);

        this.pack();
        this.setVisible(true);

    }

    private void openMainMenu() {
        Point location = this.getLocation();
        MainMenu MainMenu = new MainMenu();
        MainMenu.setLocation(location);
        this.dispose();
    }
}