package windowness;

import javax.swing.*;

public class HealthBarData extends JPanel {

    public JPanel myPicHolder;
    JLabel myShipName;
    HealthUnitVisual[] myHealthView;
    JPanel myHealthBar = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }};

    public HealthBarData(String pic, String name, int healthAmt) {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        myPicHolder = ImageAdd.getScaledImage(pic, 0.75);

        myShipName = new JLabel(name.toUpperCase()) {{
            setFont(ScreenSizer.SmallestReadableFont);
        }};

        myHealthView = new HealthUnitVisual[healthAmt];
        for (int i = 0; i < healthAmt; i++) {
            myHealthView[i] = new HealthUnitVisual();
            myHealthBar.add(myHealthView[i]);
        }

        add(myPicHolder);
        add(myShipName);
        add(myHealthBar);
    }

    public void visualizeDamage(int pos) {
        myHealthView[pos].takeDamage();
        myHealthBar.validate();
        myHealthBar.repaint();
    }

    public void visualizeSink() {
        for (int i = 0; i < myHealthView.length; i++) {
            myHealthView[i].hasSank();
        }
        myHealthBar.validate();
        myHealthBar.repaint();
    }
}
