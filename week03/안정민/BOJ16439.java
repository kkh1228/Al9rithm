import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16439 {
    static int N, M;
    static int[][] arr;
    static int max = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[M];

        for (int i = 0; i < N; i++) {
            String[] s1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s1[j]);
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int start, int depth) {
        if (depth == 3) {
            int sum = 0;

            for (int i = 0; i < N; i++) {
                // 각 학생이 선택한 음식의 만족도를 저장할 변수를 최솟값으로 초기화
                int temp = Integer.MIN_VALUE;

                for (int j = 0; j < M; j++) {
                    if (visited[j]) {
                        // 각 학생이 선택한 음식 중 가장 높은 만족도를 구함
                        temp = Math.max(temp, arr[i][j]);
                    }
                }
                sum += temp;
            }
            // 현재까지의 최대 만족도와 비교하여 더 큰 값으로 갱신
            max = Math.max(max, sum);
            return;
        }

        // 음식을 선택하는 부분
        for (int i = start; i < M; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }
}
