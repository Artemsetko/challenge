package cisco.java.challenge;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GNodeImplTest {

    GNodeImpl gNode;

    @Before
    public void setUp() throws Exception {
        gNode = new GNodeImpl("Start");
    }

    @Test
    public void setChildren() {
        GNode[] children = new GNode[3];
        children[0] = new GNodeImpl("testA");
        children[1] = new GNodeImpl("testB");
        children[2] = new GNodeImpl("testC");

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
        gNode = new GNodeImpl("Start");
        GNodeImpl nodeA = new GNodeImpl("A");
        GNodeImpl nodeB = new GNodeImpl("B");
        GNodeImpl nodeC = new GNodeImpl("C");
        gNode.setChildren(new GNode[]{nodeA});
        nodeA.setChildren(new GNode[]{nodeB, nodeC});

        ArrayList<GNode> gNodeList = new ArrayList();
        gNodeList.add(gNode);
        gNodeList.add(nodeA);
        gNodeList.add(nodeB);
        gNodeList.add(nodeC);

        ArrayList<GNode> actual = gNode.walkGraph(gNode);

        Assert.assertEquals(actual, gNodeList);
    }

    @Test
    public void paths() {
        gNode = new GNodeImpl("Start");
        GNodeImpl nodeA = new GNodeImpl("A");
        GNodeImpl nodeB = new GNodeImpl("B");
        GNodeImpl nodeC = new GNodeImpl("C");
        gNode.setChildren(new GNode[]{nodeA});
        nodeA.setChildren(new GNode[]{nodeB, nodeC});

        ArrayList<ArrayList<GNodeImpl>> expected = new ArrayList<>();

        ArrayList<GNodeImpl> pathOne = new ArrayList<>();
        pathOne.add(gNode);
        pathOne.add(nodeA);
        pathOne.add(nodeB);

        ArrayList<GNodeImpl> pathTwo = new ArrayList<>();
        pathTwo.add(gNode);
        pathTwo.add(nodeA);
        pathTwo.add(nodeC);

        expected.add(pathOne);
        expected.add(pathTwo);

        Assert.assertEquals(expected, gNode.paths(gNode));
    }

}