import java.util.Stack;

public class Node {
    final int value;
    Node left = null;
    Node right = null;
    boolean red = false;

    Node(int value) {
        this.value = value;
    }

    public String display() {
        String result = "";
        if (left != null) {
            result += left.display() + " ";
        }
        result += value + " ";
        if (right != null) {
            result += right.display() + " ";
        }
        return result.substring(0, result.length() -1);
    }

    public Node get(int value) {
        if (value == this.value) {
            return this;
        } else if (value < this.value && left != null) {
            left.get(value);
        } else if (/*value > this.value && */ right != null) {
            right.get(value);
        }
        return null;
    }

    public void insert(int value) {
        if (value <= this.value) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else /*if (value > this.value)*/{
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public int depth() {
        int depth = 0;
        if (left != null)
            depth = Math.max(depth, left.depth());
        if (right != null)
            depth = Math.max(depth, right.depth());
        return depth +1;
    }
}
