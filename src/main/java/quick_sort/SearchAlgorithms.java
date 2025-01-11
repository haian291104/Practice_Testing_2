package quick_sort;

import java.util.*;

public class SearchAlgorithms {
    public static int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) return mid;
            else if (array[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
