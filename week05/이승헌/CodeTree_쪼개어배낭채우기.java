import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        PriorityQueue<Jewel> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            double w = sc.nextDouble();
            double v = sc.nextDouble();

            pq.add(new Jewel(w, v, v/w));
        }

        double ans = 0;

        while(m > 0 && !pq.isEmpty()){

            Jewel j = pq.poll();

            if(m - j.w >= 0){
                ans += j.v; 
                m -= j.w;
            }else{
                double value = j.v*(m/j.w);
                ans = ans + value;
                m = 0;
            }

        }

        System.out.printf("%.3f", ans);


    }

    public static class Jewel implements Comparable<Jewel>{
        double w, v, score;

        public Jewel(double w, double v, double score){
            this.w = w;
            this.v = v;
            this.score = score;
        }

        @Override
        public int compareTo(Jewel j){
            if(this.score >= j.score){
                return 1;
            }else{
                return -1;
            }
        }

    }
}