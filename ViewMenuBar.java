import javax.swing.*;

public class ViewMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private JMenu viewJM;

    public ViewMenuBar(JFrame jfrm, TextArea txtArea){
        this.jfrm = jfrm;
        this.txtArea = txtArea;
        viewJM = new JMenu("View");
        viewJM.setMnemonic('V');

        viewMenuItems();
    }

    public JMenu getViewJM() {
        return viewJM;
    }

    private void viewMenuItems () {
        JMenuItem jmiStatusBar = new JMenuItem("Status Bar", 'S');
        jmiStatusBar.setEnabled(false);
        viewJM.add(jmiStatusBar);
    }

}
