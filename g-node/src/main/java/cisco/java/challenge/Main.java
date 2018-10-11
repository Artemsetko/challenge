package cisco.java.challenge;

import java.util.ArrayList;

/**
 * This class gives the solutions to Problems 1 & 2. You should run this file to see the results.
 *
 * Compiled using
 * java version "1.8.0_181" |  Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
 *
 * GNodeImpl.java is a class that implements the GNode interface (GNode.java) provided.
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
        GNodeImpl nodeA = new GNodeImpl("A");
        GNodeImpl nodeB = new GNodeImpl("B");
        GNodeImpl nodeC = new GNodeImpl("C");
        GNodeImpl nodeD = new GNodeImpl("D");
        GNodeImpl nodeE = new GNodeImpl("E");
        GNodeImpl nodeF = new GNodeImpl("F");
        GNodeImpl nodeG = new GNodeImpl("G");
        GNodeImpl nodeH = new GNodeImpl("H");
        GNodeImpl nodeI = new GNodeImpl("I");



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
        nodeA.printMsg("\nSolutions to problems 1 & 2");

        //1a. walk the graph and get the list of all graph nodes
        ArrayList<GNode> resultNodes = nodeA.walkGraph(nodeA);

        nodeA.printMsg("\n1) ArrayList containing every GNode in the graph are: " + resultNodes);


        /**
         * Problem 2: Get an ArrayList of ArrayLists representing all
         * possible paths through the graph starting at 'node'
         */
        ArrayList<ArrayList<GNode>> arrayListOfPaths = nodeA.paths(nodeA);

        nodeA.printMsg("\n2) The ArrayList of ArrayLists presenting all possible paths are: " + arrayListOfPaths);

    }

}