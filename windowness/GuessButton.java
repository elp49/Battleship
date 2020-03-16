package windowness;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GuessButton extends JPanel {
	
	public boolean isPlayer = false;
	public boolean isClicked = false;
	
	public GuessButton() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(new JLabel(" ") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}},BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void highlightHover() {
		if(!isPlayer && !isClicked) {
			setBackground(Color.YELLOW);
		}
	}
	
	public void unhighlightHover() {
		if(!isPlayer && !isClicked) {
			setBackground(Color.getColor("Parent.Background"));
		}
	}
	
	public void press() {
		if(!isPlayer && !isClicked) {
			setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}
	}
	
	public void release() {
		if(!isPlayer && !isClicked) {
			setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		}
	}
	
	public void setPlayer(boolean player) {
		isPlayer = player;
	}
	
	private void MarkClick() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setBackground(Color.LIGHT_GRAY);
		isClicked = true;
		validate();
		repaint();
	}
	
	public void MarkHit() {
		if(!isPlayer && !isClicked) {
			add(ImageAdd.getImage("Images/HitMarker.png"));
			MarkClick();
		}
	}
	
	public void MarkMiss() {
		if(!isPlayer && !isClicked) {
			add(ImageAdd.getImage("Images/MissMarker.png"));
			MarkClick();
		}
	}
	
	public void reset() {
		setBackground(Color.getColor("Parent.Background"));
		isClicked = false;
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	
}
