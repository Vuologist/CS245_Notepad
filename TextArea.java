import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class TextArea {

    private JTextArea textArea;
    private String fileName;
    private boolean changed = false;

    public TextArea(JFrame jfrm, String fileName){
        textArea = new JTextArea(10,10);
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                changed = true;
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                changed = true;
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                changed = true;
            }
        });
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(true);
        jfrm.add(scrollPane);

        this.fileName = fileName;
    }

    public String getFileName(){return fileName;}

    public boolean isChanged(){return changed;}

    public JTextArea getTextArea() {
        return textArea;
    }
}
