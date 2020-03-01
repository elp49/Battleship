package windowness;

import javax.swing.*;
import java.awt.*;

import code.Ship;
import controllers.BattleGridController;

public class BattleScreen extends JPanel {
	
	BattleGridController playerBGC = new BattleGridController();
	BattleGridController opponentBGC = new BattleGridController();
	
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
		setLayout(new GridLayout(1,2));
		add(new BattleGrid());
		add(new BattleGrid());
	}};
	
	JPanel MoveyButtons = new JPanel() {{
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.325, 0.1));
		setBackground(Color.BLUE);
	}};
	
	JPanel GameLog_HealthBars = new JPanel() {{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.25, 0.25));
	}};
	
	GameLog myGameLog = new GameLog(12);
	HealthBarPanel myHBP = new HealthBarPanel(new Ship[0]);
	
	public BattleScreen() {
		setLayout(new BorderLayout());
		add(MSGBanner, BorderLayout.PAGE_START);
		add(BattleGrids,BorderLayout.LINE_START);
		add(MoveyButtons,BorderLayout.SOUTH);
		GameLog_HealthBars.add(myGameLog);
		GameLog_HealthBars.add(myHBP);
		add(GameLog_HealthBars,BorderLayout.LINE_END);
		setVisible(true);
	}
	
	public void setSizes() {
		setSize(new Dimension(super.getParent().getBounds().width,super.getParent().getBounds().height));
		BattleGrids.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.8),super.getParent().getBounds().height));
		MoveyButtons.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width),(int) (super.getParent().getBounds().height*0.1)));
		GameLog_HealthBars.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.2),super.getParent().getBounds().height));
		MSGBanner.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width),(int) (super.getParent().getBounds().height*0.035)));
		myGameLog.resizeLog();
		validate();
		repaint();
	}
	
	public void reload() {
		BattleGrids.removeAll();
		BattleGrid holdP = (BattleGrid) BattleGrids.add(new BattleGrid() {{setPlayer(true);}});
		playerBGC.setBattleGridControl(holdP);
		BattleGrid holdO = (BattleGrid) BattleGrids.add(new BattleGrid());
		opponentBGC.setBattleGridControl(holdO);
		BattleGrids.validate();
		BattleGrids.repaint();
		
		//This is a place holder and will be replaced with proper code later
		myHBP.resetHBP(new Ship[] {
				new Ship() {{setName("Destroyer");setSize(3);}},
				new Ship() {{setName("Patrol Boat");setSize(2);}}
		});
		
		myGameLog.resetLog();
		myGameLog.resizeLog();
		myGameLog.log("Starting New Game",Color.CYAN);
	}
	
	public void log(String toLog) {
		myGameLog.log(toLog);
	}
	
	public void log(String toLog, Color txtColor) {
		myGameLog.log(toLog, txtColor);
		validate();
		repaint();
	}
}
