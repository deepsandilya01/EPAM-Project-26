import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        int[] dist = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Arrays.fill(dist, -1);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        dist[1] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[current] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] != -1 && dist[i] <= d) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}