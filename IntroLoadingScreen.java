import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IntroLoadingScreen extends JFrame implements ActionListener {
    private JButton clearButton;
    private JPanel squarePanel;

    public void BlueWindow() {
        // Set up the window
        setTitle("Blue Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 400));

        // Create the square panel and add it to the window
        squarePanel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillRect(100, 100, 200, 200);
            }
        };
        getContentPane().add(squarePanel, BorderLayout.CENTER);

        // Create the clear button and add it to the window
        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        getContentPane().add(clearButton, BorderLayout.SOUTH);

        // Set the window background color to blue
        getContentPane().setBackground(Color.BLUE);

        // Show the window
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Clear the square and the button
        squarePanel.repaint();
        clearButton.setEnabled(false);
    }


    /*  this is matt: i say remove this eventually because we do not need
     * a main method for this, we just create a loading screen object
     * and we wait until a response from the gameBoardPanel that says the
     * game is ready to play etc. I just dont see a need for the main method
     * correct me if i am wrong.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new IntroLoadingScreen();
            }
        });
    }
}
