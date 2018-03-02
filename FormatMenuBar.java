import javax.swing.*;

public class FormatMenuBar {

    private JMenu jmFormat;
    private JMenuItem jmiWordWrap;
    private JMenuItem jmiFont;

    public FormatMenuBar (){
        JMenu jmFormat = new JMenu("Format");
        jmFormat.setMnemonic('o');

        createJMenuItem();
        addToJMenu();
    }

    public JMenu getJmFormat() {
        return jmFormat;
    }

    private void createJMenuItem(){
        jmiWordWrap = new JMenuItem("Word Wrap", 'W');
        jmiFont = new JMenuItem("Font...", 'F');
    }

    private void addToJMenu(){
        jmFormat.add(jmiWordWrap);
        jmFormat.add(jmiFont);
    }

}
