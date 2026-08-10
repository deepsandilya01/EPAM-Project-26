import java.util.*;

public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] points = new int[n];
        for (int i = 0; i < n; i++) {
            points[i] = sc.nextInt();
        }
        
        if (n == 1) {
            System.out.println(points[0]);
            return;
        }
        
        long[] dp = new long[n];
        dp[0] = points[0];
        dp[1] = Math.max(points[0], points[1]);
        
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + points[i]);
        }
        
        System.out.println(dp[n-1]);
    }
}