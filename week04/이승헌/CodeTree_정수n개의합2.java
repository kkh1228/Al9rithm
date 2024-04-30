package al9rithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeTree_정수n개의합2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] sum = new int[n+1];

        input = br.readLine().split(" ");


        for(int i = 0; i < n; i++){
            sum[i+1] = Integer.parseInt(input[i]) + sum[i];
        }

        int max = 0;

        for(int i = k; i <= n; i++){
            max = Math.max(max , sum[i] - sum[i-k]);
        }

        System.out.println(max);


    }
}
