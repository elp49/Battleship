package windowness;

import code.Ship;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public class HealthBarPanel extends JPanel{
	
	public HealthBarData[] myHBD;
	public Ship[] myShipInfo;
	int myPreferredHeight;
	
	public HealthBarPanel(Ship[] myShips) {
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		myHBD = new HealthBarData[myShips.length];
		for(int i = 0; i < myShips.length; i++) {
			//We'll handle the file names at a later date
			myHBD[i] = new HealthBarData("Images/" + myShips[i].getName() + "_Top.png", myShips[i].getName(), myShips[i].getSize());
			add(myHBD[i]);
		}
		if(myHBD.length > 0) {
			myPreferredHeight = myHBD[0].getHeight()*(myShips.length+2);
		}
		else {
			myPreferredHeight = ScreenSizer.SmallestReadableFont.getSize();
		}
		myShipInfo = myShips;
		setBackground(Color.LIGHT_GRAY);
		setVisible(true);
	}
	
	public void visualizeDamage(Ship ship) {
		for(int i = 0; i < myShipInfo.length; i++) {
			if(ship.getName()==myShipInfo[i].getName()) {
				myHBD[i].visualizeDamage(i);
				return;
			}
		}
		//If ship is not in this, then log this info in the console
		System.err.println("Error! Attempted visualizing damage on nonexistent ship!");
	}
	
	public void visualizeSink(Ship ship) {
		for(int i = 0; i < myShipInfo.length; i++) {
			if(ship.getName()==myShipInfo[i].getName()) {
				myHBD[i].visualizeSink();
				return;
			}
		}
	}
	
	public void resetHBP(Ship[] myShips) {
		removeAll();
		myHBD = new HealthBarData[myShips.length];
		for(int i = 0; i < myShips.length; i++) {
			//We'll handle the file names at a later date
			myHBD[i] = new HealthBarData("Images" + System.getProperty("file.separator") + myShips[i].getName() + "_Top.png", myShips[i].getName(), myShips[i].getSize());
			add(myHBD[i]);
		}
		if(myHBD.length > 0) {
			myPreferredHeight = myHBD[0].getHeight()*(myShips.length+2);
		}
		else {
			myPreferredHeight = ScreenSizer.SmallestReadableFont.getSize();
		}
		myShipInfo = myShips;
	}
	
	public void resizeHBP() {
		setPreferredSize(new Dimension(getParent().getPreferredSize().width,myPreferredHeight));
		/*for(int i = 0; i < myHBD.length; i++) {
			myHBD[i].resizeHealthUnitVisuals();
		}*/
	}
	
}
