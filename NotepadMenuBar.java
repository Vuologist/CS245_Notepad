import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.security.Key;

public class NotepadMenuBar {

    private JMenuBar jmb;
    private JFrame jfrm;
    private JFileChooser jfc;

    public NotepadMenuBar(JFrame jfrm){
        this.jfrm = jfrm;
        jmb = new JMenuBar();
        jmb.add(fileMenu());


    }

    public JMenuBar getNotepadMenu(){
        return jmb;
    }

    private JMenu fileMenu (){
        JFileChooser jfc = new JFileChooser();

        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic('F');
        //first section
        JMenuItem jmiNew = new JMenuItem("New");
        jmiNew.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiOpen = new JMenuItem("Open...");
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSave = new JMenuItem("Save");
        jmiSave.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSaveAs = new JMenuItem("Save As...");
        //second section
        JMenuItem jmiPageSetup = new JMenuItem("Page Setup...");
        JMenuItem jmiPrint = new JMenuItem("Print...");
        jmiPrint.setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK));
        //third section
        JMenuItem jmiExit = new JMenuItem("Exit");

        jmiNew.addActionListener(ae ->{
            //change changes to ____ to file name
            JOptionPane.showConfirmDialog(jfrm,"Do you want to save changes to Untitled?",
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
        });

        jmiOpen.addActionListener(ae -> {
            int result = jfc.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                System.out.println("Selected file is: " + jfc.getSelectedFile().getAbsolutePath());
            } else
                System.out.println("nothing selected");

        });

        jmiSave.addActionListener(ae -> {

        });

        jmiSaveAs.addActionListener(ae -> {

        });

        jmiPageSetup.addActionListener(ae -> {

        });

        jmiPrint.addActionListener(ae -> {

        });

        jmiExit.addActionListener(ae -> {
                System.exit(10);
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
        jmiUndo.setAccelerator(KeyStroke.getKeyStroke('Z', InputEvent.CTRL_DOWN_MASK));
        //section two
        JMenuItem jmiCut = new JMenuItem("Cut");
        jmiCut.setAccelerator(KeyStroke.getKeyStroke('X',InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiCopy = new JMenuItem("Copy");
        jmiCopy.setAccelerator(KeyStroke.getKeyStroke());

        jmEdit.add(jmiUndo);
        jmEdit.addSeparator();

        return null;
    }



}
