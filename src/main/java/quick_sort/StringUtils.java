package quick_sort;

import java.util.*;

public class StringUtils {
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) return false;
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
