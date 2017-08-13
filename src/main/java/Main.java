import javax.swing.*;

public class Main {

    public static void main(String[] args){
        try {
            // Set System L&F
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }catch (Exception ex){}
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}