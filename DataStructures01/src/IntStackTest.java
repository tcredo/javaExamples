import org.junit.Test;
import static org.junit.Assert.*;

public class IntStackTest {

    @Test
    public void testStack() throws Exception {
        IntStack stack = new IntStack();
        for (int i=0;i<10;i++) {
            stack.push(i);
        }
        for (int i=9;i>=0;i--) {
            assertEquals(stack.pop(),i);
        }
    }

    @Test
    public void testEmptyStack() throws Exception {
        IntStack stack = new IntStack();
        boolean thrown = false;
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
}
