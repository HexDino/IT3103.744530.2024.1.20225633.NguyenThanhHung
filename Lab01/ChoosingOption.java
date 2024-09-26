import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args){
        int option_NTH = JOptionPane.showConfirmDialog(null, "Do you want to change to the first class ticket?");
        String message_NTH;
        if (option_NTH == JOptionPane.YES_OPTION) {
            message_NTH = "Yes";
        } else if (option_NTH == JOptionPane.NO_OPTION) {
            message_NTH = "No";
        } else if (option_NTH == JOptionPane.CANCEL_OPTION) {
            message_NTH = "Cancel";
        } else {
            message_NTH = "Unknown";
        }
        JOptionPane.showMessageDialog(null, "You've chosen: " + message_NTH);
        System.exit(0);
    }
}