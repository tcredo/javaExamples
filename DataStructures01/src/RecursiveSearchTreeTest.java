import org.junit.Test;
import static org.junit.Assert.*;

public class RecursiveSearchTreeTest {

    @Test
    public void testTree() throws Exception {
        RecursiveSearchTree tree = new RecursiveSearchTree();
        for (int i=0;i<41;i++) {
            // Insert the numbers out of order.
            tree.insert((29*i)%41);
        }
        for (int i=0;i<41;i++) {
            assertTrue(tree.search(((29 * i) % 41)));
        }
        for (int i=1;i<10;i++) {
            assertFalse(tree.search(-i));
        }
        for (int i=100;i<132;i++) {
            assertFalse(tree.search(i));
        }
    }

    @Test
    public void testEmptyTree() throws Exception {
        RecursiveSearchTree tree = new RecursiveSearchTree();
        for (int i=0;i<10;i++) {
            assertFalse(tree.search(i));
        }
    }
}
