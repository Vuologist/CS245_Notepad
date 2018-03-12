import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

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
