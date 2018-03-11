import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private JMenu editJM;
    private JPopupMenu rightClickMenu;


    public EditMenuBar(JFrame jfrm, TextArea txtArea){
        this.jfrm = jfrm;
        this.txtArea = txtArea;
        rightClickMenu = new JPopupMenu();
        editJM = new JMenu("Edit");
        editJM.setMnemonic('E');

        editMenuItems();
        generateJPopupMenu();
    }

    public JMenu getEditJM() {
        return editJM;
    }

    private void editMenuItems (){
        //section one
        JMenuItem jmiUndo = new JMenuItem("Undo");
        jmiUndo.setEnabled(false);
        //jmiUndo.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK));
        //section two
        JMenuItem jmiCut = new JMenuItem("Cut");
        jmiCut.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiCopy = new JMenuItem("Copy");
        jmiCopy.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiPaste = new JMenuItem("Paste");
        jmiPaste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiDelete = new JMenuItem("Delete");
        jmiDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //change so that it is Del instead of Delete
        //section three
        JMenuItem jmiFind = new JMenuItem("Find...");
        jmiFind.setAccelerator(KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiFindNext = new JMenuItem("Find Next");
        JMenuItem jmiReplace = new JMenuItem("Replace...");
        jmiReplace.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_DOWN_MASK));
        jmiReplace.setEnabled(false);
        JMenuItem jmiGoTo = new JMenuItem("Go To...");
        jmiGoTo.setAccelerator(KeyStroke.getKeyStroke('G', InputEvent.CTRL_DOWN_MASK));
        jmiGoTo.setEnabled(false);
        //section four
        JMenuItem jmiSelectAll = new JMenuItem("Select All");
        jmiSelectAll.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiTimeDate = new JMenuItem("Time/Date");
        jmiTimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

        editJM.add(jmiUndo);
        editJM.addSeparator();
        editJM.add(jmiCut);
        editJM.add(jmiCopy);
        editJM.add(jmiPaste);
        editJM.add(jmiDelete);
        editJM.addSeparator();
        editJM.add(jmiFind);
        editJM.add(jmiFindNext);
        editJM.add(jmiReplace);
        editJM.add(jmiGoTo);
        editJM.addSeparator();
        editJM.add(jmiSelectAll);
        editJM.add(jmiTimeDate);

        jmiCopy.addActionListener(ae -> {
            txtArea.getTextArea().copy();
        });

        jmiCut.addActionListener(ae -> {
            txtArea.getTextArea().cut();
        });

        jmiPaste.addActionListener(ae -> {
            txtArea.getTextArea().paste();
        });

        jmiDelete.addActionListener(ae -> {
            txtArea.getTextArea().replaceSelection("");
        });

        jmiSelectAll.addActionListener(ae -> {
            txtArea.getTextArea().selectAll();
        });

        txtArea.getTextArea().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                rightClickMenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
        
    }

    private void generateJPopupMenu(){
        JMenuItem jmiRightCopy = new JMenuItem("Copy");
        JMenuItem jmiRightCut = new JMenuItem("Cut");
        JMenuItem jmiRightPaste = new JMenuItem("Paste");

        rightClickMenu.add(jmiRightCopy);
        rightClickMenu.add(jmiRightCut);
        rightClickMenu.add(jmiRightPaste);

        jmiRightCopy.addActionListener(ae -> {
            txtArea.getTextArea().copy();
        });

        jmiRightCut.addActionListener(ae -> {
            txtArea.getTextArea().cut();
        });

        jmiRightPaste.addActionListener(ae -> {
            txtArea.getTextArea().paste();
        });
    }

}
