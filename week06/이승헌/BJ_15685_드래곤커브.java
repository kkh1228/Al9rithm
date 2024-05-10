package al9rithm.week6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_15685_드래곤커브 {

    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        map = new int[101][101]; // 크기 100 x 100

        for(int tc = 0; tc < n; tc++){

            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt(); // 0 오른쪽, 1 위쪽 , 2 왼쪽 , 3 아래쪽
            int g = sc.nextInt();

            drawDragon(x, y, findDirection(d, g));

        }

        int ans = 0;

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(map[i][j] == 1 && map[i+1][j] == 1 && map[i+1][j+1] == 1 && map[i][j+1] == 1){
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }

    private static List<Integer> findDirection(int d, int g) { // 현재 세대까지의 방향을 찾는 함수

        List<Integer> list = new ArrayList<>();
        list.add(d);
        // 새롭게 생성되는 커브는 원래 있던 커브가 90도 시계방향으로 회전한 것
        // 즉 원래 커브의 처음점 부터 끝점까지 선분이 나아가는 방향을 역순으로 90 도 회전한 방향이 새롭게 생길 커브의 시작점부터 끝점까지의 선분의 나아가는 방향이다
        for(int i = 0; i < g; i++){
            for(int j = list.size() - 1; j >= 0; j--){
                list.add((list.get(j) + 1)%4);
            }
        }

        return list;
    }

    private static void drawDragon(int x, int y, List<Integer> directions){ // x -> x축 좌표, y -> y축 좌표
        map[x][y] = 1;

        for (int direction : directions) {
            switch (direction) {
                case 0: // 오른쪽
                    map[++x][y] = 1;
                    break;
                case 1:  // 위쪽
                    map[x][--y] = 1;
                    break;
                case 2: // 왼쪽
                    map[--x][y] = 1;
                    break;
                case 3: // 아래쪽
                    map[x][++y] = 1;
                    break;
            }
        }
    }

}
