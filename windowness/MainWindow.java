package windowness;

import javax.swing.*;

public class MainWindow extends JFrame{
	public static double screenDefaultPortion = 0.8;
	
	public int screenHigh = (int) Math.floor(ScreenSizer.getScreenHeight()*screenDefaultPortion);
	public int screenWid = (int) Math.floor(ScreenSizer.getScreenWidth()*screenDefaultPortion);
	
	public JPanel curScreen = new JPanel();
	
	/*JButton testio = new JButton("TEST") {{
		setFont(new Font("Arial", Font.PLAIN, (int)screenWid/30));
	}};*/
	
	public MainWindow() {
		setTitle("BATTLESHIP");
		
		//getContentPane().add(testio);
		getContentPane().add(curScreen);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		setBounds(0,0,screenWid,screenHigh);
		setVisible(true);
	}
	
	public void setScreen(JPanel screen) {
		getContentPane().remove(curScreen);
		curScreen = screen;
		getContentPane().add(curScreen);
		validate();
		repaint();
		//curScreen = screen;
		//getContentPane().remove(curScreen);
		//curScreen = screen;
		//getContentPane().add(curScreen);
	}
}
