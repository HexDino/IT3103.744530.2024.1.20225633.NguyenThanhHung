//Nguyen Thanh Hung - 20225633
import javax.swing.JOptionPane;
public class HelloNameDialog {
    public static void main(String[] args) {
        String result_NTH;
        result_NTH = JOptionPane.showInputDialog("Please enter your name:");
        JOptionPane.showMessageDialog(null, "Hi " + result_NTH + "! How are you?");
        System.exit(0);
    } 
}