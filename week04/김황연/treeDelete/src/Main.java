import java.util.*;
import java.io.*;

public class Main {
    static  int N,M,ans;
    static  int arr;
    static boolean[] visit;
    static  int[] parent;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        parent = new int[N+1];
        visit = new boolean[N+1];

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1;
        for(int i=0; i<N; i++){
            arr = Integer.parseInt(st.nextToken());
            if(arr == -1)
            {
                root = i;
            }
            else{
                graph[i].add(arr);
                graph[arr].add(i);
            }
        }

        M = Integer.parseInt(br.readLine());
        if(M==root)
        {
            System.out.println(0);
            return;
        }
        else tree(root);
        System.out.println(ans);
    }
    static void tree(int rt){
        visit[rt] = true;
        int nodes = 0;
        for( int sd : graph[rt]) {
            if( sd != M && !visit[sd] )
            {
                nodes++;
                tree(sd);
            }
        }
        if(nodes == 0)
            ans++;

    }
}
