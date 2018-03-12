import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;

//
// Name: Vu, Anthony
// Project: 2
// Due: 3/7/2018
// Course: CS-245-01-w18
//
// Description:
// This class is responsible for generating the JDialog that
// will allow the user to select Font, Style, and Size. The
// is allowed to select any option from the list provided.
// This will then trigger a listner to update the sample text
// with the appropriate settings that the user selected.
//

public class JFontChooser {

    private JFrame jfrm;
    private JDialog jdlg;
    private Font defaultFont;
    private Color defaultColor;
    private Font selectedFont;
    private Color selectedColor;
    private JLabel jlSampleTxt;
    private Font oldFont;
    private Color oldColor;
    private boolean flag = false;

    public JFontChooser(){
        defaultColor = new Color(0, 0, 0);
        defaultFont = new Font("Courier New",Font.PLAIN,12);
        selectedColor = defaultColor;
        selectedFont = defaultFont;
    }

    public void setDefault(Font font){
        defaultFont = font;
        selectedFont = font;
    }

    public void setDefault(Color color){
        defaultColor = color;
        selectedColor = color;
    }

    public Color getColor(){return selectedColor;}

    public Font getFont() {return selectedFont;}

    public boolean showDialog(JFrame parent){
        jfrm = parent;
        generateDialog();

        oldFont = selectedFont;
        oldColor = selectedColor;

        //System.out.println("Font: " + selectedFont.getFamily() + "\tStyle: " + selectedFont.getStyle() + "\tSize: " + selectedFont.getSize());
        //set "default"
        jlSampleTxt.setFont(new Font(selectedFont.getFamily(), selectedFont.getStyle(), selectedFont.getSize()));
        jlSampleTxt.setForeground(selectedColor);

        jdlg.setLocationRelativeTo(parent);
        jdlg.setVisible(true);
        return flag;
    }

    private void generateDialog(){

        jdlg = new JDialog(jfrm,"Font",true);
        jdlg.setSize(550,500);
        jdlg.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(5,5,5,5);

        ///////column 1
        gbc.gridx = 0;
        gbc.gridy = 0;
        jdlg.add(generateFontPane(),gbc);

        ///////column 2
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc. gridy = 0;
        jdlg.add(generateFontStylePane(),gbc);

        ///////column 3
        gbc.gridx = 2;
        gbc.gridy = 0;
        jdlg.add(generateFontSizePane(), gbc);

        //sample text area
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        jdlg.add(generateSampleTextArea(),gbc);
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;

        //button: ok cancel color chooser
        gbc.gridx = 2;
        gbc.gridy = 1;
        jdlg.add(generateButton(),gbc);
        jdlg.pack();
    }

