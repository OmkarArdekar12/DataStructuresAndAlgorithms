// Reposts 522-A

import java.util.*;

public class Reposts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> depth = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        String root = "polycarp";
        depth.put(root, 1);
        graph.put(root, new ArrayList<>());

        for(int i=0; i<n; ++i) {
            String line = sc.nextLine();
            String parts[] = line.split(" reposted ");
            String from = parts[1].toLowerCase();
            String to = parts[0].toLowerCase();

            if(!graph.containsKey(from)) {
                graph.put(from, new ArrayList<>());
            }
            graph.get(from).add(to);

            if(!depth.containsKey(to)) {
                depth.put(to, 0);
            }
        }

        queue.add(root);
        int maxDepth = 1;
        while(!queue.isEmpty()) {
            String current = queue.poll();
            if(!graph.containsKey(current)) {
                continue;
            }
            for(String neighbor : graph.get(current)) {
                depth.put(neighbor, depth.get(current) + 1);
                if(depth.get(neighbor) > maxDepth) {
                    maxDepth = depth.get(neighbor);
                }
                queue.add(neighbor);
            }
        }

        System.out.println(maxDepth);

        sc.close();
    }
}