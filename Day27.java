import java.util.*;

public class ShortestPathUnweighted {
    static List<List<Integer>> adj;

    static int bfs(int start, int end, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    q.offer(neighbor);
                    if (neighbor == end) return dist[neighbor];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();
        System.out.println("Enter number of edges:");
        int E = sc.nextInt();

        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        System.out.println("Enter start and end node:");
        int start = sc.nextInt();
        int end = sc.nextInt();

        int result = bfs(start, end, V);
        System.out.println(result);

        sc.close();
    }
}
