import javax.swing.*;
import java.awt.*;

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
