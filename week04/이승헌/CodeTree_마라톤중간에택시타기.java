package al9rithm.week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CodeTree_마라톤중간에택시타기 {
    public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input;

    int N = Integer.parseInt(br.readLine());

    int[][] checkPoint = new int[N][2];

    for(int i = 0; i < N; i++){
        input = br.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        checkPoint[i][0] = x;
        checkPoint[i][1] = y;

    }

    int[] left = new int[N];
    int[] right = new int[N];

    for(int i = 1; i < N; i++){
        left[i] = Math.abs(checkPoint[i][0] - checkPoint[i-1][0]) + Math.abs(checkPoint[i][1] - checkPoint[i-1][1]) + left[i-1];
    }

    for(int i = N-2; i >= 0; i--){
        right[i] = Math.abs(checkPoint[i][0] - checkPoint[i+1][0]) + Math.abs(checkPoint[i][1] - checkPoint[i+1][1]) + right[i+1];
    }


    int min = Integer.MAX_VALUE;

    for(int i = 1; i < N-1; i++){

        min = Math.min(min, left[i-1] + right[i+1] + Math.abs(checkPoint[i+1][0] - checkPoint[i-1][0]) + Math.abs(checkPoint[i+1][1] - checkPoint[i-1][1]));

    }

    System.out.println(min);


}
}
