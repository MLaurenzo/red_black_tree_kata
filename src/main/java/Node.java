public class Node {
    int value;
    Node left = null;
    Node right = null;
    Node parent = null;
    boolean red = true;

    Node(int value) {
        this(value, null);
    }

    Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

    public Node clone() {
        Node node = new Node(value);
        node.red = red;
        return node;
    }

    public void copy(Node node) {
        value = node.value;
        left = node.left;
        right = node.right;
        red = node.red;
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

    public Node getUncle() {
        if (parent == null) {
            return null;
        }
        if (parent.left == this) {
            return parent.right;
        } else {
            return parent.left;
        }
    }

    public Node insert(int value) {
        if (value <= this.value) {
            if (left == null) {
                left = new Node(value, this);
                return left;
            } else {
                return left.insert(value);
            }
        } else /*if (value > this.value)*/{
            if (right == null) {
                right = new Node(value, this);
                return right;
            } else {
                return right.insert(value);
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
