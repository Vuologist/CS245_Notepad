import javax.swing.*;

public class TextArea {

    private JTextArea textArea;

    public TextArea(JFrame jfrm){
        textArea = new JTextArea(600,300);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textArea.setEditable(true);
        jfrm.add(textArea);

    }

}
