package windowness;

import javax.swing.*;
import java.awt.*;

public class BattleScreen extends JPanel {
	
	//public JButton[][] mySquares;
	
	JPanel MSGBanner = new JPanel() {{
		setLayout(new FlowLayout());
		setBackground(Color.RED);
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(1, 0.03));
		add(new JLabel("Test Text") {{
			setForeground(Color.WHITE);
			setFont(new Font("Arial",Font.PLAIN,ScreenSizer.getScreenWidth()/90));
		}});
	}};
	
	JPanel BattleGrids = new JPanel() {{
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.65,0.5));
		//setLayout(new BoxLayout(BattleGrids, BoxLayout.LINE_AXIS));
		setLayout(new GridLayout(1,2));
		add(new BattleGrid());
		add(new BattleGrid());
	}};
	
	JPanel MoveyButtons = new JPanel() {{
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.325, 0.1));
		setBackground(Color.BLUE);
	}};
	
	JPanel GameLog = new JPanel() {{
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.35, 0.25));
		setBackground(Color.GREEN);
	}};
	
	/*JPanel BattleGrids = new JPanel() {{
		setLayout(new GridLayout(11,11));
	}};*/
	
	public BattleScreen() {
		setLayout(new BorderLayout());
		//addWithWindowPortionAndLayout(MSGBanner,1,0.5,BorderLayout.PAGE_START);
		add(MSGBanner, BorderLayout.PAGE_START);
		add(BattleGrids,BorderLayout.LINE_START);
		//add(new BattleGrid(), BorderLayout.LINE_START);
		//addAsHeightBasedSquareWithWindowPortionAndLayout(new BattleGrid(),0.75,BorderLayout.LINE_START);
		//addAsHeightBasedSquareWithWindowPortionAndLayout(new BattleGrid(),0.75,BorderLayout.LINE_END);
		//add(new BattleGrid(), BorderLayout.LINE_END);
		add(MoveyButtons,BorderLayout.SOUTH);
		add(GameLog,BorderLayout.LINE_END);
		//setBorder(BorderFactory.createEtchedBorder());
		//add(BattleGrids);
		setVisible(true);
	}
}
