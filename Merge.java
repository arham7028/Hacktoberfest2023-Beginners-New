public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return; // The array is already sorted or empty
        }
        
        int n = arr.length;
        int[] temp = new int[n]; // Temporary array for merging
        
        mergeSortRecursive(arr, temp, 0, n - 1);
    }
    
    private static void mergeSortRecursive(int[] arr, int[] temp, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            mergeSortRecursive(arr, temp, left, mid); // Sort the left half
            mergeSortRecursive(arr, temp, mid + 1, right); // Sort the right half

            merge(arr, temp, left, mid, right); // Merge the two sorted halves
        }
    }
    
    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        // Copy data to temporary arrays L[] and R[]
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left; // Initial index of the left subarray
        int j = mid + 1; // Initial index of the right subarray
        int k = left; // Initial index of the merged subarray

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }

        // Copy the remaining elements of R[], if any
        while (j <= right) {
            arr[k] = temp[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(arr));

        mergeSort(arr);

        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
}
