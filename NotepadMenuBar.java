import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.View;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.io.*;

public class NotepadMenuBar {

    private JMenuBar jmbMAIN;
    private JFrame jfrm;
    private TextArea txtArea;
    public NotepadMenuBar(JFrame jfrm, TextArea textArea){
        this.jfrm = jfrm;
        txtArea = textArea;
        jmbMAIN = new JMenuBar();

        FileMenuBar fiM = new FileMenuBar(jfrm, txtArea);
        EditMenuBar edM = new EditMenuBar(jfrm, txtArea);
        FormatMenuBar forM = new FormatMenuBar(jfrm, txtArea);
        ViewMenuBar viM = new ViewMenuBar(jfrm, txtArea);
        HelpMenuBar heM = new HelpMenuBar(jfrm, txtArea);

        jmbMAIN.add(fiM.getFileJM());
        jmbMAIN.add(edM.getEditJM());
        jmbMAIN.add(forM.getFormatJM());
        jmbMAIN.add(viM.getViewJM());
        jmbMAIN.add(heM.getHelpJM());
    }

    public JMenuBar getNotepadMenu(){
        return jmbMAIN;
    }
    
}
