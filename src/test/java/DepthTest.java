import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DepthTest {

    @Test
    public void emptyTree() {
        Tree tree = new Tree();

        Assert.assertEquals(0, tree.depth());
    }

    @Test
    public void unbalancedTree() {
        Tree tree = new Tree();
        List<Integer> insertions = Arrays.asList(5, 6, 8);
        insertions.forEach(i -> tree.insert(i));
        Assert.assertEquals(3, tree.depth());
    }

    @Test
    public void balancedTree() {
        Tree tree = new Tree();
        List<Integer> insertions = Arrays.asList(5, 3, 2, 4, 7, 6, 8);
        insertions.forEach(i -> tree.insert(i));
        Assert.assertEquals(3, tree.depth());
    }
}