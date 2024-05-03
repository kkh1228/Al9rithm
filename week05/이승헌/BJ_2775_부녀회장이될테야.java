package al9rithm.week5;

import java.util.Scanner;

public class BJ_2775_부녀회장이될테야 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int tc = 0; tc < T; tc++){

            int k = sc.nextInt();
            int n = sc.nextInt();

            int[][] dp = new int[k+1][n+1];

            for(int i = 0; i < n + 1; i++){
                dp[0][i] = i;
            }

            for(int i = 1; i <= k; i++){
                for(int j = 1; j <= n; j++){
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }

            sb.append(dp[k][n]).append("\n");
        }

        System.out.println(sb);
    }
}
