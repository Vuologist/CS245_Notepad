import javax.swing.*;

public class FormatMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private JMenu formatJM;


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

    }

}
