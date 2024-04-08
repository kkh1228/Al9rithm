import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int rain;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] =Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for(int R = 0; R< 100; R++){
            rain = R;
            visited = new boolean[N][N];
            int count = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][j] > rain && !visited[i][j]) {
                        dfs(i, j, rain);
                        count++;
                    }
                }
            }
            max = Math.max(max, count);
        }


        System.out.println(max);


    }

    private static void dfs(int x, int y, int rain) {
        if (x < 0 || y < 0 || x >= N || y >= N || graph[x][y] <= rain || visited[x][y]) {
            return ;
        }
        visited[x][y] = true;
        for(int i = 0; i<4; i++){
            dfs(x+dx[i],y+dy[i],rain);
        }

    }

}
