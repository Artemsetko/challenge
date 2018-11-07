package cisco.java.challenge.graph;

import java.util.Arrays;
import java.util.Objects;

public class Graph implements GNode {

    //Name of the graph node
    private String nodeName;

    //Children in the node
    private GNode[] children;

    //An array of size zero to represent no child in node
    GNode[] EMPTY_LIST = new GNode[0];

    //constructor
    public Graph(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * Setter for the children nodes in the graph
     *
     * @param children
     */
    public void setChildren(GNode[] children) {
        int arrLength = children.length;
        int index = 0; //counter for array index
        this.children = new GNode[arrLength];

        for (GNode child : children) {
            this.children[index] = child;
            index = index + 1;
        }
    }

    /**
     * Method to obtain root node name.
     * @return Name of root node of graph.
     */
    @Override
    public String getName() {

        return this.nodeName;
    }

    /**
     * Method to obtain root node children.
     * @return Sub-nodes of root node. If children field is null or has zero-length,
     * then it returns zero-length array of GNode.
     */
    @Override
    public GNode[] getChildren() {

        if (this.children == null || children.length == 0) {
            return EMPTY_LIST;

        } else {
            return this.children;
        }

    }


    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Graph graph = (Graph) o;
        return Objects.equals(nodeName, graph.nodeName) &&
                Arrays.equals(getChildren(), graph.getChildren());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(nodeName);
        result = 31 * result + Arrays.hashCode(getChildren());
        return result;
    }
}
