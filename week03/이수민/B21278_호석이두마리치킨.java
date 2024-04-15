import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21278_호석이두마리치킨 {
    static int N, M;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N+1][N+1];

        // 최단 시간 배열 초기화
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                if(i == j) continue;
                distance[i][j] = 1_000_000_000;
            }
        }

        // 두 건물을 이동하는데 걸리는 시간은 1시간이며, 양방향 도로이므로 두 건물 사이의 시간을 1로 설정
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            distance[a][b] = 1;
            distance[b][a] = 1;
        }

        // 플로이드-워셜을 통해 모든 건물에 대한 최단 시간 계산
        floyd();

        int result = Integer.MAX_VALUE;
        int store1 = 0;
        int store2 = 0;

        for(int i=1; i<N; i++) {
            for(int j=i+1; j<N+1; j++) {
                int temp = 0; // i 건물과 j 건물에 치킨집을 열었을 때 최단 시간 저장

                for(int k=1; k<N+1; k++) {
                    if(i == k || j == k) continue;

                    // k 건물에서 i 건물과 j 건물 중 더 가까운 곳을 선택하여 시간 누적
                    temp += Math.min(distance[i][k], distance[j][k]);
                }

                // 저장되어 있는 최단 시간보다 현재 계산한 시간이 더 작은 경우
                // 최단 시간 갱신 후 치킨집 위치 갱신
                if(temp < result) {
                    result = temp;
                    store1 = i;
                    store2 = j;
                }
            }
        }

        sb.append(store1).append(" ").append(store2).append(" ").append(result * 2);
        System.out.println(sb.toString());
    }

    private static void floyd() {
        for(int k=1; k<N+1; k++) { // 경유지
            for(int i=1; i<N+1; i++) { // 출발지
                for(int j=1; j<N+1; j++) { // 도착지
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }
    }
}
