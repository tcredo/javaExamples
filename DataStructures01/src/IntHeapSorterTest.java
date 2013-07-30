import org.junit.Test;
import static org.junit.Assert.*;

public class IntHeapSorterTest {

    @Test
    public void testSort() throws Exception {
        int[] array = new int[41];
        for (int i=0;i<41;i++) {
            array[i] = (29*i)%41;
        }
        IntHeapSorter.sort(array);
        for (int i=0;i<41;i++) {
            assertEquals(i,array[i]);
        }
        array = new int[83];
        for (int i=0;i<83;i++) {
            array[i] = (29*i)%83;
        }
        IntHeapSorter.sort(array);
        for (int i=0;i<83;i++) {
            assertEquals(i,array[i]);
        }
    }
}
