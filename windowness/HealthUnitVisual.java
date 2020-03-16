package windowness;

import java.awt.Color;

import javax.swing.*;

public class HealthUnitVisual extends JPanel{
	
	public HealthUnitVisual(){
		//setBackground(Color.GREEN);
		add(ImageAdd.getImage("Images/HealthIndicator_Good.png"));
		//setSize(ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize());
	}
	
	public void takeDamage() {
		//setBackground(Color.RED);
		removeAll();
		add(ImageAdd.getImage("Images/HealthIndicator_Hit.png"));
	}
	
	public void hasSank() {
		//setBackground(Color.DARK_GRAY);
		removeAll();
		add(ImageAdd.getImage("Images/HealthIndicator_Sink.png"));
	}
	
}
