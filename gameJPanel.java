import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.*;

public class gameJPanel extends JFrame implements ActionListener, KeyListener{

    private JMenuBar menuBar;

    private JPanel textPanel;

    private JPanel playerGrid;

    private JPanel computerGrid;

    private JLabel playerLabel;

    private JLabel computerLabel;


    // gameJPanel constructer
    public gameJPanel() {

        super("ShipBattle ");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800, 600);

        setResizable(false);

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

        textPanel = new JPanel();

        // Create menu bar and menus. 
        menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(fileMenu);

        JMenuItem openMenuItem = new JMenuItem("Open", KeyEvent.VK_O);
        fileMenu.add(openMenuItem);

        JMenuItem saveMenuItem = new JMenuItem("Save", KeyEvent.VK_S);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();

        JMenuItem exitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(KeyEvent.VK_E);
        menuBar.add(editMenu);
        
        JMenuItem clearMenuItem = new JMenuItem("Clear", KeyEvent.VK_C);
        clearMenuItem.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                repaint();
            }
        });        
        editMenu.add(clearMenuItem);
        add(menuBar, BorderLayout.NORTH);
        // Create the player and computer labels

        playerLabel = new JLabel("Player Grid", SwingConstants.CENTER);

        computerLabel = new JLabel("Computer Grid", SwingConstants.CENTER);


        // Add components to the content pane

        getContentPane().setLayout(new BorderLayout());

        getContentPane().add(menuBar, BorderLayout.NORTH);

        getContentPane().add(playerGrid, BorderLayout.WEST);

        getContentPane().add(computerGrid, BorderLayout.EAST);

        //getContentPane().add(playerLabel, BorderLayout.NORTH);

        //getContentPane().add(computerLabel, BorderLayout.SOUTH);

        setVisible(true);
    }

    // fill these in later
    public void actionPerformed(ActionEvent e) {}
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    // MAtt: I will probably delete this main method when I finish the 
    // @gameBoardShip file so I can start writing a class around this
    // and that class.


    /* Matt: I might write this later.. I will write a menu to have options
     *  for the game: new game - restarts the game, refresh - repaints but 
     * doesnt do anything else
     * 
     * NOTE: with the layout, it does not stack so you cant have the
     * computer and player lable in the same spots north. like north north 
     * will throw an error, we need to make a new frame.
     */
    public static void main(String[] args) {

        gameJPanel game = new gameJPanel();

    }

}