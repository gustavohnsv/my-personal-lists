import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleEndedQueueTest {

    private DoubleEndedQueue doubleEndedQueue;

    @BeforeEach
    void setUp() {
        doubleEndedQueue = new DoubleEndedQueue();
        doubleEndedQueue.addNode(2);
        doubleEndedQueue.addNode(1);
        doubleEndedQueue.addNode(3);
    }

    @Test
    void isEmpty() {
        BinaryTree empty = new BinaryTree();
        assertTrue(empty.isEmpty());
        assertFalse(doubleEndedQueue.isEmpty());
    }

    @Test
    void addNode() {
        assertTrue(doubleEndedQueue.containsNode(2));
        assertTrue(doubleEndedQueue.containsNode(1));
        assertTrue(doubleEndedQueue.containsNode(3));
        assertFalse(doubleEndedQueue.containsNode(4));

        doubleEndedQueue.addNode(4);
        assertTrue(doubleEndedQueue.containsNode(4));
    }

    @Test
    void removeNode() {
        assertTrue(doubleEndedQueue.containsNode(2));
        doubleEndedQueue.removeNode(2);
        assertFalse(doubleEndedQueue.containsNode(2));

        assertTrue(doubleEndedQueue.containsNode(1));
        doubleEndedQueue.removeNode(1);
        assertFalse(doubleEndedQueue.containsNode(1));

        assertTrue(doubleEndedQueue.containsNode(3));
        doubleEndedQueue.removeNode(3);
        assertFalse(doubleEndedQueue.containsNode(3));
    }

    @Test
    void modifyNode() {
        assertTrue(doubleEndedQueue.containsNode(2));
        doubleEndedQueue.modifyNode(2, 4);
        assertFalse(doubleEndedQueue.containsNode(2));
        assertTrue(doubleEndedQueue.containsNode(4));

        assertTrue(doubleEndedQueue.containsNode(1));
        doubleEndedQueue.modifyNode(1, 5);
        assertFalse(doubleEndedQueue.containsNode(1));
        assertTrue(doubleEndedQueue.containsNode(5));
    }

    @Test
    void findNode() {
        assertNotNull(doubleEndedQueue.findNode(2));
        assertNotNull(doubleEndedQueue.findNode(1));
        assertNotNull(doubleEndedQueue.findNode(3));
        assertNull(doubleEndedQueue.findNode(4));

        doubleEndedQueue.addNode(4);
        assertNotNull(doubleEndedQueue.findNode(4));
    }

    @Test
    void printNodes() {
        doubleEndedQueue.printNodes();
    }

    @Test
    void printNode() {
        doubleEndedQueue.printNode(2);
        doubleEndedQueue.printNode(1);
        doubleEndedQueue.printNode(3);
    }

    @Test
    void containsNode() {
        assertTrue(doubleEndedQueue.containsNode(2));
        assertTrue(doubleEndedQueue.containsNode(1));
        assertTrue(doubleEndedQueue.containsNode(3));
        assertFalse(doubleEndedQueue.containsNode(4));

        doubleEndedQueue.addNode(4);
        assertTrue(doubleEndedQueue.containsNode(4));
    }

    @Test
    void subList() {
        DoubleEndedQueue sublist = doubleEndedQueue.subList(1, 2);
        assertTrue(sublist.containsNode(1));
        assertFalse(sublist.containsNode(2));
        assertFalse(sublist.containsNode(3));

        DoubleEndedQueue sublistEmpty = doubleEndedQueue.subList(4, 5);
        assertTrue(sublistEmpty.isEmpty());
    }
}