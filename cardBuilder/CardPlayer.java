import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JFileChooser;

import java.util.ArrayList;

import java.awt.Font;
import java.awt.BorderLayout;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CardPlayer {
    
    private JFrame frame;
    private JPanel panel;
    private JTextArea displayArea;
    private JTextArea answerArea;
    private JButton cardButton;
    private boolean isAnswer;
    private int cardIndex;
    private DrawCard currentCard;
    private ArrayList<DrawCard> cardList;

    public void createDisplay() {

        frame = new JFrame("Card PLayer");
        JPanel panel = new JPanel();

        Font cardFont = new Font("cambria", Font.PLAIN, 18);

        displayArea = new JTextArea(10, 20);
        displayArea.setFont(cardFont);
        displayArea.setLineWrap(true);
        displayArea.setEditable(false);

        JScrollPane displayScrollPane = new JScrollPane(
            displayArea);
        displayScrollPane.setVerticalScrollBarPolicy(
            ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        displayScrollPane.setHorizontalScrollBarPolicy(
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        cardButton = new JButton("See Question");
        cardButton.addActionListener(new CardButtonListener());

        panel.add(displayScrollPane);
        panel.add(cardButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadCardMenuItem = new JMenuItem("Load Cards");
        loadCardMenuItem.addActionListener(new LoadCardMenuListener());
        fileMenu.add(loadCardMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(650, 510);
        frame.setVisible(true);
    }

    
    class LoadCardMenuListener implements ActionListener{

        public void actionPerformed(ActionEvent ev) {

        }
    }

    class CardButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent ev) {
            
        }
    }
}