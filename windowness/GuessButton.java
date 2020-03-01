package windowness;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GuessButton extends JPanel {
	
	public boolean player = false;
	boolean clicked = false;
	
	public GuessButton() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));//createEtchedBorder());
		add(new JLabel(" ") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}},BorderLayout.CENTER);
		/*if(!player) {
			addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent e){
					//Do Nothing
				}
				public void mouseEntered(MouseEvent e) {
					if(!player && !clicked) {
						setBackground(Color.YELLOW);
					}
				}
				public void mouseExited(MouseEvent e) {
					if(!player && !clicked) {
						setBackground(Color.getColor("Parent.Background"));
					}
				}
				public void mousePressed(MouseEvent e) {
					if(!player && !clicked) {
						setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
					}
				}
				public void mouseReleased(MouseEvent e) {
					if(!player && !clicked) {
						setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
						//Remove next line and add proper listener later
						MarkClick();
					}
				}
			});
		}*/
		setVisible(true);
	}
	
	public void highlightHover() {
		if(!player && !clicked) {
			setBackground(Color.YELLOW);
		}
	}
	
	public void unhighlightHover() {
		if(!player && !clicked) {
			setBackground(Color.getColor("Parent.Background"));
		}
	}
	
	public void press() {
		if(!player && !clicked) {
			setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}
	}
	
	public void release() {
		if(!player && !clicked) {
			setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		}
	}
	
	public void setPlayer(boolean isPlayer) {
		player = isPlayer;
	}
	
	private void MarkClick() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setBackground(Color.LIGHT_GRAY);
		clicked = true;
		validate();
		repaint();
	}
	
	public void MarkHit() {
		add(ImageAdd.getImage("HitMarker.png"));
		MarkClick();
	}
	
	public void MarkMiss() {
		add(ImageAdd.getImage("MissMarker.png"));
		MarkClick();
	}
	
	public void reset() {
		setBackground(Color.getColor("Parent.Background"));
		clicked = false;
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	
}
