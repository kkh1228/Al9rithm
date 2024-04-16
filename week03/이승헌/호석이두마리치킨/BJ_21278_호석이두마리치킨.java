package al9rithm.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BJ_21278_호석이두마리치킨 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        List<Integer>[] graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] ans = new int[3];
        ans[2] = Integer.MAX_VALUE;

        for(int i = 1; i < N; i++){
            for(int j = i+1; j <= N; j++){

                boolean[] visited = new boolean[N + 1];
                Queue<Pos> que = new ArrayDeque<>();
                que.add(new Pos(i, 0));
                que.add(new Pos(j, 0));
                visited[i] = true;
                visited[j] = true;

                int cnt = 0;

                while(!que.isEmpty()){

                    Pos cur = que.poll();
                    cnt += cur.cnt*2;

                    for(Integer next : graph[cur.idx]){
                        if(visited[next])
                           continue;
                        que.add(new Pos(next, cur.cnt+1));
                        visited[next] = true;
                    }
                }

                if(cnt < ans[2]){
                    ans[2] = cnt;
                    ans[0] = i;
                    ans[1] = j;
                }

            }
        }

        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);

    }

    static class Pos{
        int idx, cnt;
        public Pos(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
