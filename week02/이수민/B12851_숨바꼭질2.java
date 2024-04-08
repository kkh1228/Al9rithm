import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B12851_숨바꼭질2 {
    static int N, K;
    static int count = 0;
    static int min = Integer.MAX_VALUE;

    static int[] time = new int[100001];
    static int[] dir = {1, -1, 2};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 수빈이가 동생보다 멀리 있거나 같은 위치에 있는 경우 경우의 수는 1가지
        if(N >= K) {
            sb.append(N - K).append("\n").append(1);
            System.out.println(sb.toString());
            return;
        }

        bfs();

        sb.append(min).append("\n").append(count);
        System.out.println(sb.toString());
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        time[N] = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();

            // 현재 위치를 방문한 시간이 최소 시간보다 큰 경우 탐색 종료
            if(min < time[now]) return;

            for(int i=0; i<3; i++) {
                int next;
                if(i == 2) next = now * dir[i];
                else next = now + dir[i];

                if(!isRange(next)) continue;

                // 다음 좌표가 동생의 위치인 경우 최소 시간 갱신 후 카운트 증가
                if(next == K) {
                    if(min == Integer.MAX_VALUE) min = time[now];
                    count++;
                }

                // 방문하지 않은 위치이거나 같은 시간으로 재방문한 경우
                if(time[next] == 0 || time[next] == time[now] + 1) {
                    queue.add(next);
                    time[next] = time[now] + 1;
                }
            }
        }
    }

    private static boolean isRange(int location) {
        return location >= 0 && location <= 100000;
    }
}
