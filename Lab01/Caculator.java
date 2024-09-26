//Nguyen Thanh Hung - 20225633
import javax.swing.JOptionPane;
public class Caculator { 
    public static void main(String[] args){
        String strNum1_NTH, strNum2_NTH;
        strNum1_NTH = JOptionPane.showInputDialog(null, "Please input the first number:","Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2_NTH = JOptionPane.showInputDialog(null, "Please input the second number:","Input the second number", JOptionPane.INFORMATION_MESSAGE);
        double num1_NTH = Double.parseDouble (strNum1_NTH);
        double num2_NTH = Double.parseDouble (strNum2_NTH);

        double sum_NTH = num1_NTH + num2_NTH;
        double difference_NTH = num1_NTH - num2_NTH;
        double product_NTH = num1_NTH * num2_NTH;
        double quotient_NTH = num1_NTH / num2_NTH;

        String strNotificcation_NTH = "Sum of " + num1_NTH + " and " + num2_NTH + " is " + sum_NTH + "\n";
        strNotificcation_NTH += "Difference of " + num1_NTH + " and " + num2_NTH + " is " + difference_NTH + "\n";
        strNotificcation_NTH += "Product of " + num1_NTH + " and " + num2_NTH + " is " + product_NTH + "\n";
        strNotificcation_NTH += "Quotient of " + num1_NTH + " and " + num2_NTH + " is " + quotient_NTH + "\n";

        JOptionPane.showMessageDialog(null, strNotificcation_NTH, "Caculator", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}