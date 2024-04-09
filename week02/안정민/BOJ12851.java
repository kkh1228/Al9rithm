import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
    static int[] visited =  new int[100001];
    static int N,K;
    static int count = 0;
    static int minTime = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //동생이 뒤에 있을 때
        if(N >= K){
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs(N);

        System.out.println(minTime + "\n" + count);

    }

    private static void bfs(int n) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        visited[n] = 1;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(int i =0; i< 3; i++)
            {
                int next;

                if (i == 0) {
                    next = now + 1;
                }
                else if(i==1)
                {
                    next = now - 1;

                }
                else{
                    next = now * 2;
                }

                if(next < 0 || next > 100000){
                    continue;
                }

                // 첫 방문이거나 최단 시간에 도달한 경우
                if(visited[next]==0 || visited[next] == visited[now] + 1 ){
                    queue.add(next);
                    visited[next] = visited[now] + 1;

                    //최단 시간에 동생에게 도착한 경우
                    if(next == K)
                    {
                        count++;
                        minTime = visited[now];
                    }
                }
            }
        }

    }
}
