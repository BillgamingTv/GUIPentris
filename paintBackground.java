import javax.swing.*;
import java.awt.*;

class paintBackground extends JPanel {
    private Image backgroundImage;

    // Constructor to load the image
    public paintBackground(String filePath) {
        backgroundImage = new ImageIcon(filePath).getImage();
    }

    // Override paintComponent
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw the background image
        g.drawImage(backgroundImage, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
