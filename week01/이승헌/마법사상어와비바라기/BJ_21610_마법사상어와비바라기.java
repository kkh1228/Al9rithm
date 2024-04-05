package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BJ_21610_마법사상어와비바라기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}; // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        List<Cloud> list = new ArrayList<>();
        list.add(new Cloud(n-1, 0));
        list.add(new Cloud(n-1, 1));
        list.add(new Cloud(n-2, 0));
        list.add(new Cloud(n-2, 1));

        for (int tc = 0; tc < m; tc++) {
            input = br.readLine().split(" ");
            int dir = Integer.parseInt(input[0])-1;
            int dis = Integer.parseInt(input[1]);

            boolean[][] disappear = new boolean[n][n];

            // 1. 모든 구름이 d 방향으로 s 만듬 이동한다

            for(int i = 0; i < list.size(); i++) {
                Cloud c = list.get(i);
                int cx = c.x + dx[dir]*dis;
                int cy = c.y + dy[dir]*dis;

                if(cx < 0){
                    while (cx < 0){
                        cx = cx + n;
                    }
                }else{
                    cx = cx % n;
                }

                if(cy < 0){
                    while (cy < 0){
                        cy = cy + n;
                    }
                }else{
                    cy = cy % n;
                }

                c.setPos(cx, cy);
                list.set(i, c);
            }


            // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다
            for(Cloud c : list){
                map[c.x][c.y]++;
                disappear[c.x][c.y] = true;
            }

            // 3. 구름이 모두 사라진다
            //list.clear(); --> 물이 증가한 칸 을 쉽게 탐색하기 위해 리스트를 비우는 것을 나중으로 미룬다

            // 4. 에서 증가한 칸 r, c 에 물복사 버그 마법을 시작한다 물복사 버그 마법을 사용하면 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼
            // (r, c) 에 있는 바구니의 물의 양이 증가한다
            for(Cloud cloud : list){

                for(int i = 1; i < 8; i+=2){
                    int cx = cloud.x + dx[i];
                    int cy = cloud.y + dy[i];
                    if(cx < 0 || cy < 0 || cx >= n || cy >= n || map[cx][cy] ==0){
                        continue;
                    }
                    map[cloud.x][cloud.y]++;
                }
            }
            list.clear();

            // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고 , 물의 양이 2 줄어든다. 이 때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니여야한다
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(disappear[i][j] || map[i][j] < 2)
                        continue;
                    list.add(new Cloud(i, j));
                    map[i][j] -= 2;
                }
            }

        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    private static class Cloud {
        int x, y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setPos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

