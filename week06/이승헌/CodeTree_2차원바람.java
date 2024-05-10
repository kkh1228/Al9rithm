package al9rithm.week6;

import java.util.Scanner;

public class CodeTree_2차원바람 {

    static int N, M, Q;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        Q = sc.nextInt();

        map = new int[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < Q; i++){
            int r1 = sc.nextInt()-1;
            int c1 = sc.nextInt()-1;
            int r2 = sc.nextInt()-1;
            int c2 = sc.nextInt()-1;

            simulation(r1, c1, r2, c2);
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }


    }

    private static void simulation(int r1, int c1, int r2, int c2){

        int[][] temp = new int[N][M];
        copy(temp);

        for(int i = c1 + 1; i <= c2; i++){
            temp[r1][i] = map[r1][i-1];
        }

        for(int i = r1 + 1; i <= r2; i++){
            temp[i][c2] = map[i-1][c2];
        }

        for(int i = c2-1; i >= c1; i--){
            temp[r2][i] = map[r2][i+1];
        }

        for(int i = r2 - 1; i >= r1; i--){
            temp[i][c1] = map[i+1][c1];
        }

        for(int i = r1; i <= r2; i++){
            for(int j= c1; j <= c2; j++){

                int sum = 0;
                int cnt = 1;
                sum += temp[i][j];

                for(int k = 0; k < 4; k++){
                    int cx = i + dx[k];
                    int cy = j + dy[k];

                    if(cx < 0 || cx >= N || cy < 0 || cy >= M) continue;
                    sum += temp[cx][cy];
                    cnt++;
                }

                int avg = sum / cnt;

                map[i][j] = avg;

            }
        }


    }

    private static void copy(int[][] temp){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                temp[i][j] = map[i][j];
            }
        }
    }

}
