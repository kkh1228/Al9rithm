import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ21278 {
    static int N, M;
    static int[][] arr;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        selected = new boolean[N+1];

        arr = new int[N+1][N+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                arr[i][j]=101;
            }
        }

        for (int i = 0; i < M; i++) {
            String[] node = br.readLine().split(" ");
            int start = Integer.parseInt(node[0]);
            int end = Integer.parseInt(node[1]);
            arr[start][end] = 1;
            arr[end][start] = 1;
        }

        floyd();


        int minTime = 101;
        int building1 = -1, building2 = -1;


        for(int i =1; i<=N; i++)
        {

            for(int j=i+1; j<=N; j++){
                int totalDistance = 0;
                for(int k=1; k<=N; k++)
                {
                    //i가게에서 k까지의 거리와 j가게에서 k까지의 거리 중 짧은거
                    totalDistance += Math.min(arr[i][k],arr[j][k]);
                }
                if (totalDistance < minTime) {
                    minTime = totalDistance;
                    building1 = i;
                    building2 = j;
                }
            }

        }
        System.out.println(building1 + " " + building2 + " " + (2 * minTime));

    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }

                }
            }
        }
    }


}
