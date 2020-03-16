package windowness;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.*;

public class HealthBarData extends JPanel{
	
	public JPanel myPicHolder;
	JLabel myShipName;
	HealthUnitVisual[] myHealthView;
	JPanel myHealthBar = new JPanel(){{
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
	}};
	boolean imageLoadFailed = false;
	
	public HealthBarData(String pic, String name, int healthAmt) {
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		myPicHolder = ImageAdd.getImage(pic);
		
		myShipName = new JLabel(name.toUpperCase()) {{
			setFont(ScreenSizer.SmallestReadableFont);
		}};
		
		myHealthView = new HealthUnitVisual[healthAmt];
		for(int i = 0; i < healthAmt; i++) {
			myHealthView[i] = new HealthUnitVisual();
			myHealthBar.add(myHealthView[i]);
		}
		
		add(myPicHolder);
		add(myShipName);
		add(myHealthBar);
	}
	
	/*public void resizeHealthUnitVisuals() {
		for(int i = 0; i < myHealthView.length; i++) {
			myHealthView[i].setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.2),(int) (super.getParent().getBounds().width * 0.2)));
		}
	}*/
	
	public void visualizeDamage(int pos) {
		myHealthView[pos].takeDamage();
		myHealthBar.validate();
		myHealthBar.repaint();
	}
	
	public void visualizeSink() {
		for(int i = 0; i < myHealthView.length; i++) {
			myHealthView[i].hasSank();
		}
		myHealthBar.validate();
		myHealthBar.repaint();
	}
}
