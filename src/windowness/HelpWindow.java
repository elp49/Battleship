package windowness;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class HelpWindow extends JFrame {

    private JPanel myPane = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }};

    private JScrollPane myScrollPane = new JScrollPane() {{
        setViewportView(myPane);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }};

    private JLabel Title = new JLabel("BATTLESHIP") {{
        setFont(new Font("Arial", Font.PLAIN, ScreenSizer.SmallestReadableFont.getSize() * 5));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }};

    private JLabel SetupSection = new JLabel("Setting up") {{
        setFont(new Font("Arial", Font.PLAIN, ScreenSizer.SmallestReadableFont.getSize() * 2));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }};

    private JPanel Paragraph1 = new JPanel() {{
        add(new JLabel("Battleship begins by setting your five ships on the board. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("In this program, this process is as follows: ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("1. Click on the ship's image in the Health Bar Panel ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("2. The ship will appear on the board, now you can move it with the Buttons beneath your grid. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("3. Once you've decided where to place the ship, click on a new one in the Health Bar Panel to begin placing the next one. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("NOTE: You cannot move a ship you've already placed. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
    }};

    private JLabel MainGameSection = new JLabel("Gameplay") {{
        setFont(new Font("Arial", Font.PLAIN, ScreenSizer.SmallestReadableFont.getSize() * 2));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }};

    private JPanel Paragraph2 = new JPanel() {{
        add(new JLabel("Once both players are setup, the game begins. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("Players take turns firing shots by guessing squares on the grid. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("A square is denoted by a letter and a number, where the letter refers to the column and the number refers to the row. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("In this program, simply click on a square to guess it. ") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("If any part of any ship, it is couned as a hit, and marked with a red circle.") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("Otherwise, it is counted as a miss, and marked with a white circle.") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("If every part of a ship is hit, then the ship is counted as sunk.") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("Once a player has guessed, their turn is over and the next player's turn begins.") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(new JLabel("The game is won when you sink all five of your opponent's ships.") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
    }};

    private JLabel ShipSection = new JLabel("The Ships") {{
        setFont(new Font("Arial", Font.PLAIN, ScreenSizer.SmallestReadableFont.getSize() * 2));
        setAlignmentX(Component.CENTER_ALIGNMENT);
    }};

    private JPanel myCarrierRow = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createHorizontalGlue());
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Carrier_Top.png"));
        add(Box.createHorizontalGlue());
        add(new JLabel("CARRIER") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
        add(new JLabel("5 Hits") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
    }};
    private JPanel myBattleshipRow = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createHorizontalGlue());
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Battleship_Top.png"));
        add(Box.createHorizontalGlue());
        add(new JLabel("BATTLESHIP") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
        add(new JLabel("4 Hits") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
    }};
    private JPanel myDestroyerRow = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createHorizontalGlue());
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Destroyer_Top.png"));
        add(Box.createHorizontalGlue());
        add(new JLabel("DESTROYER") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
        add(new JLabel("3 Hits") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
    }};
    private JPanel mySubmarineRow = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createHorizontalGlue());
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Submarine_Top.png"));
        add(Box.createHorizontalGlue());
        add(new JLabel("SUBMARINE") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
        add(new JLabel("3 Hits") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
    }};
    private JPanel myPBRow = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        setAlignmentX(Component.CENTER_ALIGNMENT);
        add(Box.createHorizontalGlue());
        add(ImageAdd.getImage("Images" + System.getProperty("file.separator") + "Patrol Boat_Top.png"));
        add(Box.createHorizontalGlue());
        add(new JLabel("PATROL BOAT") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
        add(new JLabel("2 Hits") {{
            setFont(ScreenSizer.SmallestReadableFont);
        }});
        add(Box.createHorizontalGlue());
    }};

    private JPanel myShipPics = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(myCarrierRow);
        add(myBattleshipRow);
        add(myDestroyerRow);
        add(mySubmarineRow);
        add(myPBRow);
    }};

    private JButton CloseButton = new JButton("Close") {{
        setFont(ScreenSizer.SmallestReadableFont);
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                GameplayFunctions.closeHelpWindow();
            }
        });
    }};

    private JPanel ClosePanel = new JPanel() {{
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        add(Box.createHorizontalGlue());
        add(CloseButton);
        add(Box.createRigidArea(new Dimension(8, 1)));
    }};

    public HelpWindow() {
        setTitle("How to play");
        Container contentPane = getContentPane();
        setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        setBounds(0, 0, (int) (ScreenSizer.getScreenWidth() * 0.5), (int) (ScreenSizer.getScreenHeight() * 0.8));
        myPane.add(Title);
        myPane.add(Box.createRigidArea(new Dimension(1, 16)));
        myPane.add(SetupSection);
        myPane.add(Box.createRigidArea(new Dimension(1, 8)));
        myPane.add(Paragraph1);
        myPane.add(Box.createRigidArea(new Dimension(1, 16)));
        myPane.add(MainGameSection);
        myPane.add(Box.createRigidArea(new Dimension(1, 8)));
        myPane.add(Paragraph2);
        myPane.add(Box.createRigidArea(new Dimension(1, 16)));
        myPane.add(ShipSection);
        myPane.add(Box.createRigidArea(new Dimension(1, 8)));
        myPane.add(myShipPics);
        contentPane.add(myScrollPane);
        contentPane.add(ClosePanel);
        contentPane.add(Box.createRigidArea(new Dimension(1, 8)));
        myPane.setPreferredSize(new Dimension(super.getBounds().width, (int) (super.getBounds().height * 1.5)));
        myShipPics.setPreferredSize(new Dimension(super.getBounds().width, ScreenSizer.SmallestReadableFont.getSize() * 3));
        setVisible(true);
    }
}
