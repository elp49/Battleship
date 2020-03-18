package windowness;

import java.awt.*;

import javax.swing.*;

public class MoveShipButtons extends JPanel{
	
	public JButton MoveUp = new JButton() {{
		add(new JLabel("^") {{
			setFont(ScreenSizer.SmallestReadableFont);setAlignmentX(JLabel.CENTER_ALIGNMENT);
			setAlignmentX(JLabel.CENTER_ALIGNMENT);
			setAlignmentY(JLabel.CENTER_ALIGNMENT);
		}});
	}};
	
	public JButton MoveDown = new JButton() {{
		add(new JLabel("v") {{
			setFont(ScreenSizer.SmallestReadableFont);setAlignmentX(JLabel.CENTER_ALIGNMENT);
			setAlignmentX(JLabel.CENTER_ALIGNMENT);
			setAlignmentY(JLabel.CENTER_ALIGNMENT);
		}});
	}};
	
	public JButton MoveLeft = new JButton() {{
		add(new JLabel("<") {{
			setFont(ScreenSizer.SmallestReadableFont);
			setAlignmentX(JLabel.CENTER_ALIGNMENT);
			setAlignmentY(JLabel.CENTER_ALIGNMENT);
		}});
	}};
	
	public JButton MoveRight = new JButton() {{
		add(new JLabel(">") {{
			setFont(ScreenSizer.SmallestReadableFont);
			setAlignmentX(JLabel.CENTER_ALIGNMENT);
			setAlignmentY(JLabel.CENTER_ALIGNMENT);
		}});
	}};
	
	public JButton Rotate = new JButton() {{
		//add(ImageAdd.getImage("Images/Rotate_Icon.png"));
		ImageIcon icon = new ImageIcon("Images" + System.getProperty("file.separator") + "rotate.png");

		JLabel label = new JLabel(icon);
		int h = icon.getIconHeight() / 16;
		int w = icon.getIconWidth() / 16;
		Image scaled = icon.getImage().getScaledInstance(h, w, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaled);
		JLabel scaledLabel = new JLabel(scaledIcon);
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.add(scaledLabel);
		add(panel);
	}};
	
	public MoveShipButtons() {
		setLayout(new BorderLayout());
		add(MoveUp,BorderLayout.NORTH);
		add(MoveDown,BorderLayout.SOUTH);
		add(MoveLeft,BorderLayout.WEST);
		add(MoveRight,BorderLayout.EAST);
		add(Rotate,BorderLayout.CENTER);
	}
	
	public void resizeButtons() {
		setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.2),(int) (super.getParent().getBounds().height)));
		MoveUp.setSize(new Dimension((int) (this.getBounds().width * 0.33),(int) (this.getBounds().height * 0.33)));
		MoveDown.setSize(new Dimension((int) (this.getBounds().width * 0.33),(int) (this.getBounds().height * 0.33)));
		MoveLeft.setSize(new Dimension((int) (this.getBounds().width * 0.33),(int) (this.getBounds().height * 0.33)));
		MoveRight.setSize(new Dimension((int) (this.getBounds().width * 0.33),(int) (this.getBounds().height * 0.33)));
		Rotate.setSize(new Dimension((int) (this.getBounds().width * 0.33),(int) (this.getBounds().height * 0.33)));
		//validate();
		//repaint();
	}
	
	public void setActive(boolean a) {
		MoveUp.setEnabled(a);
		MoveDown.setEnabled(a);
		MoveLeft.setEnabled(a);
		MoveRight.setEnabled(a);
		Rotate.setEnabled(a);
	}
	
}
