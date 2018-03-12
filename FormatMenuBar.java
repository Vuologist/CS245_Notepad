import javax.swing.*;
import java.awt.*;

//
// Name: Vu, Anthony
// Project: 3
// Due: 3/12/2018
// Course: CS-245-01-w18
//
// Description:
// The requirements of this project include recreating Windows
// Notepad and adding in a color chooser for the foreground
// text.
//

public class FormatMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private JMenu formatJM;
    private JFontChooser jFontChooser;
    private boolean wordWrapToggle = false;

    public FormatMenuBar(JFrame jfrm, TextArea txtArea){
        this.jfrm = jfrm;
        this.txtArea = txtArea;
        formatJM = new JMenu("Format");
        formatJM.setMnemonic('o');

        jFontChooser = new JFontChooser();
        formatMenuItems();
    }

    public JMenu getFormatJM() {
        return formatJM;
    }

    private void formatMenuItems (){
        JCheckBox jmiWordWrap = new JCheckBox("Word Wrap");
        jmiWordWrap.setMnemonic('W');
        JMenuItem jmiFont = new JMenuItem("Font...", 'F');

        formatJM.add(jmiWordWrap);
        formatJM.add(jmiFont);

        jmiWordWrap.addItemListener(ae -> {
            wordWrap();

        });

        jmiFont.addActionListener(ae -> {
            fontChooser();
        });
    }

    private void wordWrap(){

        if(wordWrapToggle == false){
            txtArea.getTextArea().setLineWrap(true);
            txtArea.getTextArea().setWrapStyleWord(true);
            wordWrapToggle = true;
        } else {
            txtArea.getTextArea().setLineWrap(false);
            txtArea.getTextArea().setWrapStyleWord(false);
            wordWrapToggle = false;
        }
    }

    private void fontChooser(){
        jFontChooser.showDialog(jfrm);
        Font font = jFontChooser.getFont();
        Color color = jFontChooser.getColor();

        txtArea.getTextArea().setFont(font);
        txtArea.getTextArea().setForeground(color);
    }

}
