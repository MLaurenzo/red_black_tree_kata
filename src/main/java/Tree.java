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
        Node node;
        if (root == null) {
            root = new Node(value);
            root.red = false;
            node = root;
        } else {
            node = root.insert(value);
        }
        repair_tree(node);
        System.out.println(root.display());
    }

    static void repair_tree(Node node) {
        if (node.parent == null) { // this node is the root
            node.red = false; // the root must be black
        } else if (node.parent.red == false) {
            // nothing needs to be done
            // it is like splitting the black node into another black empty node
            // and a red node having 2 black empty nodes
            // so the black depth property is kept
        } else if (node.getUncle() != null && node.getUncle().red == true) {
            node.parent.red = false;
            node.getUncle().red = false;
            // my parent is red so it cannot be the root, so I have a grand parent
            node.parent.parent.red = true;
            repair_tree(node.parent.parent);
        } else {
            Node parent = node.parent;
            Node grandParent = parent.parent;
            if (grandParent.left != null && grandParent.left.right != null &&
                    node == grandParent.left.right) {
                rotate_left(parent);
            } else if (grandParent.right != null && grandParent.right.left != null &&
                    node == grandParent.right.left) {
                rotate_right(parent);
            }
            parent = node.parent;
            grandParent = parent.parent;
            if (node == parent.left) {
                rotate_right(grandParent);
            } else {
                rotate_left(grandParent);
            }
            parent.red = false;
            grandParent.red = true;
        }
    }

    static public void rotate_left(Node node) {
        Node newLeftNode = node.clone();
        newLeftNode.left = node.left;
        node.copy(node.right);
        node.left = newLeftNode;
        newLeftNode.parent = node;
    }

    static public void rotate_right(Node node) {
        Node newRightNode = node.clone();
        newRightNode.right = node.right;
        node.copy(node.left);
        node.right = newRightNode;
        newRightNode.parent = node;
    }

    public int depth() {
        if (root == null) {
            return 0;
        } else {
            return root.depth();
        }
    }
}
