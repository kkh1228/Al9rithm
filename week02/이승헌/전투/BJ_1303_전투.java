package al9rithm.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BJ_1303_전투 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]); // 가로
        int N = Integer.parseInt(input[1]); // 세로

        String[][] map = new String[N][M];

        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j];
            }
        }

        int[] ans = new int[2];

        boolean[][] visited = new boolean[N][M]; // 방문 확인 배열
        Queue<Pos> que = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) continue;

                que.add(new Pos(i, j, map[i][j]));
                visited[i][j] = true;

                int cnt = 0;
                String curTeam = map[i][j]; // 현재 탐색하고 있는 팀을 확인
                while(!que.isEmpty()) { // BFS 탐색을 통해 팀이 얼마나 모여있는지 확인

                    Pos p = que.poll();
                    cnt++;
                    for(int k = 0; k < 4; k++) {
                        int x = p.x + dx[k];
                        int y = p.y + dy[k];

                        if(x <0 || y <0 || x >= N || y >= M || visited[x][y] || !map[x][y].equals(p.team)) continue;

                        que.add(new Pos(x, y, map[x][y]));
                        visited[x][y] = true;
                    }

                }

                if(curTeam.equals("W")){ // 전투력 계산
                    ans[0] += cnt*cnt;
                }else{
                    ans[1] += cnt*cnt;
                }

            }
        }

        System.out.println(ans[0] +" "+ans[1]);

    }

    private static class Pos{
        int x, y;
        String team;
        public Pos(int x, int y, String team) {
            this.x = x;
            this.y = y;
            this.team = team;
        }
    }
}
