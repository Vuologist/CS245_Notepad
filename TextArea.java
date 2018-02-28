import javax.swing.*;
import java.io.*;

public class TextArea {

    private JTextArea textArea;

    public TextArea(JFrame jfrm){
        textArea = new JTextArea(10,10);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(true);
        jfrm.add(scrollPane);

    }

    public boolean isEmpty() {
        return (textArea.getText() == null || textArea.getText().equals("")) ? true : false;
    }

    public void loadFile(File file){
        try{
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file)));
            textArea.read(input,null);
            input.close();
            textArea.revalidate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveFile(File file){
        try {
            BufferedWriter outFile = new BufferedWriter(new FileWriter(file));

            textArea.write(outFile);
            outFile.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
