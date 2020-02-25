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
		//setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.75,0.5));
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
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.25, 0.25));
		setBackground(Color.GREEN);
	}};
	
	/*JPanel BattleGrids = new JPanel() {{
		setLayout(new GridLayout(11,11));
	}};*/
	
	public BattleScreen() {
		//setLayout(new GridLayout(3,2));
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
		//add(MSGBanner);
		//add(BattleGrids);
		//add(GameLog);
		//add(MoveyButtons);
		setVisible(true);
	}
	
	public void setSizes() {
		setSize(new Dimension(super.getParent().getBounds().width-3,super.getParent().getBounds().height-3));
		BattleGrids.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.8),super.getParent().getBounds().height));
		MoveyButtons.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width),(int) (super.getParent().getBounds().height*0.1)));
		GameLog.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.2),super.getParent().getBounds().height));
		MSGBanner.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width),(int) (super.getParent().getBounds().height*0.035)));
		validate();
		repaint();
	}
}
