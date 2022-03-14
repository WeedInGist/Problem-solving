

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 2021. 03. 14. 월  - 백준 1197번 - 최소스패닝트리
 * 
 */

public class MST_boj_1197_JHJ {

	static int V, E, parents[];
	static ArrayList<Edge> graph;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		V = Integer.parseInt(stk.nextToken());
		E = Integer.parseInt(stk.nextToken());
		parents = new int[V + 1]; // 각 노드들의 부모노드
		graph = new ArrayList<>();

		// 모든 부모노드를 자기자신으로 초기화
		for (int i = 0; i <= V; i++) {
			parents[i] = i;
		}

		// 인접리스트의 형태로 그래프 만들기
		for (int i = 0; i < E; i++) {
			stk = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(stk.nextToken());
			int end = Integer.parseInt(stk.nextToken());
			int weight = Integer.parseInt(stk.nextToken());
			graph.add(new Edge(start, end, weight)); // 무방향 그래프이며 간선의 정보를 저장한다.
		}
		// ===================== input end =====================

		Collections.sort(graph); // weight를 기준으로 정렬

		int cost = 0;
		for (int i = 0; i < E; i++) {
			Edge e = graph.get(i);
			// 1. 같은 집합에 속하는지를 확인한다 (루트노드를 확인하면서, 자신의 부모노드를 루트노드로 바꾸어준다)
			int parentA = findParent(e.start);
			int parentB = findParent(e.end);

			// 2. 같은 집합에 속하지 않는다면, 처음 방문한 노드이며 경로를 만들 수 있다.
			if (parentA != parentB) {
				union(e.start, e.end);
				cost += e.weight;
			}
		}
		System.out.println(cost);
	}

	private static void union(int a, int b) {
		int parentA = findParent(a);
		int parentB = findParent(b);

		if (parentA < parentB)
			parents[parentA] = b;
		else
			parents[parentB] = a;
	}

	private static int findParent(int a) {
		if (parents[a] == a)
			return a;
		else
			return parents[a] = findParent(parents[a]);
	}

	private static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return weight - o.weight;
		}
	}
}

/*
6 9
1 2 5
1 3 4
2 3 2
2 4 7
3 4 6
3 5 11
4 5 3
4 6 8
5 6 8
*/

//3 3
//3 7 1
//3 5 3
//5 7 2 
