import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class helpMenu extends JFrame {

    public helpMenu() {
        // a check I found in case the testing enviroment does not support transparency
        // (just in case)
        if (!GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
                .isWindowTranslucencySupported(GraphicsDevice.WindowTranslucency.TRANSLUCENT)) {
            System.err.println("Transparency not supported in this environment");
            return;
        }
        // frame setup
        setUndecorated(true);
        setSize(300, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
        setOpacity(0.9f); // transparency

        // labels
        JLabel titleLabel = new JLabel("<html><div style='text-align: center;'>" +
                "<br/>" +
                "Keybinds");
        JLabel textLabel = new JLabel("<html><div style='text-align: center;'>" +
                "P - Pause<br/>" +
                "O - Resume<br/>" +
                "R - Rotate<br/>" +
                "Space - Drop<br/>" +
                "A - Move Left<br/>" +
                "D - Move Right<br/>" +
                "S - Move Down Faster</div></html>");
        // label setup
        titleLabel.setOpaque(false);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 35));
        textLabel.setOpaque(false);
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setFont(new Font("Arial", Font.BOLD, 25));

        getContentPane().setBackground(Color.LIGHT_GRAY);

        add(titleLabel, BorderLayout.NORTH);
        add(textLabel, BorderLayout.CENTER);

        // add close button
        ImageIcon backArrowIcon = new ImageIcon("images/bot_options_menu/left-arrow-circle-solid-60.png");
        JButton backArrowButton = new JButton(backArrowIcon);
        backArrowButton.setBorder(BorderFactory.createEmptyBorder());
        backArrowButton.setContentAreaFilled(false);
        backArrowButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("closing info menu");
                dispose();
            }
        });
        // using a JPanel to add space to between the border and the button
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.add(backArrowButton, BorderLayout.CENTER);
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Top, left, bottom, right padding
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
