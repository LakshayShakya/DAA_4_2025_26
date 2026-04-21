import java.util.*;

class Edge {
    int destination;
    int weight;

    Edge(int dest, int wt) {
        this.destination = dest;
        this.weight = wt;
    }
}

class Pair implements Comparable<Pair> {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }

    public int compareTo(Pair other) {
        return this.distance - other.distance;
    }
}

public class project {

    static ArrayList<Edge>[] graph;
    static int V;

    public static void dijkstra(int src) {
        int[] dist = new int[V];
        int[] parent = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        dist[src] = 0;
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;

            for (Edge e : graph[u]) {
                int v = e.destination;
                int weight = e.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    parent[v] = u;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + dist[i]);
        }

        printPath(parent, V - 1);
    }

    public static void printPath(int[] parent, int node) {
        if (node == -1) return;
        printPath(parent, parent[node]);
        System.out.print(node + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        int E = sc.nextInt();

        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        int src = sc.nextInt();
        dijkstra(src);
    }
}