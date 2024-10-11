package classes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {

    private Graph graph;

    public BFS(Graph graph) {
        this.graph = graph;
    }

    public Set<String> execute(String start) {

        Set<String> visited = new HashSet<>();

        visited.add(start);

        String node = start;

        Queue<String> queue = new LinkedList<>();

        queue.addAll(graph.getNeighbors(node));

        while (!queue.isEmpty()) {

            for (String neighbor : graph.getNeighbors(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.addAll(graph.getNeighbors(neighbor));
                }
            }
            node = queue.remove();
        }

        return visited;
    }
}
