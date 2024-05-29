import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList();
        linkedList.addNode(2);
        linkedList.addNode(1);
        linkedList.addNode(3);
    }

    @Test
    void isEmpty() {
        LinkedList empty = new LinkedList();
        assertTrue(empty.isEmpty());
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void addNode() {
        assertTrue(linkedList.containsNode(2));
        assertTrue(linkedList.containsNode(1));
        assertTrue(linkedList.containsNode(3));
        assertFalse(linkedList.containsNode(4));

        linkedList.addNode(4);
        assertTrue(linkedList.containsNode(4));
    }

    @Test
    void removeNode() {
        assertTrue(linkedList.containsNode(2));
        linkedList.removeNode(2);
        assertFalse(linkedList.containsNode(2));

        assertTrue(linkedList.containsNode(1));
        linkedList.removeNode(1);
        assertFalse(linkedList.containsNode(1));

        assertTrue(linkedList.containsNode(3));
        linkedList.removeNode(3);
        assertFalse(linkedList.containsNode(3));
    }

    @Test
    void modifyNode() {
        assertTrue(linkedList.containsNode(2));
        linkedList.modifyNode(2, 4);
        assertFalse(linkedList.containsNode(2));
        assertTrue(linkedList.containsNode(4));

        assertTrue(linkedList.containsNode(1));
        linkedList.modifyNode(1, 5);
        assertFalse(linkedList.containsNode(1));
        assertTrue(linkedList.containsNode(5));
    }

    @Test
    void findNode() {
        assertNotNull(linkedList.findNode(2));
        assertNotNull(linkedList.findNode(1));
        assertNotNull(linkedList.findNode(3));
        assertNull(linkedList.findNode(4));

        linkedList.addNode(4);
        assertNotNull(linkedList.findNode(4));
    }

    @Test
    void printNodes() {
        linkedList.printNodes();
    }

    @Test
    void printNode() {
        linkedList.printNode(2);
        linkedList.printNode(1);
        linkedList.printNode(3);
    }

    @Test
    void containsNode() {
        assertTrue(linkedList.containsNode(2));
        assertTrue(linkedList.containsNode(1));
        assertTrue(linkedList.containsNode(3));
        assertFalse(linkedList.containsNode(4));

        linkedList.addNode(4);
        assertTrue(linkedList.containsNode(4));
    }

    @Test
    void subList() {
        LinkedList sublist = linkedList.subList(1, 2);
        assertTrue(sublist.containsNode(1));
        assertFalse(sublist.containsNode(2));
        assertFalse(sublist.containsNode(3));

        LinkedList sublistEmpty = linkedList.subList(4, 5);
        assertTrue(sublistEmpty.isEmpty());
    }

    @Test
    void findMax() {
        assertEquals(3, linkedList.findMax(linkedList));

        linkedList.addNode(5);
        assertEquals(5, linkedList.findMax(linkedList));

        linkedList.removeNode(5);
        assertEquals(3, linkedList.findMax(linkedList));
    }

    @Test
    void findMin() {
        assertEquals(1, linkedList.findMin(linkedList));

        linkedList.addNode(0);
        assertEquals(0, linkedList.findMin(linkedList));

        linkedList.removeNode(0);
        assertEquals(1, linkedList.findMin(linkedList));
    }

}