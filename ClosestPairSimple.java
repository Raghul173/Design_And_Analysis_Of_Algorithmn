import java.util.Scanner;

public class ClosestPairSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of points
        System.out.print("Enter number of points: ");
        int n = sc.nextInt();

        int x[] = new int[n];
        int y[] = new int[n];

        // Input points
        System.out.println("Enter coordinates (x y):");
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        double minDistance = Double.MAX_VALUE;
        int p1 = 0, p2 = 0;

        // Compare every pair (very basic logic)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                double dx = x[j] - x[i];
                double dy = y[j] - y[i];

                double distance = Math.sqrt(dx * dx + dy * dy);

                if (distance < minDistance) {
                    minDistance = distance;
                    p1 = i;
                    p2 = j;
                }
            }
        }

        // Output result
        System.out.println("Closest pair is:");
        System.out.println("(" + x[p1] + ", " + y[p1] + ") and (" + x[p2] + ", " + y[p2] + ")");
        System.out.println("Minimum distance: " + minDistance);

        sc.close();
    }
}

//Take all points
//Compare each point with every other point
//Calculate distance
//Store smallest distance found
//Print that pair
