import java.util.Scanner;

/**
 * https://onlinegdb.com/w52aqY8nE 2 : Write a program to form lines using the
 * given set of words. The line formation should follow the below rules. i )
 * Total characters in a single line excluding the space between the words and
 * the favorite character should not exceed the given maximum number ii )
 * Favorite character is case insensitive. i.e, if the favorite is specified as
 * 'd' then both 'd' and 'D' should be left out while counting. iii ) Words
 * should not be broken up. Complete words alone should be used in a line. A
 * word should be used in one line only. Input : Max char per line : 10 Favorite
 * character : o Words : Zoho,Eating,Watching,Pogo,Loving,Mango Output :
 * Watching Zoho (10) Eating Mango (10) Loving Pogo (7) Input: Max char per line
 * : 15 Favorite character : w Words :
 * Twinkle,Twinkle,little,star,how,I,wonder,what,you,are Page 1 of 3 Output :
 * Twinkle Twinkle what ( 15 ) little wonder star ( 15 ) you are how I ( 9 )
 */

public class formLinesWithGivenSetOfWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Max char per line : ");
        int m = scanner.nextInt(), count = 0, inner = 0;

        System.out.print("Favorite character : ");
        char ch = scanner.next().charAt(0);

        System.out.print("Words : ");
        String arr[] = scanner.next().split(",");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(0) != '.') {
                count = 0;
                System.out.print(arr[i] + " ");
                for (char c : arr[i].toCharArray())
                    if (c != ch)
                        count++;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j].charAt(0) != '.') {
                        inner = 0;
                        for (char c : arr[j].toCharArray())
                            if (c != ch)
                                inner++;
                        if (count + inner <= m) {
                            count += inner;
                            System.out.print(arr[j] + " ");
                            arr[j] = ".".concat(arr[j]);
                        }
                        if (count >= m)
                            break;
                    }
                }
            }
            if (arr[i].charAt(0) != '.')
                System.out.println();
        }
        scanner.close();
    }
}

/**
 * 1 Input:- Max char per line : 10\nFavorite character : o\nWords :
 * Eating,Watching,Mango,Loving,Zoho,Pogo
 * 
 * 1 Output:- Eating Mango\nWatching Zoho\nLoving Pogo
 */

/**
 * 2 Input:- Max char per line : 15\nFavorite character : w\nWords :
 * Twinkle,Twinkle,little,star,how,I,wonder,what,you,are
 * 
 * 2 Output:- Twinkle Twinkle how I\nlittle star wonder\nwhat you are
 */
