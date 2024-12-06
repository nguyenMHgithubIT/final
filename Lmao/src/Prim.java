import java.util.*;

class Prim {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static void prim(Map<Integer, List<Edge>> graph) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.size()];
        List<Edge> mst = new ArrayList<>();
        int totalWeight = 0;

        // Start from node 0 (A)
        visited[0] = true;
        pq.addAll(graph.get(0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();

            if (visited[edge.dest]) continue;

            visited[edge.dest] = true;
            mst.add(edge);
            totalWeight += edge.weight;

            for (Edge next : graph.get(edge.dest)) {
                if (!visited[next.dest]) pq.add(next);
            }
        }

        // Output results
        System.out.println("Edges in Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("From " + edge.src + " to " + edge.dest + " (Weight: " + edge.weight + ")");
        }
        System.out.println("Total weight: " + totalWeight);
    }

    public static void main(String[] args) {
        // Create graph
        Map<Integer, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < 4; i++) graph.put(i, new ArrayList<>());

        graph.get(0).add(new Edge(0, 1, 4)); // A -> B
        graph.get(0).add(new Edge(0, 2, 2)); // A -> C
        graph.get(1).add(new Edge(1, 2, 1)); // B -> C
        graph.get(1).add(new Edge(1, 3, 6)); // B -> D
        graph.get(2).add(new Edge(2, 3, 5)); // C -> D

        prim(graph);
    }
}

