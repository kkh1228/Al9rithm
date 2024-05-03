import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        
        Map<Integer, List<Integer>> map = new HashMap<>();

        int max = -1;

        for(int i = 0; i < n; i++){
            int cur = sc.nextInt();

            if(map.get(cur) == null){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(cur, list);
            }else{
                for(Integer next : map.get(cur)){
                    if(Math.abs(next - i) <= k)
                        max = Math.max(max, cur);
                }
                map.get(cur).add(i);
            }
        }

        System.out.println(max);
        
    }
}