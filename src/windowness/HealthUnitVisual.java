package windowness;

import javax.swing.*;

public class HealthUnitVisual extends JPanel{
	
	public HealthUnitVisual(){
		add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "HealthIndicator_Good.png",ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize()));
	}
	
	public void takeDamage() {
		removeAll();
		add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "HealthIndicator_Hit.png",ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize()));
	}
	
	public void hasSank() {
		removeAll();
		add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "HealthIndicator_Sink.png",ScreenSizer.SmallestReadableFont.getSize(),ScreenSizer.SmallestReadableFont.getSize()));
	}
	
}
