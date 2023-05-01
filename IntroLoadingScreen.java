import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IntroLoadingScreen extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private JLabel label;
    private JButton startButton;
    private JPanel panel;

    public IntroLoadingScreen() {
        super("ShipBattle");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));
        setResizable(false);

        // Create the title label
        label = new JLabel("ShipBattle");
        label.setFont(new Font("Arial", Font.BOLD, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(label, BorderLayout.NORTH);

        // Create the image label
        JLabel imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("path/to/image.jpg"); // Replace with the actual path to your image file
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(scaledImageIcon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(imageLabel, BorderLayout.CENTER);

        // Create the start button
        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.PLAIN, 20));
        startButton.addActionListener(this);

        // Create the panel to hold the start button
        panel = new JPanel();
        panel.add(startButton);
        getContentPane().add(panel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startButton) {
            // Open the Battleship game window
            dispose(); // Close the start screen
            new IntroLoadingScreen();
        }
    }

    public static void main(String[] args) {
        new IntroLoadingScreen();
    }
}