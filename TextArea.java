import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class TextArea {

    private JTextArea textArea;

    public TextArea(JFrame jfrm){
        textArea = new JTextArea(10,10);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(true);
        jfrm.add(scrollPane);

    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
