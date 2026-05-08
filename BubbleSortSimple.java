import java.util.Scanner;

public class BubbleSortSimple
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        // Get number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Get elements from user
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Bubble Sort logic (very basic)
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - 1; j++)
                {

                // Compare adjacent elements
                if (arr[j] > arr[j + 1])
                    {

                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}


// Compare two adjacent numbers
//If left > right → swap
//Repeat again and again
//Slowly biggest numbers go to the end
//Finally → array becomes sorted
