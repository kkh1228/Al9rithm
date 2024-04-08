package al9rithm.week2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BJ_12581_숨박꼭질2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] visited = new int[100001];

        int minTime = 1000000;
        int minCount = 0;
        Queue<Pos> que = new ArrayDeque<>();
        que.offer(new Pos(N, 0));

        while(!que.isEmpty()) {

            Pos p = que.poll();

            if(p.cnt > minTime)
                continue;

            if(p.idx == K){
                if(p.cnt == minTime)
                    minCount++;
                else if(p.cnt < minTime){
                    minTime = p.cnt;
                    minCount = 1;
                }
                continue;
            }

            if(p.idx - 1 >= 0 && visited[p.idx - 1] < 4){
                if(p.idx -1 != K)
                    visited[p.idx - 1]++;
                que.offer(new Pos(p.idx - 1, p.cnt+1));
            }

            if(p.idx + 1 < 100001 && visited[p.idx + 1] < 4){
                if(p.idx + 1 != K)
                    visited[p.idx + 1]++;
                que.offer(new Pos(p.idx + 1, p.cnt+1));
            }

            if(p.idx * 2 < 100001 && visited[p.idx * 2] < 4){
                if(p.idx * 2 != K)
                    visited[p.idx * 2]++;
                que.offer(new Pos(p.idx * 2, p.cnt+1));
            }

        }

        System.out.println(minTime);
        System.out.println(minCount);


    }

    private static class Pos{
        int idx, cnt;
        public Pos(int idx, int cnt){
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}
