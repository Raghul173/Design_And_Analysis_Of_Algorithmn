import java.util.Scanner;

public class SelectionSortSimple
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

        // Selection Sort logic (very basic)
        for (int i = 0; i < n - 1; i++)
            {

            int minIndex = i; // assume current is smallest

            for (int j = i + 1; j < n; j++)
                {
                // find smaller element
                if (arr[j] < arr[minIndex])
                    {
                    minIndex = j;
                }
            }

            // swap smallest with current position
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        // Print sorted array
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++)
            {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}

//Assume first element is smallest
//Check rest of array → find actual smallest
//Swap it with first position
//Move to next position and repeat
