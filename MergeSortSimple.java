import java.util.Scanner;

public class MergeSortSimple {

    // Merge Sort Function
    static void mergeSort(int arr[], int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            // Sort left side
            mergeSort(arr, left, mid);

            // Sort right side
            mergeSort(arr, mid + 1, right);

            // Merge both sides
            merge(arr, left, mid, right);
        }
    }

    // Merge Function
    static void merge(int arr[], int left, int mid, int right) {

        int temp[] = new int[right - left + 1];

        int i = left;
        int j = mid + 1;
        int k = 0;

        // Compare and store smaller element
        while (i <= mid && j <= right) {

            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }

            k++;
        }

        // Copy remaining left elements
        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        // Copy remaining right elements
        while (j <= right) {
            temp[k] = arr[j];
            j++;
            k++;
        }

        // Copy back to original array
        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        // Input array
        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call Merge Sort
        mergeSort(arr, 0, n - 1);

        // Print sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
