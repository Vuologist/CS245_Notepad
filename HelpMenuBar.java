import javax.swing.*;

public class HelpMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private JMenu helpJM;

    public HelpMenuBar(JFrame jfrm, TextArea txtArea){
        this.jfrm = jfrm;
        this.txtArea = txtArea;
        helpJM = new JMenu("Help");
        helpJM.setMnemonic('H');

        helpMenuItems();
    }

    public JMenu getHelpJM() {
        return helpJM;
    }

    private void helpMenuItems(){

        JMenuItem jmiViewHelp = new JMenuItem("View Help",'H');
        JMenuItem jmiAboutJNotepad = new JMenuItem("About JNotepad");

        helpJM.add(jmiViewHelp);
        helpJM.addSeparator();
        helpJM.add(jmiAboutJNotepad);

        jmiAboutJNotepad.addActionListener(ae -> {
            aboutJNotepad();
        });
    }

    private void aboutJNotepad(){
        JOptionPane.showMessageDialog(jfrm, "(c) Anthony Vu");
    }

}
