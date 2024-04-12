package al9rithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_16439_치킨치킨치킨 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[][] score = new int[N][M];

        for(int i = 0; i < N; i++) {
            score[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int ans = 0;

        for(int a = 0; a < M; a++){
            for(int b = 0; b < M; b++){
                if(a == b)
                    continue;
                for(int c = 0 ; c < M ; c++){
                    if(b == c || a == c) continue;
                    int sum = 0;
                    for(int i = 0; i < N; i++){
                        sum += Math.max(Math.max(score[i][c], score[i][b]), score[i][a]);
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }

        System.out.println(ans);
    }
}
