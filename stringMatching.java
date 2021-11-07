import java.util.Scanner;

/**
 * 1 : Write a program to check if the given alpha numeric satisfies all of the
 * below conditions. I. A single alphabet or digit occurs 2 consecutive times.
 * Like 77 / cc II. A single alphabet or digit occurs 3 or more times in the
 * given alpha numeric. i. Three consecutive alphabets or digits either in
 * increasing or decreasing order. Like 345 / 543 or xyz / zyx ii. Not more than
 * 2 spaces.
 * 
 * Input : 54234efg33h Output : Matches
 * 
 */
public class stringMatching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a string ");
        String text = scanner.nextLine();
        boolean a = checkOccur2TimesConsecutively(text), b = threeConsecutiveInOrder(text),
                c = checkIfNoMoreThan2Space(text);
        if (a && b && c) {
            System.out.println("Matches");
        } else {
            System.out.println("Not Matches");
        }
        scanner.close();
    }

    private static boolean checkIfNoMoreThan2Space(String text) {
        int spaces = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ')
                spaces++;
            if (spaces > 2)
                return false;
        }
        return true;
    }

    private static boolean threeConsecutiveInOrder(String text) {
        for (int i = 2; i < text.length(); i++) {
            int at0 = text.charAt(i - 2), at1 = text.charAt(i - 1), at2 = text.charAt(i); // int for ascii
            if (((at0 + 2) == (at1 + 1)) && ((at1 + 1) == (at2 + 0))) {
                // abc equating to last one
                return true;
            }
            if (((at0 - 2) == (at1 - 1)) && ((at1 - 1) == (at2 - 0))) {
                // cba equating to last one
                return true;
            }
        }
        return false;
    }

    private static boolean checkOccur2TimesConsecutively(String text) {
        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i - 1) == text.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}