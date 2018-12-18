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


public class CardBuilder {

    private JTextArea questionArea;
    private JTextArea answerArea;
    private JFrame frame;
    //

    
    public void start() {

        frame = new JFrame("Card Creator");
        JPanel panel = new JPanel();
        Font textFont = new Font("Cambria", Font.BOLD, 12);

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

        Font panelFont = new Font("sanserif", Font.BOLD, 12);

        panel.add(quesLabel);
        panel.add(questionScrollPane);
        panel.add(ansLabel);
        panel.add(answerScrollPane);
        panel.add(nextCardButton);
        panel.setFont(new Font("sanserif", Font.PLAIN, 12));

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newFileMenuItem = new JMenuItem("New");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");

        saveFileMenuItem.addActionListener(new SaveMenuListener());
        newFileMenuItem.addActionListener(new NewFileMenuListener());

        fileMenu.add(newFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        menuBar.add(fileMenu);

        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(700, 600);
        frame.setVisible(true);

    }

    private void saveFile(File file) {

        try {

        } catch (Exception ex) {
            
        }
    }

    private void clearCard() {
        questionArea.setText("");
        answerArea.setText("");

        questionArea.requestFocus();
    }

    public class SaveMenuListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {       

            JFileChooser saveFileChooser = new JFileChooser();
            saveFileChooser.showSaveDialog(frame);
            saveFile(saveFileChooser.getSelectedFile());
        }
    }

    public class NewFileMenuListener implements ActionListener {
         
         public void actionPerformed(ActionEvent ev) {

         }
    }

}