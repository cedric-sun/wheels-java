package cedric;

/**
 * The ordinary binary search tree.
 */
public class BST<K extends Comparable<K>, V> {
    Node root;

    class Node {
        K key;
        V value;
        Node leftChild, rightChild;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public BST() {

    }

    /**
     * Put new k-V record.
     *
     * @param key
     * @param value
     * @return true if put successfully (no key collision); false if the key collides.
     */
    public boolean put(K key, V value) {
        return internalPut(root,null, key, value) != null;
    }

    private Node internalPut(Node root, Node parent, K key, V value) {
        if (root == null) {
            root = new Node(key, value);
            if (parent == null)

            return root;
        }
        int flag = root.key.compareTo(key);
        if (flag < 0)
            return internalPut(root.rightChild, key, value);
        else if (flag > 0)
            return internalPut(root.leftChild, key, value);
        else
            return null;
    }

    /**
     * Get value by key
     *
     * @param key
     * @return the value associated with key on success; null if no such value.
     */
    public V get(K key) {
        Node node = internalGet(root, key);
        if (node == null)
            return null;
        else
            return node.value;
    }

    public Node internalGet(Node root, K key) {
        if (root == null)
            return null;
        int flag = root.key.compareTo(key);
        if (flag < 0)
            return internalGet(root.rightChild, key);
        else if (flag>0)
            return internalGet(root.leftChild, key);
        else
            return root;
    }

    public void delete(K key) {

    }
}
