package cisco.java.challenge.launcher;

import cisco.java.challenge.graph.GNode;
import cisco.java.challenge.graph.Graph;
import cisco.java.challenge.graph.GraphHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * This class gives the solutions to Problems 1 & 2. You should run this file to see the results.
 *
 * Compiled using
 * java version "1.8.0_181" |  Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
 *
 * GraphHandler.java is a class that implements the GNode interface (GNode.java) provided.
 *
 *
 *
 * Sample problem graph used for the test:
 *
 *          A
 *         ├── B
 *         │   ├── E
 *         │   └── F
 *         ├── C
 *         │   ├── G
 *         │   ├── H
 *         │   └── I
 *         └── D
 *         
 Sample answers:
 1) walkGraph(A) = [A, B, E, F, C, G, H, I, D]
 2) paths(A) = ( (A B E) (A B F) (A C G) (A C H) (A C I) (A D) )
 *
 * @author Artem Sietko
 *
 */
public class Main {



    public static void main(String[] args) {
         

        //instantiate the graph nodes
        Graph nodeA = new Graph("A");
        Graph nodeB = new Graph("B");
        Graph nodeC = new Graph("C");
        Graph nodeD = new Graph("D");
        Graph nodeE = new Graph("E");
        Graph nodeF = new Graph("F");
        Graph nodeG = new Graph("G");
        Graph nodeH = new Graph("H");
        Graph nodeI = new Graph("I");

        GraphHandler graphHandler = new GraphHandler();

        //set children
        GNode[] children_of_nodeA = new GNode[] {nodeB, nodeC, nodeD};
        nodeA.setChildren(children_of_nodeA);

        GNode[] children_of_nodeB = new GNode[] {nodeE, nodeF};
        nodeB.setChildren(children_of_nodeB);

        GNode[] children_of_nodeC = new GNode[] {nodeG, nodeH, nodeI};
        nodeC.setChildren(children_of_nodeC);


        /**
         * Problem 1: Get an ArrayList of all nodes present in the graph (no duplicates)
         */
        graphHandler.printMsg("\nSolutions to problems 1 & 2");

        //1a. walk the graph and get the list of all graph nodes
        List<GNode> resultNodes = graphHandler.walkGraph(nodeA);

        graphHandler.printMsg("\n1) ArrayList containing every GNode in the graph are: " + resultNodes);


        /**
         * Problem 2: Get an ArrayList of ArrayLists representing all
         * possible paths through the graph starting at 'node'
         */
        ArrayList<ArrayList<GNode>> arrayListOfPaths = graphHandler.paths(nodeA);

        graphHandler.printMsg("\n2) The ArrayList of ArrayLists presenting all possible paths are: " + arrayListOfPaths);

    }

}