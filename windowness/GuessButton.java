package windowness;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;

public class GuessButton extends JPanel {
	
	public GuessButton() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));//createEtchedBorder());
		add(new JLabel(" ") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}},BorderLayout.CENTER);
		setVisible(true);
	}
	
	private void MarkClick() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
	}
	
	public void MarkHit() {
		MarkClick();
		//show a hit marker on this 
	}
	
	public void MarkMiss() {
		MarkClick();
		//Show a miss marker on this
	}
	
}
