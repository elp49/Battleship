package windowness;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class AudioWindow extends JFrame {
	
	private JSlider myVolume = new JSlider(0,10);
	
	private JPanel myVolumePanel = new JPanel() {{
		setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
		add(new JLabel("Volume:") {{
			setFont(ScreenSizer.SmallestReadableFont);
		}});
		add(myVolume);
	}};
	
	private JCheckBox myIncludeMusic = new JCheckBox("Music") {{
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	private JCheckBox myIncludeSFX = new JCheckBox("Sound Effects") {{
		setFont(ScreenSizer.SmallestReadableFont);
	}};
	
	private JButton ConfirmButton = new JButton("Confirm") {{
		setFont(ScreenSizer.SmallestReadableFont);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GameplayFunctions.closeAudioSettings();
			}
		});
	}};
	
	private JButton CancelButton = new JButton("Cancel") {{
		setFont(ScreenSizer.SmallestReadableFont);
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				GameplayFunctions.closeAudioSettings();
			}
		});
	}};
	
	private JPanel myCheckBoxes = new JPanel() {{
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		add(Box.createHorizontalGlue());
		add(myIncludeMusic);
		add(Box.createHorizontalGlue());
		add(myIncludeSFX);
		add(Box.createHorizontalGlue());
	}};
	
	private JPanel myButtons = new JPanel() {{
		setLayout(new BoxLayout(this,BoxLayout.LINE_AXIS));
		add(Box.createHorizontalGlue());
		add(ConfirmButton);
		add(CancelButton);
	}};
	
	public AudioWindow(){
		Container contentPane = getContentPane();
		setLayout(new BoxLayout(contentPane,BoxLayout.PAGE_AXIS));
		setBounds(0,0,(int) (ScreenSizer.getScreenWidth()*0.5),(int) (ScreenSizer.getScreenHeight()*0.5));
		contentPane.add(myVolumePanel);
		myVolumePanel.setPreferredSize(new Dimension(contentPane.getBounds().width, contentPane.getBounds().height/3));
		contentPane.add(myCheckBoxes);
		myCheckBoxes.setPreferredSize(new Dimension(contentPane.getBounds().width, contentPane.getBounds().height/3));
		contentPane.add(myButtons);
		setVisible(true);
	}
	
}
