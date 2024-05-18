package al9rithm.week7;

import java.util.Scanner;

public class CodeTree_2차원최대증가수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                map[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m - 1; j++){
                if(dp[i][j] == 0)
                    continue;
                for(int x = i+1; x < n; x++){
                    for(int y = j+1; y < m; y++){
                        if(map[x][y] > map[i][j])
                            dp[x][y] = Math.max(dp[x][y], dp[i][j] + 1);
                    }
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                //System.out.print(dp[i][j]+" ");
                max  = Math.max(max, dp[i][j]);
            }
            //System.out.println();
        }

        System.out.println(max);

    }
}
