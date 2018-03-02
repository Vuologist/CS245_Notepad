import javax.swing.*;

public class HelpMenuBar {

    private JMenu jmHelp;
    private JMenuItem jmiViewHelp;
    private JMenuItem jmiAboutJNotepad;

    public HelpMenuBar(){
        jmHelp = new JMenu("Help");
        jmHelp.setMnemonic('H');
        jMenuItemCreation();
        addToJMenu();
    }

    public JMenu getJmHelp(){return jmHelp;}

    private void jMenuItemCreation (){
        jmiViewHelp = new JMenuItem("View Help",'H');
        jmiAboutJNotepad = new JMenuItem("About JNotepad");
    }

    private void addToJMenu(){
        jmHelp.add(jmiViewHelp);
        jmHelp.addSeparator();
        jmHelp.add(jmiAboutJNotepad);
    }

}
