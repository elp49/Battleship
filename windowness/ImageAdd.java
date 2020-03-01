package windowness;

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
	
}
