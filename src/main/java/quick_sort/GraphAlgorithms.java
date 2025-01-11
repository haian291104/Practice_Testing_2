package quick_sort;

import java.util.*;

public class GraphAlgorithms {

    public static Map<Integer, Integer> dijkstra(Map<Integer, List<int[]>> graph, int start) {
        // Kiểm tra nếu đồ thị là rỗng
        if (graph == null || graph.isEmpty()) {
            return Collections.emptyMap();
        }

        // Kiểm tra trọng số âm trong đồ thị
        for (Map.Entry<Integer, List<int[]>> entry : graph.entrySet()) {
            for (int[] edge : entry.getValue()) {
                if (edge[1] < 0) {
                    throw new IllegalArgumentException("Graph contains negative weight edges");
                }
            }
        }

        Map<Integer, Integer> distances = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1])); // [node, distance]

        distances.put(start, 0);
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentNode = current[0];
            int currentDistance = current[1];

            if (visited.contains(currentNode)) {
                continue;
            }
            visited.add(currentNode);

            // Duyệt các đỉnh kề
            if (graph.containsKey(currentNode)) {
                for (int[] neighbor : graph.get(currentNode)) {
                    int neighborNode = neighbor[0];
                    int edgeWeight = neighbor[1];
                    int newDist = currentDistance + edgeWeight;

                    if (!visited.contains(neighborNode) && (distances.get(neighborNode) == null || newDist < distances.get(neighborNode))) {
                        distances.put(neighborNode, newDist);
                        pq.offer(new int[]{neighborNode, newDist});
                    }
                }
            }
        }

        return distances;
    }
}
