package cisco.java.challenge.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This class implements GNode Interface to solve the task.
 *
 * @author Artem Sietko
 *
 */
public class GraphHandler {

    //An array of size zero to represent no child in node
    GNode[] EMPTY_LIST = new GNode[0];


    //ArrayList of nodes present in the graph
    private ArrayList<GNode> listOfGNodes = new ArrayList<>();

    //Stack data structure used for getting paths in the graph
    private Deque<GNode> stack = new LinkedList<>();

    //ArrayList of ArrayList of GNodes representing all possible paths in the graph
    private ArrayList<ArrayList<GNode>> finalNodeList = new ArrayList<>(); //final result

    //ArrayList of GNodes temporarily capturing the possible paths in the graph
    private ArrayList<GNode> tempNodeList = new ArrayList<>(); //temp result


    /**
     * Returns an ArrayList containing every GNode in the graph
     *
     * @param node
     * @return the Arraylist of every GNode in the graph.
     */
    public List<GNode> walkGraph(GNode node) {

        //name of current node
        String currentNodeName = node.getName();

        //add node to the ArrayList
        listOfGNodes.add(node);

        //for each child node, check if it has children nodes and add to list (recursive action)
        for (GNode child : node.getChildren()) {

            walkGraph(child);
        }

        return listOfGNodes;
    }


    /**
     * Returns a ArrayList of ArrayLists of GNodes representing all
     * possible paths through the graph starting at 'node'. The ArrayList
     * returned can be thought of as a ArrayList of paths, where each path
     * is represented as an ArrayList of GNodes. Based on Depth First Search (DFS) Algorthm
     *
     *
     * @param node
     * @return ArrayList of ArrayLists of GNodes of all possible paths starting at node in the graph
     */
    public ArrayList<ArrayList<GNode>> paths(GNode node) {

        stack.push(node);
        tempNodeList.add(node);


        //recursively explore each node and child nodes
        if (!stack.isEmpty()) {
            GNode currentNode = stack.peek();

            GNode[] children = currentNode.getChildren();

            if (children.length == 0) {

                finalNodeList.add(new ArrayList<GNode>(tempNodeList));
            }

            for(GNode child : children) {

                paths(child);

                //backtrack one step, since we're doing DFS
                stack.pop();
                tempNodeList.remove(tempNodeList.size() - 1);
            }
        }

        return finalNodeList;
    }


    /**
     * For printing messages to screen
     *
     * @param msg
     */
    public void printMsg (String msg) {
        System.out.println(msg);
    }

}
