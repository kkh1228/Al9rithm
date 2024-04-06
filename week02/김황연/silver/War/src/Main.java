import java.util.*;
import java.io.*;
public class Main {
    static int N ; // N=가로열
    static int M; // M=세로열
    static int Bl = 0; //검은색 전투력
    static int Wh = 0; //하얀색 전투력
    static int num;
    static int [][] brr;
    static int[] Up = {-1,1,0,0};
    static int[] Right = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        brr = new int[M][N];
        for(int i = 0; i<M; i++)
        {
            char[]arr = br.readLine().toCharArray();
            for(int j = 0; j<N; j++) {
                if(Objects.equals(arr[j],'W')){
                    brr[i][j] = 1;

                } else if (Objects.equals(arr[j],'B')) {
                    brr[i][j] = 2;
                }


            }


        }
        for(int i =0; i<M; i++)
        {
//            int sum = 0; // 하나 DFS 탐색하면서 나온값들의 합 그다음 DFS 할때 비워줘야하기에 초기화
            for(int j = 0; j<N; j++){
                 num = 1; //제곱계산식에 필요하므로 1부터 시작
                if(brr[i][j]==1)
                {
                    brr[i][j]=0;
                    Dfs(i,j, 1);
                    Wh += num*num;
                }
                else if (brr[i][j]==2)
                {
                    brr[i][j]=0;
                    Dfs(i,j, 2);

                    Bl += num*num;

                }
            }
        }
        System.out.print(Wh+" ");
        System.out.print(Bl);
    }
    static void Dfs(int y, int x,int t ){
        for(int i=0; i<4; i++){
            int nx = x+Right[i];
            int ny = y+Up[i];
            if(ny >= 0 && ny < M && nx >= 0 && nx < N && brr[ny][nx] == t){ //nx >= 0 && ny >= 0 && nx < n && ny < m && battle[ny][nx] == num
                brr[ny][nx]=0;
                num++;
                Dfs(ny,nx,t);

            }
        }
    }
}

//public class Main {
//    static int[] dx = {0, 0, -1, 1}; // x 좌표로 움직이기 배열
//    static int[] dy = {-1, 1, 0, 0}; // y 좌표로 움직이기 배열
//
//    static int[][] battle; // 싸움영역 배열
//
//    static int n, m; // 각각 가로, 세로 ==> y, x
//    static int b, w; // b 는 적군, w 는 아군의 총 전투력
//    static int cnt; // 최대로 연결된 병사들의 수를 확인하기 위한 cnt
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        n = Integer.parseInt(st.nextToken()); // 열 = col = 가로의 크기 = x
//        m = Integer.parseInt(st.nextToken()); // 행 = row = 세로의 크기 = y
//
//
//        battle = new int[m][n]; // 이중 for문은 [row][col] => y,x
//
//        // 이중 for 문 시작
//        // 입력받은 글자가 W 라면 1, B 라면 2로 배열에 저장
//        for(int i=0; i<m; i++){ // 바깥 for 문은 세로의 크기 = row = y
//            char[] arr = br.readLine().toCharArray();
////            System.out.println(Arrays.toString(arr));
//            for (int j = 0; j < n; j++) { // 안쪽 for문은 가로의 크기 = col = x
//                if (Objects.equals(arr[j], 'W')) { // 만약 입력받은 글자가 W 라면 1
//                    battle[i][j] = 1;
//                }else if(Objects.equals(arr[j], 'B')){ // 만약 입력받은 글자가 B 라면 2
//                    battle[i][j] = 2;
//                }
////                System.out.print(battle[i][j]+" ");
//            }
////            System.out.println();
//        }
//
//
//        for(int i=0; i<m; i++){
//            int result = 0; // 결과 변수 안쪽 for 문이 한번 끝날때마다 초기화
//            for(int j=0; j<n; j++){
//                cnt = 1;
//
//                if (battle[i][j] == 1) { // 1을 확인후
//                    battle[i][j] = 0;  // 방문하고 0 으로 변경
//                    findPower(i, j, 1); // 현재 i, j 값을 갖고 방문
//                    result = (int) Math.pow(cnt, 2);
//                    w+=result;
//                } else if(battle[i][j] == 2){
////                    System.out.println(i + " " + j);
//                    battle[i][j] = 0;
//                    findPower(i, j, 2);
//                    result = (int)Math.pow(cnt, 2);
//                    b+=result;
//                }
//            }
//        }
//        bw.append(w+" "+b);
//        bw.flush();
//        bw.close();
//
//
//    }
//
//    static void findPower(int y, int x, int num){
//
//        for(int i=0; i<4; i++){
//            int nx = x+dx[i]; //0 0 0 -1 1
//            int ny = y+dy[i];// 0 -1 1 0 0
//
//            if (nx >= 0 && ny >= 0 && nx < n && ny < m && battle[ny][nx] == num) {
//                battle[ny][nx] = 0;
//                cnt++;
//                findPower(ny, nx, num); // 이함수들은 아직 끝나지않은상태 상하좌우를 모두 확인을 해야 함수가 완료되는데 이미 한군데가 걸려서 그걸린곳으로 쭉쭉파내려갔기때문에 끝에도달하면 다시 상위함수로 올라오면서 비교하지않은부분을 체크함;
//
//            }
//        }
//    }
//}
