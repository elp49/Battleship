package windowness;

import java.awt.Color;
import java.awt.Dimension;
import java.nio.file.FileSystem;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import code.Ship;

public class ShipGraphic extends JPanel{
	
	private Ship myShip;
	
	public ShipGraphic(Ship ship, BattleGrid bg, int row, int col) {
		myShip = ship;
		
		add(ImageAdd.getImage("Images" + System.getProperty("file.separator") +
				myShip.getName() + "_Top.png"));
		
		//bg.addShip(this,row,col);
		
		//setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * (myShip.getSize()*0.1)),(int) (super.getParent().getBounds().height * 0.1)));
	}
	
	public void select() {
		this.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
	}
	
	public void deselect() {
		this.setBorder(null);
	}
	
}
