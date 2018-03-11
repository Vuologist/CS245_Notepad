import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class TextArea {

    private JTextArea textArea;
    private String fileName;

    public TextArea(JFrame jfrm, String fileName){
        textArea = new JTextArea(10,10);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(true);
        jfrm.add(scrollPane);

        this.fileName = fileName;
    }

    public String getFileName(){return fileName;}

    public JTextArea getTextArea() {
        return textArea;
    }
}
