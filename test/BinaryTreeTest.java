import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        binaryTree = new BinaryTree();
        binaryTree.addNode(2);
        binaryTree.addNode(1);
        binaryTree.addNode(3);
    }

    @Test
    void isEmpty() {
        BinaryTree emptyTree = new BinaryTree();
        assertTrue(emptyTree.isEmpty());
        assertFalse(binaryTree.isEmpty());
    }

    @Test
    void addNode() {
        assertTrue(binaryTree.containsNode(2));
        assertTrue(binaryTree.containsNode(1));
        assertTrue(binaryTree.containsNode(3));
        assertFalse(binaryTree.containsNode(4));

        binaryTree.addNode(4);
        assertTrue(binaryTree.containsNode(4));
    }

    @Test
    void removeNode() {
        assertTrue(binaryTree.containsNode(2));
        binaryTree.removeNode(2);
        assertFalse(binaryTree.containsNode(2));

        assertTrue(binaryTree.containsNode(1));
        binaryTree.removeNode(1);
        assertFalse(binaryTree.containsNode(1));

        assertTrue(binaryTree.containsNode(3));
        binaryTree.removeNode(3);
        assertFalse(binaryTree.containsNode(3));
    }

    @Test
    void modifyNode() {
        assertTrue(binaryTree.containsNode(2));
        binaryTree.modifyNode(2, 4);
        assertFalse(binaryTree.containsNode(2));
        assertTrue(binaryTree.containsNode(4));

        assertTrue(binaryTree.containsNode(1));
        binaryTree.modifyNode(1, 5);
        assertFalse(binaryTree.containsNode(1));
        assertTrue(binaryTree.containsNode(5));
    }

    @Test
    void findNode() {
        assertNotNull(binaryTree.findNode(2));
        assertNotNull(binaryTree.findNode(1));
        assertNotNull(binaryTree.findNode(3));
        assertNull(binaryTree.findNode(4));

        binaryTree.addNode(4);
        assertNotNull(binaryTree.findNode(4));
    }

    @Test
    void printNodes() {
        binaryTree.printNodes();
    }

    @Test
    void printNode() {
        binaryTree.printNode(2);
        binaryTree.printNode(1);
        binaryTree.printNode(3);
    }

    @Test
    void containsNode() {
        assertTrue(binaryTree.containsNode(2));
        assertTrue(binaryTree.containsNode(1));
        assertTrue(binaryTree.containsNode(3));
        assertFalse(binaryTree.containsNode(4));

        binaryTree.addNode(4);
        assertTrue(binaryTree.containsNode(4));
    }

    @Test
    void subList() {
        BinaryTree sublist = binaryTree.subList(1, 2);
        assertTrue(sublist.containsNode(1));
        assertFalse(sublist.containsNode(2));
        assertFalse(sublist.containsNode(3));

        BinaryTree sublistEmpty = binaryTree.subList(4, 5);
        assertTrue(sublistEmpty.isEmpty());
    }

    @Test
    void findMax() {
        assertEquals(3, binaryTree.findMax(binaryTree));

        binaryTree.addNode(5);
        assertEquals(5, binaryTree.findMax(binaryTree));

        binaryTree.removeNode(5);
        assertEquals(3, binaryTree.findMax(binaryTree));
    }

    @Test
    void findMin() {
        assertEquals(1, binaryTree.findMin(binaryTree));

        binaryTree.addNode(0);
        assertEquals(0, binaryTree.findMin(binaryTree));

        binaryTree.removeNode(0);
        assertEquals(1, binaryTree.findMin(binaryTree));
    }

}
