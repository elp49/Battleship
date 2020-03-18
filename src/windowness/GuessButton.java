package windowness;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.util.ArrayList;

public class GuessButton extends JPanel {
	
	public boolean isPlayer = false;
	public boolean isClicked = false;
	private ArrayList<String> myImageNames = new ArrayList<String>();
	
	public GuessButton() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(new JLabel(" ") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}},BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void highlightHover() {
		if(!isPlayer && !isClicked) {
			setBackground(Color.YELLOW);
		}
	}
	
	public void unhighlightHover() {
		if(!isPlayer && !isClicked) {
			setBackground(Color.getColor("Parent.Background"));
		}
	}
	
	public void press() {
		if(!isPlayer && !isClicked) {
			setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}
	}
	
	public void release() {
		if(!isPlayer && !isClicked) {
			setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		}
	}
	
	public void setPlayer(boolean player) {
		isPlayer = player;
	}
	
	private void MarkClick() {
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setBackground(Color.LIGHT_GRAY);
		isClicked = true;
		validate();
		repaint();
	}
	
	public void MarkHit() {
		if(!isPlayer && !isClicked) {
			String imgName = "Images" + System.getProperty("file.separator") + "HitMarker.png";
			myImageNames.add(imgName);
			//add(ImageAdd.getImage(imgName,getBounds().width,getBounds().height));
			
			ImageIcon icon = new ImageIcon(imgName);
			JLabel label = new JLabel(icon);
			int h = icon.getIconHeight() / 2;
			int w = icon.getIconWidth() / 2;
			Image scaled = icon.getImage().getScaledInstance(h, w, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaled);
			JLabel scaledLabel = new JLabel(scaledIcon);
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			panel.add(scaledLabel);
			add(panel);
			
			MarkClick();
		}
	}
	
	public void MarkMiss() {
		if(!isPlayer && !isClicked) {
			String imgName = "Images" + System.getProperty("file.separator") + "MissMarker.png";
			myImageNames.add(imgName);
			//add(ImageAdd.getImage(imgName,getBounds().width,getBounds().height));
			
			ImageIcon icon = new ImageIcon(imgName);
			JLabel label = new JLabel(icon);
			int h = icon.getIconHeight() / 2;
			int w = icon.getIconWidth() / 2;
			Image scaled = icon.getImage().getScaledInstance(h, w, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaled);
			JLabel scaledLabel = new JLabel(scaledIcon);
			JPanel panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			panel.add(scaledLabel);
			add(panel);
			
			MarkClick();
		}
	}
	
	public void reset() {
		setBackground(Color.getColor("Parent.Background"));
		isClicked = false;
		setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
	}
	
	public void DisplayShip(String ship, int section) {
		String imgName = "Images/" + ship + "_Top_sect" + section + ".png";
		myImageNames.add(imgName);
		add(ImageAdd.getImage(imgName,getBounds().width,getBounds().height));
		validate();
		repaint();
	}
	
	public void DisplayShip(String ship, int section, boolean isVertical) {
		String imgName = "Images/" + ship + "_Top_sect" + section;
		if(isVertical) {
			imgName+="_vert";
		}
		imgName += ".png";
		myImageNames.add(imgName);
		add(ImageAdd.getImage(imgName,getBounds().width,getBounds().height));
		validate();
		repaint();
	}
	
	public void RemoveShip() {
		myImageNames.remove(0);
		removeAll();
		validate();
		repaint();
	}
	
	public void resizeImage() {
		if(myImageNames.isEmpty()) {
			return;
		}
		removeAll();
		for(String i : myImageNames) {
			add(ImageAdd.getImage(i,getBounds().width,getBounds().height));
		}
		validate();
		repaint();
	}
	
}
