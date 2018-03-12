import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.InputEvent;
import java.awt.event.WindowEvent;
import java.io.*;

public class FileMenuBar {

    private JFrame jfrm;
    private TextArea txtArea;
    private String oldTextArea;
    private JFileChooser jfc;
    private JMenu fileJM;

    public FileMenuBar(JFrame jfrm, TextArea txtArea){
        this.jfrm = jfrm;
        this.txtArea = txtArea;
        oldTextArea = "";
        fileJM = new JMenu("File");
        fileJM.setMnemonic('F');

        fileMenuItems();
    }

    public JMenu getFileJM() {
        return fileJM;
    }

    private void fileMenuItems (){
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
            //add code
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

        fileJM.add(jmiNew);
        fileJM.add(jmiOpen);
        fileJM.add(jmiSave);
        fileJM.add(jmiSaveAs);
        fileJM.addSeparator();
        fileJM.add(jmiPageSetup);
        fileJM.add(jmiPrint);
        fileJM.addSeparator();
        fileJM.add(jmiExit);
    }

    //////////////////////////////////// functionality begins

    private boolean isEmpty() {
        return txtArea.getTextArea().getText().trim().length() == 0 ? true : false;
    }

    private void saveOld(){
        oldTextArea = txtArea.getTextArea().getText().replaceAll("\\s+","");
    }

    private boolean isChanged(){
        String holder = txtArea.getTextArea().getText();
        String newHolder = holder.replaceAll("\\s+","");
        return (!newHolder.equals(oldTextArea)? true : false);
    }

    private void newMenuOption(){
        int response = JOptionPane.CANCEL_OPTION;
        if(!isEmpty()){
            response = JOptionPane.showConfirmDialog(jfrm,"Do you want to save changes to Untitled?",
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
            if(response == JOptionPane.YES_OPTION){
                saveDoesAll();
                txtArea.getTextArea().setText("");
            } else if (response == JOptionPane.NO_OPTION){
                txtArea.getTextArea().setText("");
            }
        }
    }

    private void openMenuOption(){
        int response;
        if(isChanged()){
            response = JOptionPane.showConfirmDialog(jfrm,"Do you want to save changes to " + jfrm.getTitle() + "?",
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
            System.out.print(response);
            if(response == JOptionPane.YES_OPTION){
                saveDoesAll();
                txtArea.getTextArea().setText("");
            } else if (response == JOptionPane.NO_OPTION){
                response = JOptionPane.YES_OPTION;
            }else {
                return;
            }
        }

        jfc = new JFileChooser();
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("*.txt", "txt");
        FileNameExtensionFilter javaFilter = new FileNameExtensionFilter("*.java", "java");
        jfc.addChoosableFileFilter(javaFilter);
        jfc.setFileFilter(txtFilter);
        int result = jfc.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File file = jfc.getSelectedFile();
            saveOld();
            if(file.getName().endsWith(".java") || file.getName().endsWith(".txt")) {
                loadFileForOpenMenu(file);
            }else {
                JOptionPane.showMessageDialog(jfrm, "File is not .txt or .java!!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else
            System.out.println("nothing selected");
    }

    private void loadFileForOpenMenu(File file){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            txtArea.getTextArea().read(input,null);
            jfrm.setTitle(file.getName());
            input.close();
            txtArea.getTextArea().revalidate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveAsMenuOption(){
        //need to check for overwriting

        //create new text area object

        saveDoesAll();
    }

    private void saveDoesAll(){
        jfc = new JFileChooser();
        FileNameExtensionFilter txtFilter = new FileNameExtensionFilter("*.txt", "txt");
        FileNameExtensionFilter javaFilter = new FileNameExtensionFilter("*.java", "java");
        jfc.addChoosableFileFilter(javaFilter);
        jfc.setFileFilter(txtFilter);
        jfc.setApproveButtonText("Save");
        int result = jfc.showOpenDialog(null);
        if(result != jfc.APPROVE_OPTION){
            return;
        }

        File file = jfc.getSelectedFile();

        if (file.exists()) {
            int response = JOptionPane.showConfirmDialog(null,
                    "Do you want to replace the existing file?",
                    "Confirm", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (response != JOptionPane.YES_OPTION) {
                return;
            }
        }

        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(file));

            txtArea.getTextArea().write(outFile);
            outFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void exitMenuOption(){
        //might want to do stuff here
        //definely need more code
        System.out.println("exit caught");
    }

}
