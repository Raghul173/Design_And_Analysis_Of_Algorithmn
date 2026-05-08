import java.util.Scanner;

public class HeapSortSimple {

    // Function to do Heap Sort
    static void heapSort(int arr[], int n) {

        // Build Max Heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Move biggest element to end one by one
        for (int i = n - 1; i > 0; i--) {

            // Swap first and last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify remaining array
            heapify(arr, i, 0);
        }
    }

    // Heapify function
    static void heapify(int arr[], int n, int i) {

        int largest = i;          // Assume current is largest
        int left = 2 * i + 1;    // Left child
        int right = 2 * i + 2;   // Right child

        // Check left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Swap if largest is not root
        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Heapify again
            heapify(arr, n, largest);
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

        // Call Heap Sort
        heapSort(arr, n);

        // Print sorted array
        System.out.println("Sorted array:");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }
}
