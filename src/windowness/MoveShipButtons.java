package windowness;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoveShipButtons extends JPanel {

    public JButton MoveUp = new JButton() {{
        add(new JLabel("^") {{
            setFont(ScreenSizer.SmallestReadableFont);
            setAlignmentX(JLabel.CENTER_ALIGNMENT);
            setAlignmentX(JLabel.CENTER_ALIGNMENT);
            setAlignmentY(JLabel.CENTER_ALIGNMENT);
        }});
    }};

    public JButton MoveDown = new JButton() {{
        add(new JLabel("v") {{
            setFont(ScreenSizer.SmallestReadableFont);
            setAlignmentX(JLabel.CENTER_ALIGNMENT);
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
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "rotate.png"));
    }};

    public MoveShipButtons() {
        setLayout(new BorderLayout());
        add(MoveUp, BorderLayout.NORTH);
        add(MoveDown, BorderLayout.SOUTH);
        add(MoveLeft, BorderLayout.WEST);
        add(MoveRight, BorderLayout.EAST);
        add(Rotate, BorderLayout.CENTER);
    }

    public void resizeButtons() {
        setPreferredSize(new Dimension((int) (super.getParent().getBounds().width * 0.2), (int) (super.getParent().getBounds().height)));
        MoveUp.setSize(new Dimension((int) (this.getBounds().width * 0.33), (int) (this.getBounds().height * 0.33)));
        MoveDown.setSize(new Dimension((int) (this.getBounds().width * 0.33), (int) (this.getBounds().height * 0.33)));
        MoveLeft.setSize(new Dimension((int) (this.getBounds().width * 0.33), (int) (this.getBounds().height * 0.33)));
        MoveRight.setSize(new Dimension((int) (this.getBounds().width * 0.33), (int) (this.getBounds().height * 0.33)));
        Rotate.setSize(new Dimension((int) (this.getBounds().width * 0.33), (int) (this.getBounds().height * 0.33)));
        validate();
        repaint();
        Rotate.removeAll();
        Rotate.add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "rotate.png", Rotate.getSize().height, Rotate.getSize().height));
    }

    public void setActive(boolean a) {
        MoveUp.setEnabled(a);
        MoveDown.setEnabled(a);
        MoveLeft.setEnabled(a);
        MoveRight.setEnabled(a);
        Rotate.setEnabled(a);
    }

}
