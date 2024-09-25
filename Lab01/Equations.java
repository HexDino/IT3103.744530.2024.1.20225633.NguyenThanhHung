import javax.swing.JOptionPane;

public class Equations {
    static double first_degree_equation(Double a_NTH, Double b_NTH) {
        if (a_NTH == 0) {
            if (b_NTH == 0) {
                System.out.println("The equation has infinite solutions");
            } else {
                System.out.println("The equation has no solution");
            }
        } else {
            return (+ -b_NTH / a_NTH);
        }
        return 0;
    }

    static double two_degree_equation(Double a_NTH, Double b_NTH, Double c_NTH) {
        if (a_NTH == 0) {
            return first_degree_equation(b_NTH, c_NTH);
        } else {
            double delta_NTH = b_NTH * b_NTH - 4 * a_NTH * c_NTH;
            if (delta_NTH < 0) {
                System.out.println("The equation has no solution");
            } else if (delta_NTH == 0) {
                return (-b_NTH / (2 * a_NTH));
            } else {
                return ((-b_NTH + Math.sqrt(delta_NTH)) / (2 * a_NTH) + (-b_NTH - Math.sqrt(delta_NTH)) / (2 * a_NTH));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String strNum1_NTH, strNum2_NTH, strNum3_NTH;
        strNum1_NTH = JOptionPane.showInputDialog(null, "Input a", JOptionPane.INFORMATION_MESSAGE);
        strNum2_NTH = JOptionPane.showInputDialog(null, "Input b", JOptionPane.INFORMATION_MESSAGE);
        strNum3_NTH = JOptionPane.showInputDialog(null, "Input c", JOptionPane.INFORMATION_MESSAGE);
        double num1_NTH = Double.parseDouble (strNum1_NTH);
        double num2_NTH = Double.parseDouble (strNum2_NTH);
        double num3_NTH = Double.parseDouble (strNum3_NTH);

        double result_NTH;

        if (num1_NTH == 0) {
            result_NTH = first_degree_equation(num2_NTH, num3_NTH);
        } else {
            result_NTH = two_degree_equation(num1_NTH, num2_NTH, num3_NTH);
        }

        JOptionPane.showMessageDialog(null, "Result: " + result_NTH, "Equations", JOptionPane.INFORMATION_MESSAGE);
    }

}
