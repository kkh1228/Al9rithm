package al9rithm.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1520_내리막길 {

    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int n, m;
    static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new int[n][m];
        dp = new int[n][m]; // (x, y) -> (n-1, m-1 ) 로 갈 수 있는 경로의 수

        for(int i = 0; i < n; i++){
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for(int i = 0; i < n; i++){  // 도달하지 못하는 점을 구분하기 위해 모든 dp 점을 -1 로 초기화
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0));


    }

    static int dfs(int x, int y){


        if(x == n - 1 && y == m - 1){ // 도착지점이라면 1 반환
            return 1;
        }

        if(dp[x][y] != -1){ // 한번 도달했던 경로라면 바로 경로 개수만 반환
            return dp[x][y];
        }

        dp[x][y] = 0;  // 현재 위치가 도달 가능한 점이기 때문에 0 으로 초기화

        for(int i = 0; i < 4; i++){

            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx < 0 || cx >= n || cy < 0 || cy >= m) continue;
            if(map[cx][cy] < map[x][y]){ // 높이가 더 낮다면

                dp[x][y] += dfs(cx, cy);  // dp[x][y] 에  (dx, dy ) -> (n -1, m-1 ) 까지 갈 수 있는 경로의 수를 더해줌
            }
        }

        return dp[x][y];
    }

}
