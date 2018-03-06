import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.io.*;

public class NotepadMenuBarFunctionality{

    private JTextArea txtArea;
    private JFrame jfrm;
    protected JFileChooser jfc;

    protected boolean isEmpty() {
        return (txtArea.getClass() == null || txtArea.getText().equals("")) ? true : false;
    }

    protected void loadFile(File file){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            txtArea.read(input,null);
            input.close();
            txtArea.revalidate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void saveFile(File file){
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(file));

            txtArea.write(outFile);
            outFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void newMenuOption(){
        //change changes to ____ to file name
        if(!isEmpty()){
            System.out.print("nothing in text area");
        }else{
            JOptionPane.showConfirmDialog(jfrm,"Do you want to save changes to Untitled?",
                    "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);

        }

    }

    protected void openMenuOption(){
        if (!isEmpty()) {
            saveChanges();
        }
        int result = jfc.showOpenDialog(null);
        if(result == JFileChooser.APPROVE_OPTION){
            File file = jfc.getSelectedFile();
            if(file.getName().endsWith(".java") || file.getName().endsWith(".txt")) {
                loadFile(file);
            }else {
                JOptionPane.showMessageDialog(jfrm, "File is not .txt or .java!!", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else
            System.out.println("nothing selected");
    }

    private void saveChanges(){
        JOptionPane.showConfirmDialog(jfrm,"Do you want to save changes to Untitled?",
                "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    protected void saveAsMenuOption(){
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
        saveFile(file);
    }

    protected void exitMenuOption(){
        System.out.println("exit caught");
    }

}
