import java.util.*;

class Dijkstra {
    static class Edge {
        int target, weight;

        Edge(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }

    static void dijkstra(Map<Integer, List<Edge>> graph, int source) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{source, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int distance = current[1];

            if (distance > dist[node]) continue;

            for (Edge edge : graph.get(node)) {
                int newDist = dist[node] + edge.weight;
                if (newDist < dist[edge.target]) {
                    dist[edge.target] = newDist;
                    pq.add(new int[]{edge.target, newDist});
                }
            }
        }

        // Output results
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < dist.length; i++) {
            System.out.println("To node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        // Create graph
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < 4; i++) graph.put(i, new ArrayList<>());

        graph.get(0).add(new Edge(1, 4)); // A -> B
        graph.get(0).add(new Edge(2, 2)); // A -> C
        graph.get(1).add(new Edge(2, 1)); // B -> C
        graph.get(1).add(new Edge(3, 6)); // B -> D
        graph.get(2).add(new Edge(3, 5)); // C -> D

        dijkstra(graph, 0); // Source is node 0 (A)
    }
}

