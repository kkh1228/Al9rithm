import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1389 {
   static ArrayList<Integer>[] graph;
   static int[] visited;
   static int N,E;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        graph = new ArrayList[N+1];

        for(int i =1; i<=N; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i<=E; i++)
        {
            st = new StringTokenizer(br.readLine());
           int start = Integer.parseInt(st.nextToken());
           int end = Integer.parseInt(st.nextToken());
           graph[start].add(end);
           graph[end].add(start);
        }

        solution();

    }

    private static void solution() {
        int min = 987654321;
        int minIndex = 0;

        for(int i = 1; i<=N; i++){
            int cnt = bfs(i);
            if(min > cnt){
                min = cnt;
                minIndex = i;
            }
        }
        System.out.println(minIndex);
    }

    private static int bfs(int start) {
        //visited 배열에 다 -1로 채우기
        Arrays.fill(visited,-1);
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int next : graph[node]){
                if(visited[next] != -1) continue;
                visited[next] = visited[node] + 1;
                cnt += visited[next];
                queue.add(next);
            }
        }
        return cnt;
    }
}
