import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.JPanel;

public class ApplicationDriver extends javax.swing.JFrame {
    Image img = Toolkit.getDefaultToolkit().getImage("splash.png");

    public ApplicationDriver() throws IOException {
        // get the screen size as a java dimension
        //Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // get 2/3 of the height, and 2/3 of the width
        int height = 1355;
        int width = 904;
        // set the jframe height and width
        //this.setPreferredSize(new Dimension(width, height));
        // create our jframe as usual
        JFrame jframe = new JFrame("Battleship");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set the jframe size and location, and make it visible
        jframe.setPreferredSize(new Dimension(width, height));
        jframe.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        });
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);

        //pack();
        //setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new ApplicationDriver();
    }
}