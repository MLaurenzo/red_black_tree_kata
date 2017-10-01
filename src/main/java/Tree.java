public class Tree {
    private Node root;

    public String display() {
        if (root == null)
            return "";
        else
            return root.display();
    }

    public Node get(int value) {
        if (root == null) {
            return null;
        } else {
            return root.get(value);
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    public int depth() {
        if (root == null) {
            return 0;
        } else {
            return root.depth();
        }
    }
}
