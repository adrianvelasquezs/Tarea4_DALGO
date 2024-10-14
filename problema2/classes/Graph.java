package problema2.classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

    private List<Edge> edges;
    private HashMap<String, List<String>> adyaList;
    private List<String> nodes;

    public Graph(List<Edge> edges) {
        this.edges = edges;
        this.adyaList = makeAdyaList();
        this.nodes = adyaList.keySet().stream().toList();
    }

    public List<String> getNeighbors(String node) {
        return adyaList.get(node);
    }

    public HashMap<String, List<String>> makeAdyaList() {

        HashMap<String, List<String>> adyaList = new HashMap<String, List<String>>();
        for (Edge edge : edges) {
            if (adyaList.containsKey(edge.getSource())) {
                adyaList.get(edge.getSource()).add(edge.getDestination());
            } else {
                adyaList.put(edge.getSource(), new ArrayList<String>());
                adyaList.get(edge.getSource()).add(edge.getDestination());
            }

            // because is a non directed graph, we shall do the same for the other direction

            if (adyaList.containsKey(edge.getDestination())) {
                adyaList.get(edge.getDestination()).add(edge.getSource());
            } else {
                adyaList.put(edge.getDestination(), new ArrayList<String>());
                adyaList.get(edge.getDestination()).add(edge.getSource());
            }
        }
        return adyaList;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public HashMap<String, List<String>> getAdyaList() {
        return adyaList;
    }

    public void setAdyaList(HashMap<String, List<String>> adyaList) {
        this.adyaList = adyaList;
    }

    public List<String> getNodes() {
        return nodes;
    }

}
