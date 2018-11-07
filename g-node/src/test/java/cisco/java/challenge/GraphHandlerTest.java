package cisco.java.challenge;

import cisco.java.challenge.graph.GNode;
import cisco.java.challenge.graph.Graph;
import cisco.java.challenge.graph.GraphHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GraphHandlerTest {

    Graph gNode;
    GraphHandler graphHandler;

    @Before
    public void setUp() throws Exception {
        gNode = new Graph("Start");
        graphHandler = new GraphHandler();
    }

    @Test
    public void setChildren() {
        GNode[] children = new GNode[3];
        children[0] = new Graph("testA");
        children[1] = new Graph("testB");
        children[2] = new Graph("testC");

        gNode.setChildren(children);

        Assert.assertArrayEquals(gNode.getChildren(), children);
        Assert.assertEquals(gNode.getChildren().length, children.length);

    }

    @Test
    public void getName() {
        String expectedName = "Start";

        String actualName = gNode.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getChildren() {
        Assert.assertNotNull(gNode.getChildren());
    }

    @Test
    public void walkGraph() {
        Graph nodeA = new Graph("A");
        Graph nodeB = new Graph("B");
        Graph nodeC = new Graph("C");
        gNode.setChildren(new GNode[]{nodeA});
        nodeA.setChildren(new GNode[]{nodeB, nodeC});

        ArrayList<GNode> gNodeList = new ArrayList();
        gNodeList.add(gNode);
        gNodeList.add(nodeA);
        gNodeList.add(nodeB);
        gNodeList.add(nodeC);

        List<GNode> actual = graphHandler.walkGraph(gNode);

        Assert.assertEquals(actual, gNodeList);
    }

    @Test
    public void paths() {
        Graph nodeA = new Graph("A");
        Graph nodeB = new Graph("B");
        Graph nodeC = new Graph("C");
        gNode.setChildren(new GNode[]{nodeA});
        nodeA.setChildren(new GNode[]{nodeB, nodeC});

        List<List<Graph>> expected = new ArrayList<>();

        ArrayList<Graph> pathOne = new ArrayList<>();
        pathOne.add(gNode);
        pathOne.add(nodeA);
        pathOne.add(nodeB);

        ArrayList<Graph> pathTwo = new ArrayList<>();
        pathTwo.add(gNode);
        pathTwo.add(nodeA);
        pathTwo.add(nodeC);

        expected.add(pathOne);
        expected.add(pathTwo);

        Assert.assertEquals(expected, graphHandler.paths(gNode));
    }

}