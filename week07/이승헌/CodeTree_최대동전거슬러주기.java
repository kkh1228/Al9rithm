package al9rithm.week7;

import java.util.Arrays;
import java.util.Scanner;

public class CodeTree_최대동전거슬러주기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coins = new int[n];
        int[] dp = new int[10001];

        for(int i = 0; i < n; i++){
            coins[i] = sc.nextInt();
        }

        Arrays.fill(dp, -1);

        for(Integer c : coins){
            dp[c] = 1;
        }

        for(int i = 1; i <= 10000; i++){

            for(int j = 0; j < n; j++){
                if(i-coins[j] < 1 || dp[i-coins[j]] == -1) continue;

                dp[i] = Math.max(dp[i] , dp[i-coins[j]] + 1);
            }
        }

        System.out.println(dp[m]);

    }
}
