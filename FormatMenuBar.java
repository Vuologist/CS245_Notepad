import javax.swing.*;

public class FormatMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private JMenu formatJM;
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


}
