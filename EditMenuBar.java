import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class EditMenuBar {

    private JMenu jmEdit;
    //section 1
    private JMenuItem jmiUndo;
    private JMenuItem jmiCut;
    private JMenuItem jmiCopy;
    private JMenuItem jmiPaste;
    private JMenuItem jmiDelete;
    private JMenuItem jmiFind;
    private JMenuItem jmiFindNext;
    private JMenuItem jmiReplace;
    private JMenuItem jmiGoTo;


    public EditMenuBar(){
        jmEdit = new JMenu("Edit");
        jmEdit.setMnemonic('E');

        createJMenuItemSection1();
        createJMenuItemSection2();
        createJMenuItemSection4();
        addToJMenu();
    }

    public JMenu getJmEdit(){
        return jmEdit;
    }

    private void createJMenuItemSection1(){
        jmiUndo = new JMenuItem("Undo");
        //jmiUndo.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK));
    }

    private void createJMenuItemSection2(){
        jmiCut = new JMenuItem("Cut");
        jmiCut.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
        jmiCopy = new JMenuItem("Copy");
        jmiCopy.setAccelerator(KeyStroke.getKeyStroke('C',InputEvent.CTRL_DOWN_MASK));
        jmiPaste = new JMenuItem("Paste");
        jmiPaste.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK));
        jmiDelete = new JMenuItem("Delete");
        jmiDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0)); //change so that it is Del instead of Delete
    }

    private void createJMenuItemSection3(){
        jmiFind = new JMenuItem("Find...");
        jmiFind.setAccelerator(KeyStroke.getKeyStroke('F', InputEvent.CTRL_DOWN_MASK));
        jmiFindNext = new JMenuItem("Find Next");
        jmiReplace = new JMenuItem("Replace...");
        jmiReplace.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_DOWN_MASK));
        jmiGoTo = new JMenuItem("Go To...");
        jmiGoTo.setAccelerator(KeyStroke.getKeyStroke('G', InputEvent.CTRL_DOWN_MASK));
    }

    private void createJMenuItemSection4(){
        JMenuItem jmiSelectAll = new JMenuItem("Select All");
        jmiSelectAll.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiTimeDate = new JMenuItem("Time/Date");
        jmiTimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
    }

    private void addToJMenu(){
        jmEdit.add(jmiUndo);
        jmEdit.addSeparator();
        jmEdit.add(jmiCut);
        jmEdit.add(jmiCopy);
        jmEdit.add(jmiPaste);
        jmEdit.add(jmiDelete);
        jmEdit.addSeparator();
        jmEdit.add(jmiFind);
        jmEdit.add(jmiFindNext);
        jmEdit.add(jmiReplace);
        jmEdit.add(jmiGoTo);
        jmEdit.addSeparator();
        jmEdit.add(jmiSelectAll);
        jmEdit.add(jmiTimeDate);
    }
}
