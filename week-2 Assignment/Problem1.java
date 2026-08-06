import java.util.*;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long k = sc.nextLong();
        
        long[] keys = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            keys[i] = sc.nextLong();
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        
        Queue<long[]> queue = new LinkedList<>();
        queue.add(new long[]{1, keys[1]});
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            long[] current = queue.poll();
            int node = (int) current[0];
            long currentXor = current[1];
            
            if (currentXor >= k) {
                count++;
            }
            
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    long newXor = currentXor ^ keys[neighbor];
                    queue.add(new long[]{neighbor, newXor});
                }
            }
        }
        
        System.out.println(count);
    }
}