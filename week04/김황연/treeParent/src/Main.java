import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visit;
    static ArrayList<Integer>[] list;
    static int[] parent;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        list = new ArrayList[N+1];
        for(int i = 0; i<N+1; i++){
            list[i] = new ArrayList<>();
        }

        visit = new boolean[N+1];
        for(int i = 1; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            list[t].add(x);
            list[x].add(t);
        }
        dfs(1);
        for(int i = 2; i<N+1; i++){
            System.out.println(parent[i]);
        }


    }
    static void dfs(int bood)
    {
        visit[bood] = true;
        for(int i : list[bood])
            if(!visit[i]) {
                parent[i] = bood;
                dfs(i);
            }
    }
}
