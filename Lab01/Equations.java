import javax.swing.JOptionPane;

public class Equations {
    static double first_degree_equation(Double a_NTH, Double b_NTH) {
        return (-b_NTH / a_NTH);
    }

    static class TwoDegreeEquationResult {
        double x1;
        double x2;

        TwoDegreeEquationResult(double x1, double x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    } 

    static TwoDegreeEquationResult two_degree_equation(Double a_NTH, Double b_NTH, Double c_NTH) {
        if (a_NTH == 0) {
            return new TwoDegreeEquationResult(first_degree_equation(b_NTH, c_NTH), 0);
        } else {
            double delta_NTH = b_NTH * b_NTH - 4 * a_NTH * c_NTH;
            if (delta_NTH < 0) {
                System.out.println("The equation has no solution");
            } else if (delta_NTH == 0) {
                return new TwoDegreeEquationResult(-b_NTH / (2 * a_NTH), 0);
            } else {
                double x1 = (-b_NTH + Math.sqrt(delta_NTH)) / (2 * a_NTH);
                double x2 = (-b_NTH - Math.sqrt(delta_NTH)) / (2 * a_NTH);
                return new TwoDegreeEquationResult(x1, x2);
            }
        }
        return new TwoDegreeEquationResult(0, 0);
    }

    public static void main(String[] args) {
        String strNum1_NTH, strNum2_NTH, strNum3_NTH;
        strNum1_NTH = JOptionPane.showInputDialog(null, "Input a", JOptionPane.INFORMATION_MESSAGE);
        strNum2_NTH = JOptionPane.showInputDialog(null, "Input b", JOptionPane.INFORMATION_MESSAGE);
        strNum3_NTH = JOptionPane.showInputDialog(null, "Input c", JOptionPane.INFORMATION_MESSAGE);
        double num1_NTH = Double.parseDouble(strNum1_NTH);
        double num2_NTH = Double.parseDouble(strNum2_NTH);
        double num3_NTH = Double.parseDouble(strNum3_NTH);

        TwoDegreeEquationResult result_NTH;

        if (num2_NTH == 0) {
            if (num1_NTH == 0) {
                JOptionPane.showMessageDialog(null, "The equation is not valid", "Equations", JOptionPane.ERROR_MESSAGE);
            } else {
                double x = first_degree_equation(num1_NTH, num3_NTH);
                JOptionPane.showMessageDialog(null, "Result: x = " + x, "Equations", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            if (num1_NTH == 0) {
                double x = first_degree_equation(num2_NTH, num3_NTH);
                JOptionPane.showMessageDialog(null, "Result: x = " + x, "Equations", JOptionPane.INFORMATION_MESSAGE);
            } else {
                result_NTH = two_degree_equation(num1_NTH, num2_NTH, num3_NTH);
                JOptionPane.showMessageDialog(null, "Result: x1 = " + result_NTH.x1 + ", x2 = " + result_NTH.x2, "Equations", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}