package windowness;

import javax.swing.*;
import java.awt.*;
//import java.util.ArrayList;
import java.lang.Integer;
import java.util.Dictionary;
import java.util.Hashtable;

public abstract class ScreenPanel extends JPanel{
	
	public abstract void setSizes();
	
	//ArrayList<Double> componentSizes = new ArrayList<Double>();
	/*Dictionary<Integer,double[]> myComponentSizes = new Hashtable<Integer,double[]>();
	
	Component addWithWindowPortion(Component arg0,double WindowWidthPortion,double WindowHeightPortion){
		//componentSizes.add(WindowPortion);
		int thisId = super.getComponentCount()+1;
		double[] thisPortions = {WindowWidthPortion,WindowHeightPortion};
		myComponentSizes.put(thisId,thisPortions);
		super.add(arg0);
		super.getComponent(thisId).setSize(new Dimension((int) (myComponentSizes.get(thisId)[0]*ShowWindow.theMainWindow.screenWid),(int) (myComponentSizes.get(thisId)[1]*ShowWindow.theMainWindow.screenHigh)));
		return arg0;
	}
	
	Component addWithWindowPortionAndLayout(Component comp, double WindowWidthPortion, double WindowHeightPortion, Object constraints) {
		int thisId = super.getComponentCount()+1;
		double[] thisPortions = {WindowWidthPortion,WindowHeightPortion};
		myComponentSizes.put(thisId, thisPortions);
		super.add(comp, constraints);
		return comp;
	}
	
	Component addAsHeightBasedSquareWithWindowPortionAndLayout(Component comp, double WindowHeightPortion, Object constraints) {
		int thisId = super.getComponentCount()+1;
		double[] thisPortions = {-1,WindowHeightPortion};
		myComponentSizes.put(thisId, thisPortions);
		super.add(comp, constraints);
		return comp;
	}
	
	public void resize() {
		for(int i = 0; i < super.getComponentCount(); i++) {
			if(myComponentSizes.get(i)!=null) {
				if(myComponentSizes.get(i)[0]==-1) {
					super.getComponent(i).setSize(new Dimension((int) (myComponentSizes.get(i)[1]*ShowWindow.theMainWindow.screenHigh),(int) (myComponentSizes.get(i)[1]*ShowWindow.theMainWindow.screenHigh)));
				}
				else {
					super.getComponent(i).setSize(new Dimension((int) (myComponentSizes.get(i)[0]*ShowWindow.theMainWindow.screenWid),(int) (myComponentSizes.get(i)[1]*ShowWindow.theMainWindow.screenHigh)));
				}
			}
		}
		validate();
		repaint();
	}*/
	
}
