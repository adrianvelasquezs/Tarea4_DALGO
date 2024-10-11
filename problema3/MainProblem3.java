import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import classes.Edge;
import classes.Graph;
import classes.Prim;

public class MainProblem3 {
    public static void main(String[] args) throws IOException {

        Graph graph = loadGraph();

        Prim prim = new Prim(graph);

        Graph mst = prim.execute();

        for (Edge edge : mst.getEdges()) {
            System.out.println(edge.getSource() + " " + edge.getDestination() + " " + edge.getWeight());
        }

    }

    public static Graph loadGraph() throws IOException {
        ArrayList<Edge> edges = new ArrayList<>();
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String line = br.readLine();
        while (line != null) {
            String[] items = line.split(" ");
            edges.add(new Edge(items[0], items[1], Integer.parseInt(items[2])));
            line = br.readLine();
        }
        br.close();
        return new Graph(edges);
    }
}
