package windowness;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ImageAdd {
	
	public static JPanel getImage(String pic) {
		JPanel myPicHolder = new JPanel();
		try {
			BufferedImage myPic = ImageIO.read(new File(pic));
			myPicHolder.add(new JLabel(new ImageIcon(myPic)));
		}
		catch(IOException e) {
			System.out.println("Attempted to make image from nonexistent file \"" + pic + "\"! Placeholder loaded instead.");
			myPicHolder = new PlaceHolderGraphic();
		}
		return myPicHolder;
	}
	
	/*public static JPanel getImage(String pic, int w, int h) {
		JPanel myPicHolder = new JPanel();
		try {
			BufferedImage myPic = ImageIO.read(new File(pic));
			Image resized = myPic.getScaledInstance(w, h, Image.SCALE_SMOOTH);
			myPicHolder.add(new JLabel(new ImageIcon(resized)));
		}
		catch(IOException e) {
			System.out.println("Attempted to make image from nonexistent file \"" + pic + "\"! Placeholder loaded instead.");
			myPicHolder = new PlaceHolderGraphic();
		}
		return myPicHolder;
	}*/
	
	/*public static JPanel getImage(String pic, int w, int h) {
		JPanel myPicHolder = new JPanel();
		Graphics2D g2;
		try {
			BufferedImage myPic = ImageIO.read(new File(pic));
			g2 = myPic.createGraphics();
			
			g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			g2.drawImage(myPic, 0, 0, w, h, null);
			
			myPicHolder.add(new JLabel(new ImageIcon(myPic)));
			
			g2.dispose();
		}
		catch(IOException e) {
			System.out.println("Attempted to make image from nonexistent file \"" + pic + "\"! Placeholder loaded instead.");
			myPicHolder = new PlaceHolderGraphic();
		}
		return myPicHolder;
	}*/
	
	/*private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}*/
	
}
