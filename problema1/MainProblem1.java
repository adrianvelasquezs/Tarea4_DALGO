package problema1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main class for problem 1.
 * This class is used to test the implementation of the classes in the problem 1. To change the algorithm used
 * to solve the problem, you can change the implementation of the method in line 27, as mentioned in the
 * README.md file.
 *
 * @author Adrian Velasquez 202222737
 */
public class MainProblem1
{
    /**
     * Finds the Minimum Spanning Tree for the given graph file.
     * @param graphFile File with the edges of the graph.
     * @throws IOException If the file cannot be processed
     */
    public void findMST( String graphFile ) throws IOException
    {
        List<WeightedDirectedEdge> graph = loadGraph( graphFile );
        MinimumSpanningTree algorithm = new DijkstraMST(); // CHANGE ALGORITHM HERE
        List<WeightedDirectedEdge> tree = algorithm.createMST( graph );
        printTree( tree );
    }

    /**
     * Loads a weighted directed graph from the text file given. The format should be a tab separated file with
     * the following format:
     * <pre> {@code source destination weight} </pre>
     * @param graphFile File with the information of the edges of the graph
     * @return List<WeightedDirectedEdge> Graph defined by the list of edges
     * @throws IOException If the file can not be processed
     */
    public List<WeightedDirectedEdge> loadGraph( String graphFile ) throws IOException
    {
        List<WeightedDirectedEdge> graph = new ArrayList<>();
        FileReader reader = new FileReader( graphFile );
        BufferedReader in = new BufferedReader(reader);
        String line = in.readLine();
        while( line != null )
        {
            String [] items = line.split(" ");
            graph.add( new WeightedDirectedEdge(Integer.parseInt(items[0]), Integer.parseInt(items[1]),
                    Integer.parseInt(items[2])));
            line = in.readLine();
        }
        return graph;
    }

    /**
     * Prints the tree to the standard output.
     * @param tree The tree to print
     */
    private void printTree( List<WeightedDirectedEdge> tree )
    {
        for (WeightedDirectedEdge edge : tree)
        {
            int s = edge.getSource();
            int d = edge.getDestination();
            int w = edge.getWeight();
            System.out.println( "source: " + s + ", destination: " + d + ", weight: " + w );
        }
    }

    /**
     * Main method for problem 1. Finds MST for the given graph file.
     * @param args Command line arguments
     *             args[0] File with the graph edges
     */
    public static void main( String[] args ) throws IOException
    {
        MainProblem1 main = new MainProblem1();
        main.findMST( args[0] );
    }
}
