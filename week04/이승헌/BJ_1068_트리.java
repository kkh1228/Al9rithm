package al9rithm.week4;

import java.util.*;

public class BJ_1068_트리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer>[] tree = new HashSet[n];  // tree[i] 는 i 번째 노드가 자식으로 갖고 있는 노드를 나타냄
        for(int i = 0; i <n; i++){
            tree[i] = new HashSet<>(); // 배열을 초기화
        }

        int rootNode = 0; // rootNode 를 찾기위한 변수

        for(int i = 0; i < n; i++){
            int idx = sc.nextInt();

            if(idx == -1){ // 만약 부모가 -1 이라면 루트노드
                rootNode = i;
                continue;
            }
            tree[idx].add(i); // idx 노드가 부모이므로 tree[idx] 에 자기 자신을 삽입
        }

        int removeIdx = sc.nextInt();  // 삭제할 트리 노드

        for(int i = 0; i < n; i++){
            if(tree[i].contains(removeIdx)){ // 트리를 순회하며 만약 자식으로 삭제할 노드를 갖고 있을 시 삭제
                tree[i].remove(removeIdx);
            }
        }

        // root 노드부터 bfs 통해 리프 노드를 탐색
        Queue<Integer> que = new ArrayDeque<>();
        que.add(rootNode);

        int ans = 0;

        while(!que.isEmpty()){

            int cur = que.poll();

            if(cur == removeIdx) // 만약 삭제한 인덱를 만났다면 건너뛰기
                continue;

            if(tree[cur].size() == 0){  // 만약 자식이 0 이라면 리프노트기 때문에 정답을 1 증가
                ans++;
                continue;
            }

            for(Integer next : tree[cur]){ // 자식들을 순회하며 Queue에 추가
                que.add(next);
            }
        }

        System.out.println(ans);
    }
}
