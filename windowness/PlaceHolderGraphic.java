package windowness;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PlaceHolderGraphic extends JPanel{
	
	//This graphic will be displayed when attempting to make one from a nonexistent file
	public PlaceHolderGraphic() {
		setBackground(Color.BLACK);
		add(new JLabel("PLACEHOLDER") {{
			setFont(ScreenSizer.SmallestReadableFont);
			setForeground(Color.WHITE);
		}});
	}
	
}
