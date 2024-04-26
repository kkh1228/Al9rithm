package al9rithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeTree_정수n개의합3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] sum = new int[n+1][n+1];
        int[][] square = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            input = br.readLine().split(" ");
            for(int j = 1; j <= n; j++){
                square[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <=n; j++){
                sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + square[i][j];
            }
        }

        int max = 0;

        for(int i = k; i <= n; i++){
            for(int j = k; j <=n; j++){
                max = Math.max(max, sum[i][j] - sum[i-k][j] - sum[i][j-k] + sum[i-k][j-k]);
            }
        }

        System.out.println(max);

    }
}
