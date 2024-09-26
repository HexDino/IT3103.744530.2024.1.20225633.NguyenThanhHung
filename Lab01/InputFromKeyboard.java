import java.util.Scanner;
public class InputFromKeyboard {
    public static void main(String[] args){
        Scanner keyboard_NTH = new Scanner(System.in);
        System.out.println("What's your name?");
        String name = keyboard_NTH.nextLine();
        System.out.println("How old are you?");
        int age = keyboard_NTH.nextInt();
        System.out.println("How tall are you (m)?");
        double height = keyboard_NTH.nextDouble();
        System.out.println("Mr/Ms. " + name + ", " + age + " years old. Your height is " + height + "m.");
    }
}