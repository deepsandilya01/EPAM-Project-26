import java.util.*;

public class problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        long b = sc.nextLong();
        
        long[] demands = new long[n];
        for (int i = 0; i < n; i++) {
            demands[i] = sc.nextLong();
        }
        
        Arrays.sort(demands);
        
        long remainingBudget = b;
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (demands[i] <= remainingBudget) {
                remainingBudget -= demands[i];
                count++;
            } else {
                break;
            }
        }
        
        System.out.println(count);
    }
}
