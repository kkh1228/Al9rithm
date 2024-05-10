package al9rithm.week6;

import java.util.*;

public class CodeTree_십자모양의지속적폭발 {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < m; i++){

            int idx = sc.nextInt() - 1;

            for(int j = 0; j < n; j++){
                if(map[j][idx] != 0){
                    simulation(j, idx);
                    break;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }


    }

    private static void simulation(int x, int y){
        //System.out.println(x + " , " + y);
        int range = map[x][y];

        map[x][y] = 0;

        for(int i = 0; i < 4; i++){

            int cx = x;
            int cy = y;

            for(int j = 0; j < range - 1; j++){

                cx += dx[i];
                cy += dy[i];

                if(cx < 0 || cx >= n || cy < 0 || cy >= n)
                    continue;

                map[cx][cy] = 0;
            }
        }

        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         System.out.print(map[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // System.out.println();

        int [][] temp = new int[n][n];

        Queue<Integer> que = new ArrayDeque<>();

        for(int i = 0; i < n; i++){


            for(int j = n-1; j >= 0; j--){
                if(map[j][i] != 0)
                    que.add(map[j][i]);
            }

            for(int j = n-1; j >= 0; j--){
                if(que.isEmpty())
                    break;
                temp[j][i] = que.poll();
            }
        }

        copy(temp);
    }

    private static void copy(int[][] temp){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                map[i][j] = temp[i][j];
            }
        }
    }
}
