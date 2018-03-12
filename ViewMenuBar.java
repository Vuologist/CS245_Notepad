import javax.swing.*;

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
