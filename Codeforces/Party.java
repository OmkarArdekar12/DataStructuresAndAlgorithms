// Party 115-A

import java.util.*;

public class Party {
	static ArrayList<Integer> graph[];

	public static int dfs(int i) {
		if(graph[i] == null || graph[i].isEmpty()) {
			return 1;
		}

		int max = 0;
		for(int j : graph[i]) {
			max = Math.max(dfs(j), max);
		}
		return max + 1;
	}

	@SuppressWarnings("unchecked")
	public static void party(int n, int arr[]) {
		graph = new ArrayList[n];
		for(int i=0; i<n; ++i) {
			graph[i] = new ArrayList<>();
		}

		for(int i=0; i<n; ++i) {
			if(arr[i] == -1) {
				continue;
			}
			graph[arr[i] - 1].add(i);
		}

		int maxGroups = 0;
		for(int i=0; i<n; ++i) {
			if(arr[i] == -1) {
				maxGroups = Math.max(maxGroups, dfs(i));
			}
		}

		System.out.println(maxGroups);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
        sc.close();
		party(n, arr);
	}
}
/*import java.util.*;
// find the longest path in the graph/tree
public class Party {
	static ArrayList<Integer> graph[];
	public static int dfs(int i) {
		if(graph[i] == null || graph[i].isEmpty()) {
			return 1;
		}

		int max = 0;
		for(int j : graph[i]) {
			max = Math.max(dfs(j), max);
		}
		return max + 1;
	}
	public static void party(int n, int arr[]) {
		graph = new ArrayList[n];
		for(int i=0; i<n; ++i) {
			graph[i] = new ArrayList<>();
		}

		for(int i=0; i<n; ++i) {
			if(arr[i] == -1) {
				continue;
			}
			graph[arr[i] - 1].add(i);
		}

		int maxGroups = 0;
		for(int i=0; i<n; ++i) {
			if(arr[i] == -1) {
				maxGroups = Math.max(maxGroups, dfs(i));
			}
		}

		System.out.println(maxGroups);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; ++i) {
			arr[i] = sc.nextInt();
		}
		party(n, arr);
	}
}*/