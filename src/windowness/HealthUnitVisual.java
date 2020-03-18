package windowness;

import java.awt.Color;

import javax.swing.*;

public class HealthUnitVisual extends JPanel{
	
	public HealthUnitVisual(){
		//setBackground(Color.GREEN);
		add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "HealthIndicator_Good.png",ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize()));
		//setSize(ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize());
	}
	
	public void takeDamage() {
		//setBackground(Color.RED);
		removeAll();
		add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "HealthIndicator_Hit.png",ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize()));
	}
	
	public void hasSank() {
		//setBackground(Color.DARK_GRAY);
		removeAll();
		add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "HealthIndicator_Sink.png",ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize()));
	}
	
}
