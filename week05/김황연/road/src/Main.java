import java.util.*;
import java.io.*;
//1520 Gold3 내리막길 문제 DP
public class Main {
    static int[][] arr; //지도
    static int[][] visit; //방문했는지
    static int[] upmove = {-1,1,0,0}; //위아래 이동
    static int[] rnmove = {0,0,-1,1}; // 양옆으로 이동
    static int N,M,V; // N=행 M=열 V=경로의 수
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        arr= new int[N][M];
        visit = new int[N][M];
        for(int i=0; i<N; i++) {
            StringTokenizer ss = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {

                arr[i][j] = Integer.parseInt(ss.nextToken());
                visit[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
    }
    static int dfs(int A, int B)
    {
       if(A == N-1 && B == M-1)
           return 1;
       if(visit[A][B]==-1)
       {
           visit[A][B]=0;
           for(int i = 0; i<4; i++) {
               int nA = A + upmove[i];
               int nB = B + rnmove[i];
               if(nA<0 || nA>N-1 || nB<0 || nB>M-1)
                   continue;
               if(arr[A][B]>arr[nA][nB])
                   visit[A][B] += dfs(nA, nB);

           }
       }
    return visit[A][B];
    }
}
//값-1로 시작해서 방문한곳은 0으로 바꾸며 최종도착지일경우 1을 더해주면서 이때까지 방문한곳을 1로 바꿔주기
// 시작하는데 dfs 특성상 덜끝난곳에서 다시 상하좌우중 조건에 맞지만 이동하지 않은곳으로
// 이동해야하는데 이미 방문한 길일경우 목적지까지 이어진 길이 있기때문에 더이상 계산할 필요가 없어서
//도착했다는 뜻인 1의 값을 dfs 시작한곳으로 더해주며 그값을 제일 처음 시작지점까지 올라간다. 도중에
// 또다시 조건을 만족하며 이동하지 않은곳이 남아있다면 위의 상황을 반복하면 최종결과가 dfs(0,0)에 기록된다.
