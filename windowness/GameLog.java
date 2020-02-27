package windowness;

import javax.swing.*;
import java.awt.*;

public class GameLog extends JPanel {
	
	JLabel[] myLabels;
	int myPreferredHeight;
	
	//create a new Gamelog screen element
	public GameLog(int maxMessages){
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		setBackground(Color.DARK_GRAY);
		myPreferredHeight = ScreenSizer.SmallestReadableFont.getSize()*(maxMessages+2);
		myLabels = new JLabel[maxMessages];
		for(int i = 0; i < maxMessages; i++) {
			myLabels[i] = null;
		}
	}
	
	//log text with the default color
	public void log(String toLog) {
		log(toLog,Color.WHITE);
	}
	
	//log text with a given color
	public void log(String toLog, Color txtColor) {
		JLabel newLog = new JLabel(toLog) {{
			setFont(ScreenSizer.SmallestReadableFont);
			setForeground(txtColor);
			setAlignmentX(Component.CENTER_ALIGNMENT);
		}};
		
		for(int i = 0; i < myLabels.length; i++) {
			if(myLabels[i]==null) {
				myLabels[i] = newLog;
				add(myLabels[i]);
				validate();
				return;
			}
		}
		//If we don't have space in our log, cycle out the old stuff
		remove(myLabels[0]);
		for(int i = 0; i < myLabels.length-1; i++) {
			myLabels[i] = myLabels[i+1];
		}
		myLabels[myLabels.length-1] = newLog;
		add(myLabels[myLabels.length-1]);
		validate();
		repaint();
	}
	
	//Remove all text from the log and resize it
	public void resetLog() {
		removeAll();
		for(int i = 0; i < myLabels.length; i++) {
			myLabels[i] = null;
		}
		validate();
	}
	
	public void resizeLog() {
		setPreferredSize(new Dimension(getParent().getPreferredSize().width,myPreferredHeight));
	}
	
}
