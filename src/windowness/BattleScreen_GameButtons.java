package windowness;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.Dimension;
import java.awt.event.MouseEvent;

public class BattleScreen_GameButtons extends JPanel{
	
	private JPanel SurrenderButton = new JPanel(){{
		add(ImageAdd.getImage("Images/Surrender_Button_Large.png"));
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e){
				GameplayFunctions.Surrender();
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				
			}
		});
	}};
	
	private JPanel NewGameButton = new JPanel(){{
		add(ImageAdd.getImage("Images/NewGame_Button_Large.png"));
		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e){
				GameplayFunctions.NewGame();
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				
			}
		});
	}};
	
	private JPanel HelpButton = new JPanel(){{
		add(ImageAdd.getImage("Images/Help_Button_Large.png"));
		/*addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e){
				Gameplay_Functions.Surrender();
			}
			public void mouseEntered(MouseEvent e) {
				
			}
			public void mouseExited(MouseEvent e) {
				
			}
			public void mousePressed(MouseEvent e) {
				
			}
			public void mouseReleased(MouseEvent e) {
				
			}
		});*/
	}};
	
	public BattleScreen_GameButtons() {
		new BoxLayout(this,BoxLayout.LINE_AXIS);
		add(SurrenderButton);
		add(NewGameButton);
		add(HelpButton);
	}
	
	public void resizeButtons() {
		//removeAll();
		/*setPreferredSize(new Dimension((int) (super.getParent().getHeight()*4),super.getParent().getHeight()));
		SurrenderButton.removeAll();
		SurrenderButton.add(ImageAdd.getImage("Images/Surrender_Button.png",getPreferredSize().height,getPreferredSize().height));
		NewGameButton.removeAll();
		NewGameButton.add(ImageAdd.getImage("Images/NewGame_Button.png",getPreferredSize().height,getPreferredSize().height));
		HelpButton.removeAll();
		HelpButton.add(ImageAdd.getImage("Images/Help_Button.png",getPreferredSize().height,getPreferredSize().height));
		
		add(SurrenderButton);
		add(NewGameButton);
		add(HelpButton);
		*/
		validate();
		repaint();
	}
}
