import javax.swing.*;
import java.awt.*;

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

public class JNotepad {

    private JFrame jfrm;

    public JNotepad(){
        jfrm = new JFrame ("Untitled");
        jfrm.setSize(650,325);
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("JNotepad.png");
        jfrm.setIconImage(icon.getImage());

        TextArea txtArea = new TextArea(jfrm);
        NotepadMenuBar menuBar = new NotepadMenuBar(jfrm, txtArea);
        jfrm.setJMenuBar(menuBar.getNotepadMenu());

        jfrm.setLocationByPlatform(true);
        jfrm.setVisible(true);
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater( ()->{
            new JNotepad();
        });
    }
}
