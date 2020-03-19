package windowness;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

public class BattleScreen_GameButtons extends JPanel {

    private JPanel SurrenderButton = new JPanel() {{
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Surrender_Button.png"));
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                GameplayFunctions.Surrender();
            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }
        });
    }};

    private JPanel NewGameButton = new JPanel() {{
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "NewGame_Button_Large.png"));
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                GameplayFunctions.NewGame();
            }

            public void mouseEntered(MouseEvent e) {

            }

            public void mouseExited(MouseEvent e) {

            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }
        });
    }};

    private JPanel HelpButton = new JPanel() {{
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Help_Button_Large.png"));
        addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                GameplayFunctions.openHelpWindow();
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
            }

            public void mouseReleased(MouseEvent e) {
            }
        });
    }};

    public BattleScreen_GameButtons() {
        new BoxLayout(this, BoxLayout.LINE_AXIS);
        add(SurrenderButton);
        add(NewGameButton);
        add(HelpButton);
    }

    public void resizeButtons() {
        removeAll();
        setPreferredSize(new Dimension((int) (super.getParent().getHeight() * 4), super.getParent().getHeight()));
        SurrenderButton.removeAll();
        SurrenderButton.add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Surrender_Button.png", getBounds().height / 2, getBounds().height / 2));
        NewGameButton.removeAll();
        NewGameButton.add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "NewGame_Button.png", getBounds().height / 2, getBounds().height / 2));
        HelpButton.removeAll();
        HelpButton.add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Help_Button.png", getBounds().height / 2, getBounds().height / 2));

        add(SurrenderButton);
        add(NewGameButton);
        add(HelpButton);

        validate();
        repaint();
    }
}
