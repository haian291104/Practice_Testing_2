import org.junit.jupiter.api.Test;
import quick_sort.GraphAlgorithms;
import quick_sort.SearchAlgorithms;
import quick_sort.SortingAlgorithms;
import quick_sort.StringUtils;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmTests {

    // ===== TEST FOR QUICK SORT =====
    @Test
    void testQuickSortEmptyArray() {
        int[] array = {};
        SortingAlgorithms.quickSort(array, 0, array.length - 1);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    void testQuickSortSingleElement() {
        int[] array = {5};
        SortingAlgorithms.quickSort(array, 0, array.length - 1);
        assertArrayEquals(new int[]{5}, array);
    }

    @Test
    void testQuickSortDescendingArray() {
        int[] array = {5, 4, 3, 2, 1};
        SortingAlgorithms.quickSort(array, 0, array.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    void testQuickSortWithDuplicates() {
        int[] array = {4, 2, 4, 2, 4};
        SortingAlgorithms.quickSort(array, 0, array.length - 1);
        assertArrayEquals(new int[]{2, 2, 4, 4, 4}, array);
    }

    @Test
    void testQuickSortLargeArray() {
        int[] array = new int[1000];
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            array[i] = rand.nextInt(10000);
        }
        int[] expected = array.clone();
        Arrays.sort(expected);
        SortingAlgorithms.quickSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    // ===== TEST FOR BINARY SEARCH =====
    @Test
    void testBinarySearchEmptyArray() {
        int[] array = {};
        assertEquals(-1, SearchAlgorithms.binarySearch(array, 10));
    }

    @Test
    void testBinarySearchElementAtStart() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(0, SearchAlgorithms.binarySearch(array, 1));
    }

    @Test
    void testBinarySearchElementAtMiddle() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(2, SearchAlgorithms.binarySearch(array, 3));
    }

    @Test
    void testBinarySearchElementNotFound() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(-1, SearchAlgorithms.binarySearch(array, 6));
    }

    @Test
    void testBinarySearchWithNegativeNumbers() {
        int[] array = {-10, -5, 0, 5, 10};
        assertEquals(1, SearchAlgorithms.binarySearch(array, -5));
    }

    // ===== TEST FOR PALINDROME =====
    @Test
    void testPalindromeEmptyOrNull() {
        assertFalse(StringUtils.isPalindrome(""));
        assertFalse(StringUtils.isPalindrome(null));
    }

    @Test
    void testPalindromeSingleCharacter() {
        assertTrue(StringUtils.isPalindrome("a"));
    }

    @Test
    void testPalindromeEvenLength() {
        assertTrue(StringUtils.isPalindrome("abba"));
    }

    @Test
    void testPalindromeOddLength() {
        assertTrue(StringUtils.isPalindrome("racecar"));
    }

    @Test
    void testPalindromeNotPalindrome() {
        assertFalse(StringUtils.isPalindrome("hello"));
    }

    // ===== TEST FOR DIJKSTRA =====
    @Test
    void testDijkstraEmptyGraph() {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        assertTrue(GraphAlgorithms.dijkstra(graph, 0).isEmpty());
    }

    @Test
    void testDijkstraSingleNodeGraph() {
        Map<Integer, List<int[]>> graph = Map.of(0, new ArrayList<>());
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0), result);  // Đảm bảo kết quả trả về cho đồ thị đơn
    }

    @Test
    void testDijkstraWithDisconnectedGraph() {
        Map<Integer, List<int[]>> graph = Map.of(
                0, List.of(),  // Đỉnh 0 không có kết nối
                1, List.of()   // Đỉnh 1 không có kết nối
        );
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0), result);  // Kết quả chỉ trả về 0 cho đỉnh 0
    }

    @Test
    void testDijkstraWithCycle() {
        Map<Integer, List<int[]>> graph = Map.of(
                0, List.of(new int[]{1, 1}),
                1, List.of(new int[]{2, 1}),
                2, List.of(new int[]{0, 1})  // Chu trình: 0 -> 1 -> 2 -> 0
        );
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0, 1, 1, 2, 2), result);  // Đảm bảo kết quả đúng với đồ thị có chu trình
    }

    @Test
    void testDijkstraWithMultiplePathsAndDifferentWeights() {
        Map<Integer, List<int[]>> graph = Map.of(
                0, List.of(new int[]{1, 4}, new int[]{2, 2}),
                1, List.of(new int[]{2, 5}),
                2, List.of(new int[]{3, 1}),
                3, List.of()
        );
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0, 1, 4, 2, 2, 3, 3), result);  // Đảm bảo các đường đi tối ưu được chọn
    }

    @Test
    void testDijkstraWithNoPathFromSourceToDestination() {
        Map<Integer, List<int[]>> graph = Map.of(
                0, List.of(new int[]{1, 3}),
                1, List.of(new int[]{2, 2}),
                2, List.of(),  // Đỉnh 2 không có kết nối ra ngoài
                3, List.of()
        );
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0, 1, 3, 2, Integer.MAX_VALUE), result);  // Đảm bảo đỉnh 2 không có đường đi
    }

    @Test
    void testDijkstraWithNegativeWeights() {
        Map<Integer, List<int[]>> graph = Map.of(
                0, List.of(new int[]{1, -5}),
                1, List.of(new int[]{2, 3}),
                2, List.of()
        );
        try {
            GraphAlgorithms.dijkstra(graph, 0);
            fail("Expected IllegalArgumentException due to negative weights");
        } catch (IllegalArgumentException e) {
            assertEquals("Graph contains negative weight edges", e.getMessage());  // Kiểm tra thông báo ngoại lệ
        }
    }

    @Test
    void testDijkstraWithLargeGraph() {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < 1000; i++) {
            graph.put(i, new ArrayList<>());
        }
        graph.get(0).add(new int[]{1, 1});
        graph.get(1).add(new int[]{2, 1});
        graph.get(2).add(new int[]{3, 1});
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0, 1, 1, 2, 2, 3, 3), result);  // Đảm bảo đồ thị lớn không gặp vấn đề hiệu suất
    }

    @Test
    void testDijkstraWithMultipleEdges() {
        Map<Integer, List<int[]>> graph = Map.of(
                0, List.of(new int[]{1, 10}, new int[]{2, 5}),
                1, List.of(new int[]{3, 1}),
                2, List.of(new int[]{1, 2}, new int[]{3, 9}),
                3, List.of()
        );
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0, 1, 7, 2, 5, 3, 8), result);  // Đảm bảo kết quả tính toán đúng với trọng số
    }

    @Test
    void testDijkstraWithSingleEdge() {
        Map<Integer, List<int[]>> graph = Map.of(
                0, List.of(new int[]{1, 3}),
                1, List.of()
        );
        Map<Integer, Integer> result = GraphAlgorithms.dijkstra(graph, 0);
        assertEquals(Map.of(0, 0, 1, 3), result);  // Đảm bảo chỉ có một đường đi từ 0 -> 1
    }
}