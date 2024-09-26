import java.util.Scanner;

public class YearMonth { 
    public static void main(String[] args) {
        Scanner scanner_NTH = new Scanner(System.in);
        int year_NTH = 0;
        int month_NTH = 0;
        boolean validInput_NTH = false;

        while (!validInput_NTH) {
            System.out.print("Enter a year (non-negative number): ");
            if (scanner_NTH.hasNextInt()) {
                year_NTH = scanner_NTH.nextInt();
                if (year_NTH >= 0) {
                    validInput_NTH = true;
                } else {
                    System.out.println("Invalid year. Please enter a non-negative number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner_NTH.next(); 
            }
        }

        validInput_NTH = false;
        scanner_NTH.nextLine(); 

        while (!validInput_NTH) {
            System.out.print("Enter a month (full name, abbreviation, or number): ");
            String monthInput_NTH = scanner_NTH.nextLine().trim().toLowerCase();

            switch (monthInput_NTH) {
                case "january":
                case "jan.":
                case "jan":
                case "1":
                    month_NTH = 1;
                    validInput_NTH = true;
                    break;
                case "february":
                case "feb.":
                case "feb":
                case "2":
                    month_NTH = 2;
                    validInput_NTH = true;
                    break;
                case "march":
                case "mar.":
                case "mar":
                case "3":
                    month_NTH = 3;
                    validInput_NTH = true;
                    break;
                case "april":
                case "apr.":
                case "apr":
                case "4":
                    month_NTH = 4;
                    validInput_NTH = true;
                    break;
                case "may":
                case "5":
                    month_NTH = 5;
                    validInput_NTH = true;
                    break;
                case "june":
                case "jun.":
                case "jun":
                case "6":
                    month_NTH = 6;
                    validInput_NTH = true;
                    break;
                case "july":
                case "jul.":
                case "jul":
                case "7":
                    month_NTH = 7;
                    validInput_NTH = true;
                    break;
                case "august":
                case "aug.":
                case "aug":
                case "8":
                    month_NTH = 8;
                    validInput_NTH = true;
                    break;
                case "september":
                case "sep.":
                case "sep":
                case "9":
                    month_NTH = 9;
                    validInput_NTH = true;
                    break;
                case "october":
                case "oct.":
                case "oct":
                case "10":
                    month_NTH = 10;
                    validInput_NTH = true;
                    break;
                case "november":
                case "nov.":
                case "nov":
                case "11":
                    month_NTH = 11;
                    validInput_NTH = true;
                    break;
                case "december":
                case "dec.":
                case "dec":
                case "12":
                    month_NTH = 12;
                    validInput_NTH = true;
                    break;
                default:
                    System.out.println("Invalid month. Please enter a valid month.");
            }
        }

        int days_NTH = getDaysInMonth(month_NTH, year_NTH);
        System.out.println("Number of days: " + days_NTH);
    }

    public static int getDaysInMonth(int month_NTH, int year_NTH) {
        switch (month_NTH) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (isLeapYear(year_NTH)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                throw new IllegalArgumentException("Invalid month: " + month_NTH);
        }
    }

    public static boolean isLeapYear(int year_NTH) {
        if (year_NTH % 4 == 0) {
            if (year_NTH % 100 == 0) {
                return year_NTH % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}