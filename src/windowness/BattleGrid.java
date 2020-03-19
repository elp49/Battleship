package windowness;

import java.awt.*;
import javax.swing.*;

public class BattleGrid extends JPanel {

    public JPanel[] myCharLabels = new JPanel[11];
    public JPanel[] myNumLabels = new JPanel[10];
    public GuessButton[][] mySquares = new GuessButton[10][10];

    public BattleGrid() {
        setLayout(new GridLayout(11, 11));
        setPreferredSize(ScreenSizer.getPortionOfSquareFromHeight(0.75));

        char hold = ' ';
        for (int i = 0; i < myCharLabels.length; i++) {
            myCharLabels[i] = new JPanel() {{
                setLayout(new BorderLayout());
                setBorder(BorderFactory.createEtchedBorder());
                setVisible(true);
            }};
            myCharLabels[i].add(new JLabel("" + hold) {{
                setFont(ScreenSizer.SmallestReadableFont);
                setAlignmentX(Component.CENTER_ALIGNMENT);
                setAlignmentY(Component.CENTER_ALIGNMENT);
            }}, BorderLayout.CENTER);
            if (i == 0) {
                hold = 'A';
            } else {
                hold += 1;
            }
            add(myCharLabels[i]);
        }
        int hold_n = 1;
        for (int i = 0; i < myNumLabels.length; i++) {
            myNumLabels[i] = new JPanel() {{
                setLayout(new BorderLayout());
                setBorder(BorderFactory.createEtchedBorder());
                setVisible(true);
            }};
            myNumLabels[i].add(new JLabel("" + hold_n) {{
                setFont(ScreenSizer.SmallestReadableFont);
                setAlignmentX(Component.CENTER_ALIGNMENT);
                setAlignmentY(Component.CENTER_ALIGNMENT);
            }}, BorderLayout.CENTER);
            hold_n++;
        }

        for (int i = 0; i < mySquares.length; i++) {
            for (int j = -1; j < mySquares[i].length; j++) {
                if (j < 0) {
                    add(myNumLabels[i]);
                } else {
                    mySquares[i][j] = new GuessButton();
                    add(mySquares[i][j]);
                }
            }
        }
    }

    public void setPlayer(boolean isPlayer) {
        for (int i = 0; i < mySquares.length; i++) {
            for (int j = 0; j < mySquares[i].length; j++) {
                mySquares[i][j].setPlayer(isPlayer);
            }
        }
    }

    public void resizeImages() {
        for (int i = 0; i < mySquares.length; i++) {
            for (int j = 0; j < mySquares[i].length; j++) {
                mySquares[i][j].resizeImage();
            }
        }
    }

    public void reset() {
        for (int i = 0; i < mySquares.length; i++) {
            for (int j = 0; j < mySquares[i].length; j++) {
                mySquares[i][j].reset();
            }
        }
    }

    public void setActive(boolean a) {
        for (int i = 0; i < mySquares.length; i++) {
            for (int j = 0; j < mySquares[i].length; j++) {
                mySquares[i][j].isClicked = !a;
            }
        }
    }
}
