import java.util.Scanner;

/**
 *  Input : 110010
       Output : 50
 
       Input : 100100
       Output : 36
 
       Input : 100
       Output : 4
 */

public class binToDecRec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter binary number ");
        int bin = scanner.nextInt(), dec;
        dec = recursiveBinToDec(bin);
        System.out.println(dec);
        scanner.close();
    }

    private static int recursiveBinToDec(int bin) {
        if (bin == 0)
            return 0;
        return (bin % 10) + (2 * recursiveBinToDec(bin / 10));
    }

    // private static int whileBinToDec(int bin) {
    // int dec = 0, p = 0;
    // while (bin > 0) {
    // int decimal = bin % 10;
    // dec += decimal * Math.pow(2, p++);
    // bin /= 10;
    // }
    // return dec;
    // }
}
