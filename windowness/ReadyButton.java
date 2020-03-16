package windowness;

import javax.swing.JPanel;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ReadyButton extends JPanel {
	
	private boolean isActive = false;
	
	public void setActive(boolean active){
		if(isActive != active) {
			isActive = active;
			removeAll();
			swapImage();
		}
		validate();
		repaint();
	}
	
	private void swapImage() {
		if(isActive) {
			add(ImageAdd.getImage("Images/READY_active.png"));
		}
		else {
			add(ImageAdd.getImage("Images/READY_inactive.png"));
		}
	}
	
	public ReadyButton() {
		swapImage();
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e){
				if(isActive) {
					GameplayFunctions.ReadyToPlay();
				}
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				
			}
		});
	}
	
}
