package B1303_전쟁전투;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1303_전쟁전투 {
	static int N, M;
	static int[] result;
	static char[][] board;
	static boolean[][] visited;

	static final char OUR = 'W';
	static final char ENEMY = 'B';
	static final int[] DY = {-1, 1, 0, 0};
	static final int[] DX = {0, 0, -1, 1};

	static class Node {
		int y;
		int x;

		public Node(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 가로 크기
		M = Integer.parseInt(st.nextToken()); // 세로 크기

		board = new char[M][N];      // 전쟁터
		visited = new boolean[M][N]; // 이미 카운트(방문)한 병사를 체크하기 위한 배열
		result = new int[2];

		for(int y=0; y<M; y++) {
			String line = br.readLine();
			for(int x=0; x<N; x++) {
				board[y][x] = line.charAt(x);
			}
		}

		// 전쟁터를 돌면서
		for(int y=0; y<M; y++) {
			for(int x=0; x<N; x++) {
				// 카운트 하지 않는 병사가 있는 경우 뭉쳐있는 병사 카운트
				if(!visited[y][x]) {
					bfs(y, x);
				}
			}
		}

		sb.append(result[0]).append(" ").append(result[1]);
		System.out.println(sb.toString());
	}

	private static void bfs(int y, int x) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(y, x));
		visited[y][x] = true;

		int count = 0;
		char team = board[y][x]; // 탐색을 시작한 병사의 팀 정보 저장

		while(!queue.isEmpty()) {
			Node node = queue.poll(); // 현재 병사의 좌표 정보
			count++;

			// 현재 병사의 상하좌우 좌표
			for(int i=0; i<4; i++) {
				int ny = node.y + DY[i]; // 다음 y 좌표
				int nx = node.x + DX[i]; // 다음 x 좌표

				// 전쟁터를 벗어나지 않고 방문하지 않은 좌표인 경우
				if(isRange(ny, nx) && !visited[ny][nx]) {
					// 탐색을 시작한 병사와 같은 팀인 경우
					if(board[ny][nx] == team) {
						queue.add(new Node(ny, nx));
						visited[ny][nx] = true;
					}
				}
			}
		}

		// 탐색을 시작한 병사가 아군인지 적군인지 확인하고 정답 배열에 위력 누적
		if(team == OUR) result[0] += count * count;
		if(team == ENEMY) result[1] += count * count;
	}

	private static boolean isRange(int y, int x) {
		return y >= 0 && x >= 0 && y < M && x < N;
	}
}
