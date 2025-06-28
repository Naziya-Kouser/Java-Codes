import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input 5 different numbers
        System.out.println("Enter 5 different numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Sort the array (Bubble Sort)
        bubbleSort(numbers);

        // Display sorted array
        System.out.print("Sorted Array: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // Find second lowest and second highest
        int secondLowest = findSecondLowest(numbers);
        int secondHighest = findSecondHighest(numbers);

        System.out.println("\nSecond Lowest Number: " + secondLowest);
        System.out.println("Second Highest Number: " + secondHighest);

        scanner.close();
    }

    // Bubble sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
    }

    // Find second lowest
    public static int findSecondLowest(int[] arr) {
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != first) {
                return arr[i];
            }
        }
        return -1; // In case all elements are same
    }

    // Find second highest
    public static int findSecondHighest(int[] arr) {
        int last = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != last) {
                return arr[i];
            }
        }
        return -1; // In case all elements are same
    }
}
