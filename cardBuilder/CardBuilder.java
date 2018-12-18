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

import java.util.ArrayList;

import java.awt.Font;
import java.awt.BorderLayout;


public class CardBuilder {

    private JTextArea questionArea;
    private JTextArea answerArea;
    private JFrame frame;
    //

    
    public void start() {

        frame = new JFrame("Card Creator");
        JPanel panel = new JPanel();
        Font textFont = new Font("Calibri", Font.BOLD, 13);

        questionArea = new JTextArea(6, 20);
        questionArea.setLineWrap(true);
        questionArea.setFont(textFont);
        questionArea.setWrapStyleWord(true);

        JScrollPane questionScrollPane = new JScrollPane(questionArea);
        questionScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        answerArea = new JTextArea(6, 20);
        answerArea.setLineWrap(true);
        answerArea.setWrapStyleWord(true);
        answerArea.setFont(textFont);

        JScrollPane answerScrollPane = new JScrollPane(answerArea);
        answerScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);


        JButton nextCardButton = new JButton("Next Card");

        // cardList = new ArrayList<>

        JLabel quesLabel = new JLabel("Question");
        JLabel ansLabel = new JLabel("Answer");

        panel.add(quesLabel);
        panel.add(questionScrollPane);
        panel.add(ansLabel);
        panel.add(answerScrollPane);
        panel.add(nextCardButton);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newFileMenuItem = new JMenuItem("New");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");

        fileMenu.add(newFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}