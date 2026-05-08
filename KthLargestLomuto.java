import java.util.Scanner;

public class KthLargestLomuto {

    // Lomuto Partition
    static int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            // For Kth Largest
            if (arr[j] > pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot correctly
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Select
    static int kthLargest(int arr[], int low, int high, int k) {

        int p = partition(arr, low, high);

        if (p == k - 1)
            return arr[p];

        else if (p > k - 1)
            return kthLargest(arr, low, p - 1, k);

        else
            return kthLargest(arr, p + 1, high, k);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter k value: ");
        int k = sc.nextInt();

        int result = kthLargest(arr, 0, n - 1, k);

        System.out.println(k + " Largest Element is: " + result);

        sc.close();
    }
}

//ake last element as pivot
//Put bigger elements left side
//Pivot gets correct position
//Check if pivot position = k-1
//Else search left/right recursivel
