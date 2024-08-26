import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking the size of the array as input from the user
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        // Taking the elements of the array as input from the user
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Sorting the array to ensure binary search can be applied
        Arrays.sort(arr);

        // Taking the target element as input from the user
        System.out.print("Enter the target element to search: ");
        int target = sc.nextInt();

        // Performing binary search
        int index = binarySearch(arr, target);

        // Displaying the result
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found in the array.");
        }

        sc.close();
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is at the mid position
            if (arr[mid] == target) {
                return mid;
            }

            // If the target is greater than the mid element, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            } 
            // If the target is smaller than the mid element, ignore the right half
            else {
                right = mid - 1;
            }
        }
        return -1; // Return -1 if the target element is not found
    }
}
