package week11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_20055_컨베이어벨트위의로봇 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        List<Integer> upBelt = new ArrayList<>();
        List<Integer> downBelt = new ArrayList<>();

        for(int i = 0; i < N; i++){
            upBelt.add(Integer.parseInt(input[i]));
        }

        for(int i = 2*N -1; i >= N; i--){
            downBelt.add(Integer.parseInt(input[i]));
        }

        int idx = 1;
        int zeroCnt = 0; // 내구도 0 컨베이터 벨트 개수
        boolean[] robot = new boolean[N];

        while(true){

            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한칸 회전한다
            downBelt.add(upBelt.remove(N-1));  // 순서를 주의해야함
            upBelt.add(0, downBelt.remove(0));
            for(int i = N-1; i >= 1; i--){ // 로봇들의 위치를 하나씩 뒤로 물림
                robot[i] = robot[i-1];
            }
            robot[0] = false;

            // 2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다

            for(int i = N-1; i>=0; i--){
                if(!robot[i])
                    continue;

                if(i == N-1){
                    robot[i] = false;
                    continue;
                }

                if(!robot[i+1] && upBelt.get(i+1) > 0){
                    robot[i+1] = true;
                    robot[i] = false;
                    upBelt.set(i+1, upBelt.get(i+1) - 1);
                    if(upBelt.get(i+1) == 0){
                        zeroCnt++;
                    }
                }
            }

            // 3. 올리는 위치에 칸의 내구도가 0이 아니라면 올리는 위치에 로봇을 올린다
            if(upBelt.get(0) > 0){
                robot[0] = true;
                upBelt.set(0, upBelt.get(0) - 1);
                if(upBelt.get(0) == 0)
                    zeroCnt++;
            }

            // 4. 내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않으면 1번으로 돌아간다
            if(zeroCnt >= K)
                break;
            idx++;

        }
        System.out.println(idx);
    }
}
