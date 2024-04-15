import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1012 {
    static int[][] graph;
    static boolean[][] visited;
    static int count;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //가로
            M = Integer.parseInt(st.nextToken());
            //세로
            N = Integer.parseInt(st.nextToken());

            int cabbage = Integer.parseInt(st.nextToken());

            graph = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            for(int a=0; a<N; a++)
            {
                Arrays.fill(graph[a],0);
            }


            for(int j = 0; j<cabbage; j++)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[y][x] = 1;
            }

            for(int a=0; a<N; a++){
                for(int b=0; b<M; b++)
                {
                    if(dfs(a,b)){
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static boolean dfs(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M || visited[x][y] || graph[x][y] == 0) return false;

        visited[x][y] = true;

        for(int i = 0; i<4; i++)
        {
            dfs(x+dx[i],y+dy[i]);
        }

        return true;
    }
}
