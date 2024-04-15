import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int sum = 0;
        ArrayList<Integer> number = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++)
        {
            number.add(Integer.parseInt(st.nextToken()));
        }

        for(int i =0; i<n-2; i++)
        {
            for(int j =i+1; j<n-1; j++)
            {
                for(int k =j+1; k<n; k++)
                {
                    sum = number.get(i) + number.get(j) + number.get(k);
                    if(sum == m) {
                        System.out.println(m);
                        return;
                    }
                    if(sum > max && sum < m){
                        max = sum;
                    }

                }
            }
        }
        System.out.println(max);
    }
}
