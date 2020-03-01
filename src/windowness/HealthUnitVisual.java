package windowness;

import java.awt.Color;

import javax.swing.*;

public class HealthUnitVisual extends JPanel{
	
	public HealthUnitVisual(){
		setBackground(Color.GREEN);
		setSize(ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize());
	}
	
	public void takeDamage() {
		setBackground(Color.RED);
	}
	
	public void hasSank() {
		setBackground(Color.DARK_GRAY);
	}
	
}
