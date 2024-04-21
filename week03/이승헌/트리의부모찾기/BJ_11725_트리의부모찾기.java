package al9rithm.week3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ_11725_트리의부모찾기 {
    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;

        int N = Integer.parseInt(br.readLine());


        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        parents = new int[N+1];
        for(int i=1; i<=N; i++){
            graph[i] = new ArrayList();
        }

        for(int i=1; i<N; i++){
            input = br.readLine().split(" ");
            int p = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            graph[p].add(c);
            graph[c].add(p);
        }

        dfs(1, 1);

        for(int i=2; i<=N; i++){
            sb.append(parents[i]).append("\n");
        }
        System.out.println(sb);
    }

    static private void dfs(int parent, int cur){
        parents[cur] = parent;
        visited[cur] = true;

        for(int next : graph[cur]){
            if(visited[next])
                continue;
            dfs(cur, next);
        }
    }


}
