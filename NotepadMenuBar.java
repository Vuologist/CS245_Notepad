import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class NotepadMenuBar extends NotepadMenuBarFunctionality{

    protected JMenuBar jmb;
    protected JFrame jfrm;
    protected TextArea txtArea;

    public NotepadMenuBar(JFrame jfrm, TextArea textArea){
        this.jfrm = jfrm;
        txtArea = textArea;
        jmb = new JMenuBar();
        jmb.add(fileMenu());
        jmb.add(editMenu());
        jmb.add(formatMenu());
        jmb.add(viewMenu());
        jmb.add(helpMenu());
    }

    public JMenuBar getNotepadMenu(){
        return jmb;
    }

    private JMenu fileMenu (){
        JFileChooser jfc = new JFileChooser();

        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic('F');
        //first section
        JMenuItem jmiNew = new JMenuItem("New", 'N');
        jmiNew.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiOpen = new JMenuItem("Open...");
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSave = new JMenuItem("Save");
        jmiSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSaveAs = new JMenuItem("Save As...");
        //second section
        JMenuItem jmiPageSetup = new JMenuItem("Page Setup...", 'u');
        JMenuItem jmiPrint = new JMenuItem("Print...");
        jmiPrint.setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK));
        //third section
        JMenuItem jmiExit = new JMenuItem("Exit",'x');

        jmiNew.addActionListener(ae ->{
            newMenuOption();
        });

        jmiOpen.addActionListener(ae -> {
            openMenuOption();
        });

        jmiSave.addActionListener(ae -> {

        });

        jmiSaveAs.addActionListener(ae -> {
            saveAsMenuOption();
        });

        jmiExit.addActionListener(ae -> {
                exitMenuOption();
        });

        jfrm.addWindowListener(new java.awt.event.WindowAdapter(){
            public void windowClosing(WindowEvent winEvt) {
                exitMenuOption();
                System.exit(0);
            }
        });

        jmFile.add(jmiNew);
        jmFile.add(jmiOpen);
        jmFile.add(jmiSave);
        jmFile.add(jmiSaveAs);
        jmFile.addSeparator();
        jmFile.add(jmiPageSetup);
        jmFile.add(jmiPrint);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        return jmFile;
    }

    private JMenu editMenu (){
        JMenu jmEdit = new JMenu("Edit");
        jmEdit.setMnemonic('E');
        //section one
        JMenuItem jmiUndo = new JMenuItem("Undo");
        //jmiUndo.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK));
        //section two
        JMenuItem jmiCut = new JMenuItem("Cut");
        jmiCut.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_DOWN_MASK));
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
        JMenuItem jmiGoTo = new JMenuItem("Go To...");
        jmiGoTo.setAccelerator(KeyStroke.getKeyStroke('G', InputEvent.CTRL_DOWN_MASK));
        //section four
        JMenuItem jmiSelectAll = new JMenuItem("Select All");
        jmiSelectAll.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiTimeDate = new JMenuItem("Time/Date");
        jmiTimeDate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));

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

        return jmEdit;
    }

    private JMenu formatMenu (){
        JMenu jmFormat = new JMenu("Format");
        jmFormat.setMnemonic('o');

        JMenuItem jmiWordWrap = new JMenuItem("Word Wrap", 'W');
        JMenuItem jmiFont = new JMenuItem("Font...", 'F');

        jmFormat.add(jmiWordWrap);
        jmFormat.add(jmiFont);

        return jmFormat;
    }

    private JMenu viewMenu () {
        JMenu jmView = new JMenu("View");
        jmView.setMnemonic('V');

        JMenuItem jmiStatusBar = new JMenuItem("Status Bar", 'S');
        jmView.add(jmiStatusBar);

        return jmView;
    }

    private JMenu helpMenu(){
        JMenu jmHelp = new JMenu("Help");
        jmHelp.setMnemonic('H');

        JMenuItem jmiViewHelp = new JMenuItem("View Help",'H');
        JMenuItem jmiAboutJNotepad = new JMenuItem("About JNotepad");


        jmHelp.add(jmiViewHelp);
        jmHelp.addSeparator();
        jmHelp.add(jmiAboutJNotepad);

        return jmHelp;
    }

}
