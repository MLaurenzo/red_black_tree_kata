import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DisplayTest {

    @Test
    public void displayEmpty() {
        Tree tree = new Tree();

        Assert.assertEquals("", tree.display());
    }

    @Test
    public void displayFull() {
        Tree tree = new Tree();
        List<Integer> insertions = Arrays.asList(5, 3, 2, 4, 7, 6, 8);
        insertions.forEach(i -> tree.insert(i));
        Assert.assertEquals("2 3 4 5 6 7 8", tree.display());
    }
}
