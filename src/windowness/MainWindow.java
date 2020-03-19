package windowness;

import java.awt.*;

import javax.swing.*;

public class MainWindow extends JFrame{
	public static double screenDefaultPortion = 0.8;
	
	public int screenHigh = (int) Math.floor(ScreenSizer.getScreenHeight()*screenDefaultPortion);
	public int screenWid = (int) Math.floor(ScreenSizer.getScreenWidth()*screenDefaultPortion);
	
	public ScreenPanel curScreen = ShowWindow.theMenuScreen;
	
	public MenuBar myMenuBar = new MenuBar();
	
	public MainWindow() {
		setTitle("BATTLESHIP");
		
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new BorderLayout());
		
		contentPane.add(myMenuBar,BorderLayout.PAGE_START);
		contentPane.add(curScreen,BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(0,0,screenWid,screenHigh);
		setVisible(true);
	}
	
	public void setScreen(ScreenPanel screen) {
		getContentPane().remove(curScreen);
		curScreen = screen;
		getContentPane().add(curScreen);
		curScreen.setSizes();
		validate();
		repaint();
	}
}
