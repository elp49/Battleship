package windowness;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GuessButton extends JPanel {
	
	boolean player = false;
	boolean clicked = false;
	
	public GuessButton() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));//createEtchedBorder());
		add(new JLabel(" ") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}},BorderLayout.CENTER);
		if(!player) {
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
						MarkClick();
					}
				}
			});
		}
		setVisible(true);
	}
	
	public void setPlayer(boolean isPlayer) {
		player = isPlayer;
	}
	
	private void MarkClick() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setBackground(Color.LIGHT_GRAY);
		ShowWindow.theBattleScreen.log("click");
		clicked = true;
	}
	
	public void MarkHit() {
		MarkClick();
		//show a hit marker on this 
	}
	
	public void MarkMiss() {
		MarkClick();
		//Show a miss marker on this
	}
	
	public void reset() {
		setBackground(Color.getColor("Parent.Background"));
		clicked = false;
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	
}