    private JPanel generateSampleTextArea(){
        jlSampleTxt = new JLabel("AaBbYyZz");
        jlSampleTxt.setHorizontalAlignment(SwingConstants.CENTER);
        jlSampleTxt.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.GRAY, 1),new EmptyBorder(40,80,40, 80)));

        JPanel jpln = new JPanel();
        jpln.setLayout(new BorderLayout());
        jpln.setMinimumSize(new Dimension(300,200));
        jpln.setPreferredSize(new Dimension(300,200));
        jpln.setMaximumSize(new Dimension(300, 200));
        jpln.add(jlSampleTxt, BorderLayout.NORTH);
        return jpln;
    }

    private JPanel generateButton(){
        JButton jbOkay = new JButton("OK");
        JButton jbCancel = new JButton("Cancel");
        JButton jbColorChooser = new JButton("Color Chooser");
        GridBagConstraints gbcs = new GridBagConstraints();

        JPanel butt = new JPanel();
        butt.setLayout(new GridBagLayout());

        gbcs.insets = new Insets(10,5,5,5);

        gbcs.gridx = 0;
        gbcs.gridy = 0;
        gbcs.gridwidth = 2;
        gbcs.fill = GridBagConstraints.HORIZONTAL;
        butt.add(jbColorChooser, gbcs);
        gbcs.gridwidth = 1;
        gbcs.fill = GridBagConstraints.NONE;

        gbcs.gridx = 0;
        gbcs.gridy = 1;
        butt.add(jbOkay,gbcs);

        gbcs.gridx = 1;
        gbcs.gridy = 1;
        butt.add(jbCancel,gbcs);
        gbcs.gridx = 0;
        gbcs.gridy = 0;

        jbColorChooser.addActionListener(ae -> {
            Color c = JColorChooser.showDialog(jbColorChooser, "Select a color", selectedColor);
            if(c != null){
                selectedColor = c;
                jlSampleTxt.setForeground(selectedColor);
                //System.out.println(c.toString());
            }
        });

        jbOkay.addActionListener(ae -> {
            flag = true;
            jdlg.dispose();
        });

        jbCancel.addActionListener(ae -> {
            selectedColor = oldColor;
            selectedFont = oldFont;
            flag = false;
            jdlg.dispose();
        });

        return butt;
    }

    private JPanel generateFontPane(){
        String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fonts.length; i++)
            lm.addElement(fonts[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        JLabel jlFont = new JLabel("Font:");
        //JTextField jtFont = new JTextField(10);

        jlst.setSelectedValue(selectedFont.getFamily(), true);
        //jtFont.setText(selectedFont.getFamily());

        //jtFont.setEnabled(false);
        JPanel jpln = new JPanel();
        jpln.setLayout(new BorderLayout());
        jpln.add(jlFont, BorderLayout.NORTH);
        //jpln.add(jtFont, BorderLayout.CENTER);
        jpln.add(jscrlp, BorderLayout.SOUTH);

        jlst.addListSelectionListener((ListSelectionEvent le) ->{
            String font = jlst.getSelectedValue().toString();
            //jtFont.setText(font);
            selectedFont = new Font(font, selectedFont.getStyle(), selectedFont.getSize());
            jlSampleTxt.setFont(selectedFont);
            //System.out.println(font);
        });

        return jpln;
    }

    private JPanel generateFontStylePane(){
        String fontsStyles[] = {"Plain", "Bold", "Italic", "Bold Italic"};
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fontsStyles.length; i++)
            lm.addElement(fontsStyles[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        JLabel jlStyle = new JLabel("Style:");
        //JTextField jtStyle = new JTextField(10);


        jlst.setSelectedValue(fontsStyles[selectedFont.getStyle()], true);
        //jtStyle.setText(fontsStyles[selectedFont.getStyle()]);

        //jtStyle.setEnabled(false);
        JPanel jpln = new JPanel();
        jpln.setLayout(new BorderLayout());
        jpln.add(jlStyle, BorderLayout.NORTH);
        //jpln.add(jtStyle, BorderLayout.CENTER);
        jpln.add(jscrlp, BorderLayout.SOUTH);

        jlst.addListSelectionListener((ListSelectionEvent le) ->{
            String style = jlst.getSelectedValue().toString();
            //jtStyle.setText(style);
            setNewStyle(style);
        });

        return jpln;
    }

    private void setNewStyle(String style) {
        int holder;

        //"Plain", "Bold", "Italic", "Bold Italic"
        if (style.equals("Plain")) {
            holder = 0;
        } else if(style.equals("Bold")){
            holder = 1;
        }else if (style.equals("Italic")){
            holder = 2;
        } else
            holder = 3;

        selectedFont = new Font(selectedFont.getFamily(), holder, selectedFont.getSize());
        jlSampleTxt.setFont(selectedFont);
        //System.out.println(style);
    }


    private JPanel generateFontSizePane(){
        String fontSize[] = {"8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "36", "48", "72"};
        DefaultListModel lm = new DefaultListModel();

        for(int i = 0; i < fontSize.length; i++)
            lm.addElement(fontSize[i]);

        JList jlst = new JList(lm);
        JScrollPane jscrlp = new JScrollPane(jlst);

        JLabel jlSize = new JLabel("Size:");
        //JTextField jtSize = new JTextField(10);

        jlst.setSelectedValue(String.valueOf(selectedFont.getSize()), true);
        //jtSize.setText(String.valueOf(selectedFont.getSize()));

        //jtSize.setEditable(false);
        JPanel jpln = new JPanel();
        jpln.setLayout(new BorderLayout());
        jpln.add(jlSize, BorderLayout.NORTH);
        //jpln.add(jtSize, BorderLayout.CENTER);
        jpln.add(jscrlp, BorderLayout.SOUTH);

        /*
        jtSize.addActionListener(ae -> {
            int size = Integer.valueOf(ae.getActionCommand());
            selectedFont = new Font(selectedFont.getFamily(), selectedFont.getStyle(), size);
            jlSampleTxt.setFont(selectedFont);
        }); */

        jlst.addListSelectionListener((ListSelectionEvent le) ->{
            int size = Integer.valueOf(jlst.getSelectedValue().toString());
            //jtSize.setText(jlst.getSelectedValue().toString());
            selectedFont = new Font(selectedFont.getFamily(), selectedFont.getStyle(), size);
            jlSampleTxt.setFont(selectedFont);
        });

        return jpln;
    }

}