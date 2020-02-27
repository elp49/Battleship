package windowness;

import java.awt.Color;

import javax.swing.*;

public class HealthUnitVisual extends JPanel{
	
	public HealthUnitVisual(){
		setBackground(Color.GREEN);
	}
	
	public void takeDamage() {
		setBackground(Color.RED);
	}
	
	public void hasSank() {
		setBackground(Color.DARK_GRAY);
	}
	
}
