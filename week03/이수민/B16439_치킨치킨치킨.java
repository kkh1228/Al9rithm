import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16439_치킨치킨치킨 {
    static int N, M;
    static int max = 0;
    static int[][] values;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        values = new int[N][M];
        visited = new boolean[M];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                values[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combine(0, 0);

        System.out.println(max);
    }

    private static void combine(int depth, int now) {
        // 세 가지 치킨을 선택한 경우
        if(depth == 3) {
            // 현재 조합의 만족도 합과 저장되어 있는 최댓값을 비교
            checkMax();
            return;
        }

        for(int i=now; i<M; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combine(depth+1, i+1);
                visited[i] = false;
            }
        }
    }

    private static void checkMax() {
        int sum = 0;

        for(int i=0; i<N; i++) {
            int temp = 0;
            for(int j=0; j<M; j++) {
                if(visited[j]) {
                    temp = Math.max(temp, values[i][j]);
                }
            }

            sum += temp;
        }

        max = Math.max(max, sum);
    }
}
