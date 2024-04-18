import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1034_램프 {
    static int N, M, K;
    static int max = 0;
    static int[] offCnt;
    static String[] lamps;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        offCnt = new int[N];
        lamps = new String[N];
        check = new boolean[N];

        for(int i=0; i<N; i++) {
            // i 행의 램프 상태 저장
            lamps[i] = br.readLine();
            for(int j=0; j<M; j++) {
                // 꺼져 있는 램프 개수 저장
                if(lamps[i].charAt(j) == '0') offCnt[i]++;
            }
        }

        K = Integer.parseInt(br.readLine());

        checkLamp();

        System.out.println(max);
    }

    private static void checkLamp() {
        for(int i=0; i<N; i++) {
            // 이미 탐색한 행은 탐색하지 않음
            if(check[i]) continue;

            // i 행의 램프를 모두 켤 수 있는 지 체크
            if(offCnt[i] <= K && (K - offCnt[i]) % 2 == 0) {
                // 램프를 모두 켤 수 있는 경우 현재 행과 같은 상태의 행 카운트
                int sameLine = 0;
                for(int j=0; j<N; j++) {
                    if(lamps[i].equals(lamps[j])) {
                        sameLine++;
                        check[j] = true;
                    }
                }

                max = Math.max(max, sameLine);
            }
        }
    }
}
