
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainFrame extends JFrame {
    private EbcdicToText ebcdicToText;

    public MainFrame(){
        super();
        this.initComponents();
    }

    private void initComponents(){
        ebcdicToText = new EbcdicToText();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel(new BorderLayout());
        JButton btn = new JButton("Convert File");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertText();
            }
        });

        mainPanel.add(btn, BorderLayout.CENTER);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));

        this.setTitle("ebcdic2text by edu");
        this.setSize(320,150);
        this.add(mainPanel);
        this.setLocationRelativeTo(null);
    }

    private void convertText(){
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Select a file with hex/ebcdic format");
        int returnVal = fc.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {

            File file = fc.getSelectedFile();
            String data = null;
            try {
                data = this.ebcdicToText.toTextFromFile(file);
                this.saveNewConvertedFile(file, data);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    private void saveNewConvertedFile(File originFile, String contentForNewFile){

        String newname = originFile.getParent()
                + File.separator
                + appendName(originFile.getName(), "_converted");
        try {
            FileWriter fw = new FileWriter(newname);
            fw.write(contentForNewFile);
            fw.close();
            String msg = "Converted file at: " + newname;
            JOptionPane.showMessageDialog(this, msg);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private String appendName(String filename, String append){
        String result = filename;
        int idx = filename.lastIndexOf('.');
        if( idx != -1){
            String sub = filename.substring(idx);
            result = filename.substring(0, idx) + append + sub;
        }
        return result;
    }

}