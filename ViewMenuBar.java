import javax.swing.*;

public class ViewMenuBar {

    private JMenu jmView;
    private JMenuItem jmiStatusBar;

    public ViewMenuBar () {
        jmView = new JMenu("View");
        jmView.setMnemonic('V');

        createJMenuItem();
        addToJMenu();
    }

    public JMenu getJmView() {
        return jmView;
    }

    private void createJMenuItem(){
        jmiStatusBar = new JMenuItem("Status Bar", 'S');
    }

    private void addToJMenu(){
        jmView.add(jmiStatusBar);
    }
}
