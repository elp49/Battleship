package windowness;

import java.awt.*;

public class ScreenSizer {
	private static Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
	
	//Return the individual values
	public static int getScreenHeight() {
		return screenDim.height;
	}
	public static int getScreenWidth() {
		return screenDim.width;
	}
	
	//Return Dimensions
	public static Dimension getScreenDim() {
		return screenDim;
	}
	public static Dimension getPortionOfScreenDim(double portion) {
		return new Dimension((int) (screenDim.width*portion), (int) (screenDim.height*portion));
	}
	public static Dimension getSquareFromHeight() {
		return new Dimension(screenDim.height,screenDim.height);
	}
	public static Dimension getSquareFromWidth() {
		return new Dimension(screenDim.width,screenDim.width);
	}
	public static Dimension getPortionOfSquareFromHeight(double portion) {
		return new Dimension((int) (screenDim.height*portion), (int) (screenDim.height*portion));
	}
	public static Dimension getPortionOfSquareFromWidth(double portion) {
		return new Dimension((int) (screenDim.width*portion), (int) (screenDim.width*portion));
	}
	public static Dimension getRectangleBasedOnScreenSize(double wPortion, double hPortion) {
		return new Dimension((int) (screenDim.width*wPortion), (int) (screenDim.height*hPortion));
	}
	
	//This font will ensure that the text can be comfortably read on all monitors
		//No font should be smaller than this
		//It is necessary for us, as Nathan has a 4k monitor on his computer, thus everything appears far
		//smaller otherwise.
	public static Font SmallestReadableFont = new Font("Arial",Font.PLAIN,(int)(screenDim.width * 0.8)/90);
}
