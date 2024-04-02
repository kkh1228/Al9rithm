import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1202_보석도둑 {
    static class Jewel implements Comparable<Jewel> {
        int weight; // 무게
        int cost;   // 가격

        public Jewel(int weight, int cost) {
            this.weight = weight;
            this.cost = cost;
        }

        // 보석이 가벼울수록 우선순위가 높으며, 무게가 같은 경우 비싼 보석이 우선순위가 높음
        @Override
        public int compareTo(Jewel j) {
            if(this.weight == j.weight) return j.cost - this.cost;
            return this.weight - j.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();

        // 가방에 넣을 수 있는 보석들의 무게를 저장하는 큐
        // 무게가 높을 수록 우선순위가 높기 때문에 내림차순 정렬
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(M,  V));
        }

        for(int i=0; i<K; i++) {
            int C = Integer.parseInt(br.readLine());
            bags.add(C);
        }

        Collections.sort(jewels); // 보석 정렬
        Collections.sort(bags);   // 가방에 담을 수 있는 최대 무게를 기준으로 오름차순 정렬

        int idx = 0;
        long result = 0;
        for(int bag : bags) {
            // 가방에 넣을 수 있는 보석인 경우 우선순위 큐에 보석 가격 삽입
            while(idx < jewels.size() && jewels.get(idx).weight <= bag) {
                queue.add(jewels.get(idx).cost);
                idx++;
            }

            // 가방에 넣은 보석이 있는 경우 가장 비싼 가격 뺌
            if(!queue.isEmpty())result += queue.poll();
        }

        System.out.println(result);
    }
}
