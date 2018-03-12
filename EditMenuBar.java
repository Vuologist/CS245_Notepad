import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class EditMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private JMenu editJM;
    private JPopupMenu rightClickMenu;
    //true = up, false = down
    private boolean upOrDown = false;
    private boolean caseSens = false;
    private JButton jbtnFindNext;

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

        jmiFind.addActionListener(ae -> {
            findFunction();
        });

        jmiFindNext.addActionListener(ae -> {
            jbtnFindNext.doClick();
        });

        jmiSelectAll.addActionListener(ae -> {
            txtArea.getTextArea().selectAll();
        });

        jmiTimeDate.addActionListener(ae -> {
            addTimeAndDate();
        });

        txtArea.getTextArea().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.isPopupTrigger())
                    rightClickMenu.show(e.getComponent(),e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if(e.isPopupTrigger())
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

    private void addTimeAndDate(){
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("hh:mm a M/dd/yyyy");
        txtArea.getTextArea().insert(ft.format(dNow),txtArea.getTextArea().getCaretPosition());
    }

    private void findFunction(){
        JDialog jdlg = new JDialog(jfrm,"Find", false);
        jdlg.setSize(300, 135);
        jdlg.setLayout(new BorderLayout());

        JLabel jlbFindWhat = new JLabel("Find what: ");
        JTextField jtfFind = new JTextField(50);
        JCheckBox matchCase = new JCheckBox("Match case");

        JPanel buttonGroup = new JPanel();
        buttonGroup.setLayout(new BorderLayout());
        jbtnFindNext = new JButton("Find Next");
        JButton jbtnCancel = new JButton("Cancel");
        buttonGroup.add(jbtnFindNext, BorderLayout.NORTH);
        buttonGroup.add(jbtnCancel, BorderLayout.SOUTH);

        JPanel jUpOrDown = new JPanel();
        jUpOrDown.setLayout(new BorderLayout());
        JRadioButton jrbUp = new JRadioButton("Up");
        JRadioButton jrbDown = new JRadioButton("Down", true);
        ButtonGroup group = new ButtonGroup();
        group.add(jrbUp);
        group.add(jrbDown);
        jUpOrDown.add(jrbUp, BorderLayout.WEST);
        jUpOrDown.add(jrbDown, BorderLayout.EAST);
        TitledBorder title = BorderFactory.createTitledBorder("Direction");
        jUpOrDown.setBorder(title);

        JPanel caseAndDirection = new JPanel();
        caseAndDirection.setLayout(new BorderLayout());
        caseAndDirection.add(matchCase, BorderLayout.WEST);
        caseAndDirection.add(jUpOrDown, BorderLayout.EAST);

        //main dialog
        jdlg.add(jlbFindWhat, BorderLayout.WEST);
        jdlg.add(jtfFind, BorderLayout.CENTER);
        jdlg.add(buttonGroup, BorderLayout.EAST);
        jdlg.add(caseAndDirection, BorderLayout.SOUTH);

        jbtnFindNext.addActionListener(ae -> {
            findNext(jtfFind.getText());
        });

        jbtnCancel.addActionListener(ae -> {
            jdlg.dispose();
        });

        matchCase.addItemListener(il -> {
            if(caseSens == false)
                caseSens = true;
            else
                caseSens = false;
            System.out.print(caseSens);
        });

        jrbUp.addItemListener(il -> {
            upOrDown = true;
        });

        jrbDown.addItemListener(il -> {
            upOrDown = false;
        });

        jdlg.setLocationRelativeTo(jfrm);
        jdlg.setVisible(true);
    }

    private void findNext(String keyword){
        String holder = txtArea.getTextArea().getText();

        if (!caseSens) {
            keyword = keyword.toLowerCase();
            holder = holder.toLowerCase();
        }
        int index;
        int last = keyword.length();
        if (upOrDown) {
            if (txtArea.getTextArea().getSelectedText()!=null && txtArea.getTextArea().getSelectedText().equalsIgnoreCase(keyword)) {
                index = holder.substring(0, txtArea.getTextArea().getCaretPosition()-keyword.length()).lastIndexOf(keyword);}
            else {
                index = holder.substring(0, txtArea.getTextArea().getCaretPosition()).lastIndexOf(keyword);
            }
            if (index!=-1) {
                int indexhold = index;
                int lasthold = index+last;
                txtArea.getTextArea().select(indexhold, lasthold);
            }else {
                JOptionPane.showMessageDialog(jfrm, "Can't find any more");
            }

        } else {
            index = holder.substring(txtArea.getTextArea().getCaretPosition(),holder.length()).indexOf(keyword);
            if (index!=-1) {
                txtArea.getTextArea().select(txtArea.getTextArea().getCaretPosition()+index, txtArea.getTextArea().getCaretPosition()+index+last);
            } else {
                JOptionPane.showMessageDialog(jfrm, "Can't find any more");
            }
        }
    }
}
