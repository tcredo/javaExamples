import org.junit.Test;
import static org.junit.Assert.*;

public class IntHeapArrayTest {
    @Test
    public void testHeap() throws Exception {
        IntHeapArray heap = new IntHeapArray(100);
        for (int i=0;i<41;i++) {
            // Insert the numbers out of order.
            heap.insert((29*i)%41);
        }
        for (int i=40;i>=0;i--) {
            assertEquals(heap.pop(),i);
        }
    }

    @Test
    public void testCapacity() throws Exception {
        IntHeapArray heap = new IntHeapArray(5);
        for (int i=0;i<5;i++) {
            assertTrue(heap.insert(i));
        }
        assertFalse(heap.insert(0));
        heap.pop();
        assertTrue(heap.insert(0));
    }

    @Test
    public void testEmptyHeap() throws Exception {
        IntHeapArray heap = new IntHeapArray(5);
        boolean thrown = false;
        try {
            heap.pop();
        } catch (IllegalStateException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
