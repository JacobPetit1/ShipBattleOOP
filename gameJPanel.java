import javax.swing.*;

import java.awt.*;

public class gameJPanel extends JFrame {

    private JPanel playerGrid;

    private JPanel computerGrid;

    private JLabel playerLabel;

    private JLabel computerLabel;

    public gameJPanel() {

        super("ShipBattle ");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 600);

        setResizable(true);

        setLocationRelativeTo(null);

        GamePanel();

    }

    private void GamePanel() {

        // Create the player grid panel

        playerGrid = new JPanel(new GridLayout(5, 5));

        playerGrid.setPreferredSize(new Dimension(350, 350));

        for (int row = 0; row < 5; row++) {

            for (int col = 0; col < 5; col++) {

                JButton button = new JButton();

                playerGrid.add(button);

            }

        }

        // Create the computer grid panel

        computerGrid = new JPanel(new GridLayout(5, 5));

        computerGrid.setPreferredSize(new Dimension(350, 350));

        for (int row = 0; row < 5; row++) {

            for (int col = 0; col < 5; col++) {

                JButton button = new JButton();

                computerGrid.add(button);

            }

        }

        // Create the player and computer labels

        playerLabel = new JLabel("Player Grid", SwingConstants.CENTER);

        computerLabel = new JLabel("Computer Grid", SwingConstants.CENTER);

        // Add components to the content pane

        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(playerGrid, BorderLayout.WEST);

        getContentPane().add(computerGrid, BorderLayout.EAST);

        getContentPane().add(playerLabel, BorderLayout.NORTH);

        getContentPane().add(computerLabel, BorderLayout.SOUTH);

        setVisible(true);

    }


    // MAtt: I will probably delete this main method when I finish the 
    // @gameBoardShip file so I can start writing a class around this
    // and that class.


    /* Matt: I might write this later.. I will write a menu to have options
     *  for the game: new game - restarts the game, refresh - repaints but 
     * doesnt do anything else
     * 
     * I will also try to implement a console output to the panel, I am
     * not entirely sure how to do that but here comes google.
     */
    public static void main(String[] args) {

        gameJPanel game = new gameJPanel();

    }

}