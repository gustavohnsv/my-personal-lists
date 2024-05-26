import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SparceMatriceTest {

    private SparceMatrice sparceMatrice;

    @BeforeEach
    void setUp() {
        sparceMatrice = new SparceMatrice();
    }

    @Test
    void isEmpty() {
        assertTrue(sparceMatrice.isEmpty());
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        assertFalse(sparceMatrice.isEmpty());
    }

    @Test
    void setCoordinatedNode() {
        assertTrue(sparceMatrice.setCoordinatedNode(3.0, 1, 0));
        assertTrue(sparceMatrice.containsNode(3.0));
        assertTrue(sparceMatrice.setCoordinatedNode(1.0, 0, 0));
        assertTrue(sparceMatrice.containsNode(1.0));
        assertTrue(sparceMatrice.setCoordinatedNode(2.0, 1, 2));
        assertTrue(sparceMatrice.containsNode(2.0));
    }

    @Test
    void removeNode() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        assertTrue(sparceMatrice.removeNode(1.0));
        assertFalse(sparceMatrice.removeNode(2.0));
    }

    @Test
    void modifyNode() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        assertTrue(sparceMatrice.modifyNode(1.0, 2.0));
        assertNotNull(sparceMatrice.findNode(2.0));
        assertNull(sparceMatrice.findNode(1.0));
    }

    @Test
    void findNode() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        assertNotNull(sparceMatrice.findNode(1.0));
        assertNull(sparceMatrice.findNode(2.0));
    }

    @Test
    void printNodes() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        sparceMatrice.setCoordinatedNode(2.0, 1, 1);
        sparceMatrice.printNodes();
    }

    @Test
    void printNode() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        sparceMatrice.printNode(1.0);
    }

    @Test
    void containsNode() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        assertTrue(sparceMatrice.containsNode(1.0));
        assertFalse(sparceMatrice.containsNode(2.0));
    }

    @Test
    void subList() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        sparceMatrice.setCoordinatedNode(2.0, 1, 1);
        SparceMatrice subMatrix = sparceMatrice.subList(0, 2, 0, 2);
        assertNotNull(subMatrix.findNode(1.0));
        assertNotNull(subMatrix.findNode(2.0));
    }

    @Test
    void findMax() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        sparceMatrice.setCoordinatedNode(2.0, 1, 1);
        assertEquals(2.0, sparceMatrice.findMax(sparceMatrice));
    }

    @Test
    void findMin() {
        sparceMatrice.setCoordinatedNode(1.0, 0, 0);
        sparceMatrice.setCoordinatedNode(2.0, 1, 1);
        assertEquals(1.0, sparceMatrice.findMin(sparceMatrice));
    }
}
