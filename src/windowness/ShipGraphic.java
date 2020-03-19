package windowness;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import code.Ship;

public class ShipGraphic extends JPanel {

    private Ship myShip;

    public ShipGraphic(Ship ship, BattleGrid bg, int row, int col) {
        myShip = ship;

        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + myShip.getName() + "_Top.png"));
    }

    public void select() {
        this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
    }

    public void deselect() {
        this.setBorder(null);
    }

}
