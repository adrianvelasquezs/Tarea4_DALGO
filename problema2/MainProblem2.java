import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.io.InputStreamReader;

import classes.*;

public class MainProblem2 {
    public static void main(String[] args) throws IOException {

        Graph graph = loadGraph();
        String start = graph.getNodes().get(0);
        BFS bfs = new BFS(graph);

        ArrayList<Set<String>> partitions = new ArrayList<>();
        Set<String> visited = bfs.execute(start);
        partitions.add(visited);
        Set<String> nodes = new HashSet<>(graph.getNodes());

        Set<String> difference = subtractSets(nodes, visited);

        while (!difference.isEmpty()) {
            visited = bfs.execute(difference.iterator().next());
            partitions.add(visited);
            difference = subtractSets(difference, visited);
        }

        safeResults(partitions);

    }

    public static Set<String> subtractSets(Set<String> set1, Set<String> set2) {
        Set<String> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

    public static Graph loadGraph() throws IOException {
        ArrayList<Edge> edges = new ArrayList<>();
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = br.readLine();
        while (line != null) {
            String[] items = line.split(" ");
            if (items.length == 2) {
                edges.add(new Edge(items[0], items[1], 0));
            } else if (items.length == 3) {
                edges.add(new Edge(items[0], items[1], Integer.parseInt(items[2])));
            }
            line = br.readLine();
        }
        br.close();
        return new Graph(edges);
    }

    public static void safeResults(ArrayList<Set<String>> partitions) {
        for (Set<String> partition : partitions) {
            System.out.println(partition.toString());
        }
    }
}
