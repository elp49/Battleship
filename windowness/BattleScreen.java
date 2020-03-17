package windowness;

import javax.swing.*;
import java.awt.*;

import code.Ship;
import controllers.BattleGridController;
import controllers.HealthBarPanelController;
import controllers.MoveShipButtonController;

public class BattleScreen extends ScreenPanel {
	
	BattleGridController playerBGC = new BattleGridController();
	BattleGridController opponentBGC = new BattleGridController();
	
	HealthBarPanelController myHBPC = new HealthBarPanelController();
	
	/*JPanel MSGBanner = new JPanel() {{
		setLayout(new FlowLayout());
		setBackground(Color.RED);
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(1, 0.03));
		add(new JLabel("Test Text") {{
			setForeground(Color.WHITE);
			setFont(new Font("Arial",Font.PLAIN,ScreenSizer.getScreenWidth()/90));
		}});
	}};*/
	MessageBanner MSGBanner = new MessageBanner();
	
	JPanel BattleGrids = new JPanel() {{
		setLayout(new GridLayout(1,2));
		add(new BattleGrid());
		add(new BattleGrid());
	}};
	
	JPanel MoveyButtons = new JPanel() {{
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.325, 0.1));
		//setBackground(Color.BLUE);
		setLayout(new BorderLayout());
		//add(new MoveShipButtons());
	}};
	
	JPanel GameLog_HealthBars = new JPanel() {{
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(0.25, 0.25));
	}};
	
	GameLog myGameLog = new GameLog(12);
	HealthBarPanel myHBP = new HealthBarPanel(new Ship[0]);
	
	MoveShipButtons myMoveShipButtons = new MoveShipButtons();
	BattleScreen_GameButtons myBSGB = new BattleScreen_GameButtons();
	ReadyButton myReady = new ReadyButton();
	
	public BattleGrid playerBG = new BattleGrid();
	public BattleGrid opponentBG = new BattleGrid();
	
	MoveShipButtonController myMSBC = new MoveShipButtonController();
	
	public BattleScreen() {
		setLayout(new BorderLayout());
		add(MSGBanner, BorderLayout.PAGE_START);
		add(BattleGrids,BorderLayout.LINE_START);
		
		MoveyButtons.add(myMoveShipButtons,BorderLayout.WEST);
		MoveyButtons.add(myBSGB,BorderLayout.EAST);
		MoveyButtons.add(myReady,BorderLayout.CENTER);
		add(MoveyButtons,BorderLayout.SOUTH);
		//myMoveShipButtons.setPreferredSize(new Dimension((int) (myMoveShipButtons.getParent().getBounds().width * 0.4),(int) (myMoveShipButtons.getParent().getBounds().height)));
		
		GameLog_HealthBars.add(myGameLog);
		GameLog_HealthBars.add(myHBP);
		add(GameLog_HealthBars,BorderLayout.LINE_END);
		setVisible(true);
	}
	
	public void setSizes() {
		setSize(new Dimension(super.getParent().getBounds().width,super.getParent().getBounds().height));
		BattleGrids.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.8),super.getParent().getBounds().height));
		MoveyButtons.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width),(int) (super.getParent().getBounds().height*0.2)));
		myMoveShipButtons.resizeButtons();
		myBSGB.resizeButtons();
		//myMoveShipButtons.setPreferredSize(new Dimension((int) (myMoveShipButtons.getParent().getBounds().width * 0.4),(int) (myMoveShipButtons.getParent().getBounds().height)));
		//myBSGB.setPreferredSize(new Dimension((int) (myBSGB.getParent().getBounds().width * 0.4),(int) (myBSGB.getParent().getBounds().height)));
		GameLog_HealthBars.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.2),super.getParent().getBounds().height));
		MSGBanner.setPreferredSize(new Dimension((int) (super.getParent().getBounds().width),(int) (super.getParent().getBounds().height*0.035)));
		myGameLog.resizeLog();
		validate();
		repaint();
		playerBG.resizeImages();
		opponentBG.resizeImages();
	}
	
	public void reload() {
		BattleGrids.removeAll();
		playerBG = (BattleGrid) BattleGrids.add(new BattleGrid() {{setPlayer(true);}});
		//new ShipGraphic(new Ship() {{setName("Carrier");setSize(5);}},holdP,0,0);
		playerBGC.setBattleGridControl(playerBG);
		opponentBG = (BattleGrid) BattleGrids.add(new BattleGrid());
		opponentBGC.setBattleGridControl(opponentBG);
		BattleGrids.validate();
		BattleGrids.repaint();
		
		//This is a place holder and will be replaced with proper code later
		myHBP.resetHBP(new Ship[] {
				new Ship() {{setName("Carrier");setSize(5);}},
				new Ship() {{setName("Battleship");setSize(4);}},
				new Ship() {{setName("Destroyer");setSize(3);}},
				new Ship() {{setName("Submarine");setSize(3);}},
				new Ship() {{setName("Patrol Boat");setSize(2);}}
		});
		
		myHBPC.setHBPControl(myHBP);
		
		myMSBC.setMSBControl(myMoveShipButtons);
		
		myGameLog.resetLog();
		myGameLog.resizeLog();
		log("Starting New Game",Color.CYAN);
		
		myMoveShipButtons.resizeButtons();
		myBSGB.resizeButtons();
	}
	
	public void message(String msg) {
		MSGBanner.setText(msg);
	}
	
	public void log(String toLog) {
		message(toLog);
		myGameLog.log(toLog);
		validate();
		repaint();
	}
	
	public void log(String toLog, Color txtColor) {
		message(toLog);
		myGameLog.log(toLog, txtColor);
		validate();
		repaint();
	}
}
