package al9rithm.week2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2583_영역구하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, 1, 0, -1};

        input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[][] map = new int[M][N];

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < K; i++){
            input = br.readLine().split(" ");
            int y1 = Integer.parseInt(input[0]);
            int x1 = Integer.parseInt(input[1]);
            int y2 = Integer.parseInt(input[2]);
            int x2 = Integer.parseInt(input[3]);

            for(int a = x1; a < x2; a++){
                for(int b = y1; b < y2; b++){
                    map[a][b] = 1;
                }
            }
        }

        Queue<Pos> que = new ArrayDeque<>();

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    que.add(new Pos(i, j));
                    int cnt = 0;
                    while (!que.isEmpty()){

                        Pos p = que.poll();
                        cnt++;

                        for(int k = 0; k < 4; k++){
                            int cx = p.x + dx[k];
                            int cy = p.y + dy[k];
                            if(cx < 0 || cx >= M || cy < 0 || cy >= N || map[cx][cy] == 1){
                                continue;
                            }

                            que.add(new Pos(cx, cy));
                            map[cx][cy] = 1;
                        }
                    }

                    pq.add(cnt);

                }
            }
        }

        System.out.println(pq.size());
        while (!pq.isEmpty()){
            System.out.print(pq.poll()+" ");
        }
    }

    private static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
