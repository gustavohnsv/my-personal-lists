import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList doublyLinkedList;

    @BeforeEach
    void setUp() {
        doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addNode(2);
        doublyLinkedList.addNode(1);
        doublyLinkedList.addNode(3);
    }

    @Test
    void isEmpty() {
        BinaryTree empty = new BinaryTree();
        assertTrue(empty.isEmpty());
        assertFalse(doublyLinkedList.isEmpty());
    }

    @Test
    void addNode() {
        assertTrue(doublyLinkedList.containsNode(2));
        assertTrue(doublyLinkedList.containsNode(1));
        assertTrue(doublyLinkedList.containsNode(3));
        assertFalse(doublyLinkedList.containsNode(4));

        doublyLinkedList.addNode(4);
        assertTrue(doublyLinkedList.containsNode(4));
    }

    @Test
    void removeNode() {
        assertTrue(doublyLinkedList.containsNode(2));
        doublyLinkedList.removeNode(2);
        assertFalse(doublyLinkedList.containsNode(2));

        assertTrue(doublyLinkedList.containsNode(1));
        doublyLinkedList.removeNode(1);
        assertFalse(doublyLinkedList.containsNode(1));

        assertTrue(doublyLinkedList.containsNode(3));
        doublyLinkedList.removeNode(3);
        assertFalse(doublyLinkedList.containsNode(3));
    }

    @Test
    void modifyNode() {
        assertTrue(doublyLinkedList.containsNode(2));
        doublyLinkedList.modifyNode(2, 4);
        assertFalse(doublyLinkedList.containsNode(2));
        assertTrue(doublyLinkedList.containsNode(4));

        assertTrue(doublyLinkedList.containsNode(1));
        doublyLinkedList.modifyNode(1, 5);
        assertFalse(doublyLinkedList.containsNode(1));
        assertTrue(doublyLinkedList.containsNode(5));
    }

    @Test
    void findNode() {
        assertNotNull(doublyLinkedList.findNode(2));
        assertNotNull(doublyLinkedList.findNode(1));
        assertNotNull(doublyLinkedList.findNode(3));
        assertNull(doublyLinkedList.findNode(4));

        doublyLinkedList.addNode(4);
        assertNotNull(doublyLinkedList.findNode(4));
    }

    @Test
    void printNodes() {
        doublyLinkedList.printNodes();
    }

    @Test
    void printNode() {
        doublyLinkedList.printNode(2);
        doublyLinkedList.printNode(1);
        doublyLinkedList.printNode(3);
    }

    @Test
    void containsNode() {
        assertTrue(doublyLinkedList.containsNode(2));
        assertTrue(doublyLinkedList.containsNode(1));
        assertTrue(doublyLinkedList.containsNode(3));
        assertFalse(doublyLinkedList.containsNode(4));

        doublyLinkedList.addNode(4);
        assertTrue(doublyLinkedList.containsNode(4));
    }

    @Test
    void subList() {
        DoublyLinkedList sublist = doublyLinkedList.subList(1, 2);
        assertTrue(sublist.containsNode(1));
        assertFalse(sublist.containsNode(2));
        assertFalse(sublist.containsNode(3));

        DoublyLinkedList sublistEmpty = doublyLinkedList.subList(4, 5);
        assertTrue(sublistEmpty.isEmpty());
    }

    @Test
    void findMax() {
        assertEquals(3, doublyLinkedList.findMax(doublyLinkedList));

        doublyLinkedList.addNode(5);
        assertEquals(5, doublyLinkedList.findMax(doublyLinkedList));

        doublyLinkedList.removeNode(5);
        assertEquals(3, doublyLinkedList.findMax(doublyLinkedList));
    }

    @Test
    void findMin() {
        assertEquals(1, doublyLinkedList.findMin(doublyLinkedList));

        doublyLinkedList.addNode(0);
        assertEquals(0, doublyLinkedList.findMin(doublyLinkedList));

        doublyLinkedList.removeNode(0);
        assertEquals(1, doublyLinkedList.findMin(doublyLinkedList));
    }

}