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
import java.io.FileReader;
import java.io.BufferedReader;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CardPlayer {
    
    private JFrame frame;
    private JPanel panel;
    private JTextArea displayArea;
    private JTextArea answerArea;
    private JButton cardButton;
    private boolean answerNeeded;
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



    private void loadCardFile(File file) {

        String line;

        cardList = new ArrayList<DrawCard>();

        try {
                BufferedReader bufR = new BufferedReader(
                new FileReader(file));

                while((line = bufR.readLine()) != null) {

                    createCard(line);
                }

                bufR.close();
            
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        showCards();
    }

    private void createCard(String cardLine) {

        String [] lines = cardLine.split("/");
        DrawCard card = new DrawCard(lines[0], lines[1]);
        cardList.add(card);
        System.out.println("Card Done");
    }

    private void showCards() {

        currentCard = cardList.get(cardIndex);
        cardIndex++;
        displayArea.setText(currentCard.getQuestion());
        cardButton.setText("See Answer");
        answerNeeded = true;
    }
    


    class LoadCardMenuListener implements ActionListener{

        public void actionPerformed(ActionEvent ev) {

            JFileChooser fileOpener = new JFileChooser();
            fileOpener.showOpenDialog(frame);
            loadCardFile(fileOpener.getSelectedFile());
        }
    }



    class CardButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent ev) {
            
            if (answerNeeded) {

                displayArea.setText(currentCard.getAnswer());
                cardButton.setText("Next Card");
                answerNeeded = false;
            }

            else {

                if (cardIndex < cardList.size()) {
                    showCards();
                
                } else {

                    displayArea.setText("Last Card\n\tGo Get Some Coffee");
                    cardButton.setEnabled(false);
                }
            }
        }
    }
}