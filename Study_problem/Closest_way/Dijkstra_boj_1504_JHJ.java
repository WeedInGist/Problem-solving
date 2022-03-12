package study08_dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 2022.03.07.월 - 백준 1504번 - 특정한 최단 경로

public class Dijkstra_boj_1504_JHJ {

	static int v1, v2, N, E, adjMatrix[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		adjMatrix = new int[N + 1][N + 1];

		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(stk.nextToken());
			int to = Integer.parseInt(stk.nextToken());
			int dis = Integer.parseInt(stk.nextToken());

			// 양방향 그래프
			adjMatrix[from][to] = dis;
			adjMatrix[to][from] = dis;

		}

		stk = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(stk.nextToken());
		v2 = Integer.parseInt(stk.nextToken());
		// ===================== input end ==========================

		int start_to_v1 = Dijkstra(1, v1);
		int start_to_v2 = Dijkstra(1, v2);
		int v1_to_v2 = Dijkstra(v1, v2);
		int v2_to_v1 = Dijkstra(v2, v1);
		int v1_to_end = Dijkstra(v1, N);
		int v2_to_end = Dijkstra(v2, N);

		int min_distance = start_to_v1 + v1_to_v2 + v2_to_end;
		min_distance = Math.min(min_distance, start_to_v2 + v2_to_v1 + v1_to_end);
		
		if(v1_to_v2 == Integer.MAX_VALUE || v2_to_v1 == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min_distance);
	}

	// 다익스트라 알고리즘
	private static int Dijkstra(int from, int to) {

		int[] distance = new int[N + 1]; // from에서 to까지의 최소 거리
		PriorityQueue<Vertex> pQueue = new PriorityQueue<>();
		boolean[] visited = new boolean[N + 1]; // 최소 비용 확정 여부

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[from] = 0;
		pQueue.offer(new Vertex(from, 0));

		while (!pQueue.isEmpty()) {
			// 최소비용이 확정되지 않은 정점 중 최소 비용의 정점 선택
			Vertex current = pQueue.poll();

			if (visited[current.no])
				continue;
			else
				visited[current.no] = true;

			// 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 노드까지의 최소 거리 갱신
			for (int j = 1; j < N + 1; j++) {
				if (!visited[j] && adjMatrix[current.no][j] != 0
						&& distance[j] > distance[current.no] + adjMatrix[current.no][j]) {
					distance[j] = distance[current.no] + adjMatrix[current.no][j];
					pQueue.offer(new Vertex(j, distance[j]));
				}
			}
		}

		return distance[to];
	}

	private static class Vertex implements Comparable<Vertex> {
		int no; // 정점의 번호
		int minDistance; // 출발지에서 자신으로의 최소 비용

		Vertex(int no, int minDistance) {
			this.no = no;
			this.minDistance = minDistance;
		}

		@Override
		public int compareTo(Vertex o) {
			return minDistance - o.minDistance;
		}
	}
}
/*
6 6
5 4 3
5 3 6
1 3 9
1 4 1
5 1 6
3 4 4 
5 2
*/