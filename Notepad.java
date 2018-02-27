import javax.swing.*;
import java.awt.*;

public class Notepad {

    private JFrame jfrm;

    public Notepad(){
        jfrm = new JFrame ("Untitled-Notepad");
        jfrm.setSize(650,325);
        jfrm.setLayout(new BorderLayout());
        jfrm.setDefaultCloseOperation(jfrm.EXIT_ON_CLOSE);

        NotepadMenuBar menuBar = new NotepadMenuBar(jfrm);
        jfrm.setJMenuBar(menuBar.getNotepadMenu());

        TextArea txtArea = new TextArea(jfrm);


        jfrm.setLocationRelativeTo(null);
        jfrm.setVisible(true);
    }

    public static void main (String args[]){
        SwingUtilities.invokeLater( ()->{
            new Notepad();
        });
    }

}
