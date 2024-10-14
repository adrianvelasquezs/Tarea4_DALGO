package problema3.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private List<Edge> edges;
    private HashMap<String, List<String>> nodeAdyaList;
    private HashMap<String, List<Edge>> edgeAdyaList;
    private List<String> nodes;

    public Graph(List<Edge> edges) {
        this.edges = edges;
        makeAdyaList();
        this.nodes = nodeAdyaList.keySet().stream().toList();
    }

    public List<String> getNeighborNodes(String node) {
        return nodeAdyaList.get(node);
    }

    public List<Edge> getNeighborEdges(String node) {
        return edgeAdyaList.get(node);
    }

    public void makeAdyaList() {

        HashMap<String, List<String>> nodeAdyaList = new HashMap<String, List<String>>();
        for (Edge edge : edges) {
            if (nodeAdyaList.containsKey(edge.getSource())) {
                nodeAdyaList.get(edge.getSource()).add(edge.getDestination());
            } else {
                nodeAdyaList.put(edge.getSource(), new ArrayList<String>());
                nodeAdyaList.get(edge.getSource()).add(edge.getDestination());
            }

            // because is a non directed graph, we shall do the same for the other direction

            if (nodeAdyaList.containsKey(edge.getDestination())) {
                nodeAdyaList.get(edge.getDestination()).add(edge.getSource());
            } else {
                nodeAdyaList.put(edge.getDestination(), new ArrayList<String>());
                nodeAdyaList.get(edge.getDestination()).add(edge.getSource());
            }
        }
        this.nodeAdyaList = nodeAdyaList;

        HashMap<String, List<Edge>> edgeAdyaList = new HashMap<String, List<Edge>>();

        for (Edge edge : edges) {
            if (edgeAdyaList.containsKey(edge.getSource())) {
                edgeAdyaList.get(edge.getSource()).add(edge);
            } else {
                edgeAdyaList.put(edge.getSource(), new ArrayList<Edge>());
                edgeAdyaList.get(edge.getSource()).add(edge);
            }

            // because is a non directed graph, we shall do the same for the other direction
            // for this we create a new edge with the source and destination inverted

            if (edgeAdyaList.containsKey(edge.getDestination())) {
                edgeAdyaList.get(edge.getDestination())
                        .add(new Edge(edge.getDestination(), edge.getSource(), edge.getWeight()));
            } else {
                edgeAdyaList.put(edge.getDestination(), new ArrayList<Edge>());
                edgeAdyaList.get(edge.getDestination())
                        .add(new Edge(edge.getDestination(), edge.getSource(), edge.getWeight()));
            }
        }

        this.edgeAdyaList = edgeAdyaList;

    }

    public List<Edge> getEdges() {
        return edges;
    }

    public HashMap<String, List<String>> getNodeAdyaList() {
        return nodeAdyaList;
    }

    public void setNodeAdyaList(HashMap<String, List<String>> adyaList) {
        this.nodeAdyaList = adyaList;
    }

    public List<String> getNodes() {
        return nodes;
    }

}
