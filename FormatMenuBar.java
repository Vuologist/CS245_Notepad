import javax.swing.*;
import java.awt.*;

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

        formatMenuItems();
    }

    public JMenu getFormatJM() {
        return formatJM;
    }

    private void formatMenuItems (){
        JMenuItem jmiWordWrap = new JMenuItem("Word Wrap", 'W');
        JMenuItem jmiFont = new JMenuItem("Font...", 'F');

        formatJM.add(jmiWordWrap);
        formatJM.add(jmiFont);

        jmiWordWrap.addActionListener(ae -> {
            wordWrap();

        });

        jmiFont.addActionListener(ae -> {
            fontChooser();
        });
    }

    private void wordWrap(){

        if(wordWrapToggle == false){
            System.out.println(wordWrapToggle);
            txtArea.getTextArea().setLineWrap(true);
            txtArea.getTextArea().setWrapStyleWord(true);
            wordWrapToggle = true;
        } else {
            System.out.println(wordWrapToggle);
            txtArea.getTextArea().setLineWrap(false);
            txtArea.getTextArea().setWrapStyleWord(false);
            wordWrapToggle = false;
        }
    }

    private void fontChooser(){
        jFontChooser = new JFontChooser();
        jFontChooser.showDialog(jfrm);
        Font font = jFontChooser.getFont();
        Color color = jFontChooser.getColor();

        txtArea.getTextArea().setFont(font);
        txtArea.getTextArea().setForeground(color);

        //slight error doesn't save changes
    }

}
