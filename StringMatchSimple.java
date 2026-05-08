import java.util.Scanner;

public class StringMatchSimple {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input text
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        // Input pattern
        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        int i = 0;
        int j = 0;

        int n = text.length();
        int m = pattern.length();

        boolean found = false;

        // Simple brute force matching
        while (i < n) {

            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1; // move to next starting position
                j = 0;
            }

            // Pattern found
            if (j == m) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Pattern found at position: " + (i - m));
        } else {
            System.out.println("Pattern not found");
        }

        sc.close();
    }
}
