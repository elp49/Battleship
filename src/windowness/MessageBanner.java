package windowness;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;

public class MessageBanner extends JPanel {

    private JLabel myText = new JLabel("Test Text") {{
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.PLAIN, ScreenSizer.getScreenWidth() / 90));
    }};

    public MessageBanner() {
        setLayout(new FlowLayout());
        setBackground(Color.RED);
        setPreferredSize(ScreenSizer.getRectangleBasedOnScreenSize(1, 0.03));
        add(myText);
    }

    public void setText(String newText) {
        myText.setText(newText);
    }

    public String getCurMsg() {
        return myText.getText();
    }

}
