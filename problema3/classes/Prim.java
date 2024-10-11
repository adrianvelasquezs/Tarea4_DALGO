package classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {

    Graph graph;

    public Prim(Graph graph) {
        this.graph = graph;
    }

    public Graph execute() {

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.getWeight() - e2.getWeight();
            }
        });

        String start = graph.getNodes().getFirst();

        priorityQueue.addAll(graph.getNeighborEdges(start));

        ArrayList<String> visited = new ArrayList<String>();

        visited.add(start);

        ArrayList<Edge> mst = new ArrayList<Edge>();

        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            if (!visited.contains(edge.getDestination())) {
                visited.add(edge.getDestination());
                mst.add(edge);
                priorityQueue.addAll(graph.getNeighborEdges(edge.getDestination()));
            }
        }

        return new Graph(mst);
    }
}
