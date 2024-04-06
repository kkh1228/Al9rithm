import java.util.*;
import java.io.*;

public class Main {
    static int[] X = {-1, 1, 2}; //이동하는걸 비교하는데에 사용할 부분
    static int kind = Integer.MAX_VALUE; //몇번 방문했는지
    static int num = 0; // 최단거리 방법 숫자

    static void Bfs(int start, int des) {
        int[] field = new int[100_001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll(); //q에넣은 제일앞에있는 값을 꺼내서 now 에 넣어줌
            if (kind < field[now]) { //filed now안의 값이 kind를 넘어서면 비교할필요가 없기에 종료
                return;
            }
            if (field[now] <= kind && now == des)// field[now]= 해당위치를 몇번만에 탐색했는지 와 && now[현재위치]가 des 도착지와 같다면 몇번만에 도착했는지를 kind에 초기화해주고 방법의 숫자를 1개더해준다.
            {
                kind = field[now];
                num++;

            }
            for (int i = 0; i < 3; i++) {
                int next = now;
                if (i == 2) {
                    next = now * X[i];
                } else {
                    next = now + X[i];
                }
                if (next >= 0 && next <= 100001) {
                    if (field[next] == 0 || field[next] >= field[now] + 1)// 중복해서 탐색하는것을 막기위한 조치
                    {
                        field[next] = field[now] + 1;// 몇번이동해서 탐색했는지 알기위해 추가
                        q.offer(next);
                    }
                }
            }

        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //수빈이 위치
        int K = Integer.parseInt(st.nextToken()); // 동생의 위치

        Bfs(N, K); // 탐색함수 호출
        System.out.println(kind + "\n" + num);


    }

}
