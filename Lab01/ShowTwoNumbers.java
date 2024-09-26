//Nguyen Thanh Hung - 20225633
import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args){
        String strNum1_NTH, strNum2_NTH;
        String strNotification_NTH = "You've just entered: ";
        strNum1_NTH = JOptionPane.showInputDialog(null, "Please input the first number:","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNotification_NTH += strNum1_NTH + " and ";

        strNum2_NTH = JOptionPane.showInputDialog(null, "Please input the second number:","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        strNotification_NTH += strNum2_NTH;

        JOptionPane.showMessageDialog(null, strNotification_NTH, "Show two numbers", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    } 
}