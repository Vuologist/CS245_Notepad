import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class NotepadMenuBar {

    private JMenuBar jmb;
    private JFrame jfrm;
    private JFileChooser jfc;
    private TextArea txtArea;

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

    private void saveChanges(){
        JOptionPane.showConfirmDialog(jfrm,"Do you want to save changes to Untitled?",
                "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
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
            //change changes to ____ to file name
            JOptionPane.showConfirmDialog(jfrm,"Do you want to save changes to Untitled?",
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
        });

        jmiOpen.addActionListener(ae -> {
            if (!txtArea.isEmpty()) {
                saveChanges();
            }
            int result = jfc.showOpenDialog(null);
            if(result == JFileChooser.APPROVE_OPTION){
                File file = jfc.getSelectedFile();
                if(file.getName().endsWith(".java") || file.getName().endsWith(".txt")) {
                    txtArea.loadFile(file);
                }else {
                    JOptionPane.showMessageDialog(jfrm, "File is not .txt or .java!!", "Error", JOptionPane.WARNING_MESSAGE);
                }
            } else
                System.out.println("nothing selected");
        });

        jmiSave.addActionListener(ae -> {

        });

        jmiSaveAs.addActionListener(ae -> {
            //need to check for overwriting
            jfc.setApproveButtonText("Save");
            int result = jfc.showOpenDialog(null);
            if(result != jfc.APPROVE_OPTION){
                return;
            }

            File file = jfc.getSelectedFile();
             if(!file.getName().endsWith(".txt")){
                 file = new File(file.getAbsolutePath() + ".txt");
             }
            txtArea.saveFile(file);
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

}
