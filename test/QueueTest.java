import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private Queue Queue;

    @BeforeEach
    void setUp() {
        Queue = new Queue();
        Queue.addNode(2);
        Queue.addNode(1);
        Queue.addNode(3);
    }

    @Test
    void isEmpty() {
        Queue empty = new Queue();
        assertTrue(empty.isEmpty());
        assertFalse(Queue.isEmpty());
    }

    @Test
    void addNode() {
        assertTrue(Queue.containsNode(2));
        assertTrue(Queue.containsNode(1));
        assertTrue(Queue.containsNode(3));
        assertFalse(Queue.containsNode(4));

        Queue.addNode(4);
        assertTrue(Queue.containsNode(4));
    }

    @Test
    void removeNode() {
        assertTrue(Queue.containsNode(2));
        Queue.removeNode(2);
        assertFalse(Queue.containsNode(2));

        assertTrue(Queue.containsNode(1));
        Queue.removeNode(1);
        assertFalse(Queue.containsNode(1));

        assertTrue(Queue.containsNode(3));
        Queue.removeNode(3);
        assertFalse(Queue.containsNode(3));
    }

    @Test
    void modifyNode() {
        assertTrue(Queue.containsNode(2));
        Queue.modifyNode(2, 4);
        assertFalse(Queue.containsNode(2));
        assertTrue(Queue.containsNode(4));

        assertTrue(Queue.containsNode(1));
        Queue.modifyNode(1, 5);
        assertFalse(Queue.containsNode(1));
        assertTrue(Queue.containsNode(5));
    }

    @Test
    void findNode() {
        assertNotNull(Queue.findNode(2));
        assertNotNull(Queue.findNode(1));
        assertNotNull(Queue.findNode(3));
        assertNull(Queue.findNode(4));

        Queue.addNode(4);
        assertNotNull(Queue.findNode(4));
    }

    @Test
    void printNodes() {
        Queue.printNodes();
    }

    @Test
    void printNode() {
        Queue.printNode(2);
        Queue.printNode(1);
        Queue.printNode(3);
    }

    @Test
    void containsNode() {
        assertTrue(Queue.containsNode(2));
        assertTrue(Queue.containsNode(1));
        assertTrue(Queue.containsNode(3));
        assertFalse(Queue.containsNode(4));

        Queue.addNode(4);
        assertTrue(Queue.containsNode(4));
    }

    @Test
    void subList() {
        Queue sublist = Queue.subList(1, 2);
        assertTrue(sublist.containsNode(1));
        assertFalse(sublist.containsNode(2));
        assertFalse(sublist.containsNode(3));

        Queue sublistEmpty = Queue.subList(4, 5);
        assertTrue(sublistEmpty.isEmpty());
    }
}