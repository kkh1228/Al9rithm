import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coins = new int[n];

        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt() * -1;
        } 

        Arrays.sort(coins);

        int ans = 0;
        int idx = 0;

        while(k > 0){
            
            ans += k / (coins[idx] * -1);
            k %= (coins[idx] * -1);
            idx++;
        }

        System.out.println(ans);

    }
}