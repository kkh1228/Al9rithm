package al9rithm.week8;

import java.io.*;
import java.util.*;

public class CodeTree_초대장과번호표 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int G = Integer.parseInt(input[1]);

        Map<Integer, List<Integer>> includeGroups = new HashMap<>();
        Map<Integer, Set<Integer>> peopleInGroups = new HashMap<>();

        for(int i = 1; i <= N; i++){
            includeGroups.put(i, new ArrayList<>());
        }

        for(int i = 1; i <= G; i++){
            peopleInGroups.put(i, new HashSet<>());
        }

        for(int i = 1; i <= G; i++){
            input = br.readLine().split(" ");
            for(int j = 1; j < input.length; j++){

                int people = Integer.parseInt(input[j]);

                peopleInGroups.get(i).add(people);
                includeGroups.get(people).add(i);
            }
        }

        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        boolean[] visited = new boolean[N+1];

        int ans = 0;

        while(!que.isEmpty()){

            int people = que.poll();
            ans++;

            for(Integer group : includeGroups.get(people)){
                peopleInGroups.get(group).remove(people);

                if(peopleInGroups.get(group).size() == 1){
                    for(Integer next : peopleInGroups.get(group)){
                        if(!visited[next]){
                            que.add(next);
                            visited[next] = true;
                        }
                    }
                }


            }
        }

        System.out.println(ans);

    }
}