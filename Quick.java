import java.util.*;

public class Quick
{
    public static int hoarePartition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i <= j)
        {
            // Added boundary checks (i <= high and j >= low)
            while (i <= high && arr[i] < pivot)
            {
                i++;
            }
            while (j >= low && arr[j] > pivot)
            {
                j--;
            }
            if (i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[j];
        arr[j] = arr[low];
        arr[low] = temp;

        return j;
    }

    public static void quicksort(int arr[], int low, int high)
    {
        // Added base case to stop recursion
        if (low < high)
        {
            int p = hoarePartition(arr, low, high); // Fixed arr[] to arr
            quicksort(arr, low, p - 1);            // Fixed arr[] to arr
            quicksort(arr, p + 1, high);           // Fixed Arr to arr
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];
        System.out.print("Enter the elements: ");
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        quicksort(arr, 0, n - 1); // Fixed arr[] to arr

        System.out.print("Sorted array: ");
        for (int i = 0; i < n; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
}
