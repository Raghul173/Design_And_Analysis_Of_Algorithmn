import java.util.Scanner;

public class Horspool {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Text: ");
        String text = sc.nextLine();

        System.out.print("Enter Pattern: ");
        String pattern = sc.nextLine();

        int n = text.length();
        int m = pattern.length();

        int[] shift = new int[256];

        // Shift table
        for (int i = 0; i < 256; i++)
            shift[i] = m;

        for (int i = 0; i < m - 1; i++)
            shift[pattern.charAt(i)] = m - 1 - i;

        int i = m - 1;

        while (i < n) {

            int k = 0;

            while (k < m &&
                    pattern.charAt(m - 1 - k) == text.charAt(i - k)) {
                k++;
            }

            if (k == m) {
                System.out.println("Pattern Found at position: " + (i - m + 1));
                return;
            }

            i = i + shift[text.charAt(i)];
        }

        System.out.println("Pattern Not Found");

        sc.close();
    }
}

//Create shift table
//Start from end of pattern
//Compare backwards
//Shift using table if mismatch
