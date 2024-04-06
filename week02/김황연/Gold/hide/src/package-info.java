//참고용
//import java.io.*;
//import java.util.*;
//
//public class Main {
//
//    static int[] dx = {-1, 1, 2};
//    static int cnt=0, res = Integer.MAX_VALUE;
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int k = Integer.parseInt(st.nextToken());
//
//        bfs(n, k);
//        System.out.println(res);//res 도착 시간
//        System.out.println(cnt);//도착방법
//    }
//
//    static void bfs(int start, int destination) {
//        Queue<Integer> q = new LinkedList<>();
//        int[] move = new int[100_001];
//        q.add(start);
//
//        while(!q.isEmpty()) {
//            int pos = q.poll(); //n(시작위치)
//            System.out.println("포스"+pos);
//            System.out.println("res"+res);
//            System.out.println("무브포스"+move[pos]);
//
//            if(res < move[pos]) return;
//            if(move[pos]<=res && pos == destination) {
//
//                res = move[pos];
//                cnt++;
//            }
//
//            for(int i=0; i<3; i++) {
//                int next = pos;
//                if(i==2) {
//                    next = pos*dx[i];
//                }else {
//                    next = pos + dx[i];
//                }
//                if (next>=0 && next <100001) {
//                    if(move[next] ==0 || move[next] >= move[pos] + 1) {
//                        move[next] = move[pos]+1;//move[4] = 0; = move[5]+1; =1 q.add(4);
//                        q.add(next);
//                    }
//                }
//            }
//        }
//    }
//}

//참고용2
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        // 그래프를 2차원 배열로 표현해줍니다.
//        // 배열의 인덱스를 노드와 매칭시켜서 사용하기 위해 인덱스 0은 아무것도 저장하지 않습니다.
//        // 1번인덱스는 1번노드를 뜻하고 노드의 배열의 값은 연결된 노드들입니다.
//        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
//
//        // 방문처리를 위한 boolean배열 선언
//        boolean[] visited = new boolean[9];
//
//        System.out.println(bfs(1, graph, visited));
//        //출력 내용 : 1 -> 2 -> 3 -> 8 -> 6 -> 5 -> 4 -> 7 ->
//    }
//
//    static String bfs(int start, int[][] graph, boolean[] visited) {
//        // 탐색 순서를 출력하기 위한 용도
//        StringBuilder sb = new StringBuilder();
//        // BFS에 사용할 큐를 생성해줍니다.
//        Queue<Integer> q = new LinkedList<Integer>();
//
//        // 큐에 BFS를 시작 할 노드 번호를 넣어줍니다.
//        q.offer(start);
//
//        // 시작노드 방문처리
//        visited[start] = true;
//
//        // 큐가 빌 때까지 반복
//        while(!q.isEmpty()) {
//            int nodeIndex = q.poll();
//            sb.append(nodeIndex + " -> ");
//            //큐에서 꺼낸 노드와 연결된 노드들 체크
//            for(int i=0; i<graph[nodeIndex].length; i++) {
//                int temp = graph[nodeIndex][i];
//                // 방문하지 않았으면 방문처리 후 큐에 넣기
//                if(!visited[temp]) {
//                    visited[temp] = true;
//                    q.offer(temp);
//                }
//            }
//        }
//        // 탐색순서 리턴
//        return sb.toString() ;
//    }
//}
