package classimplementation;

public class BinarySearchTree<T extends Comparable> {

    private Node<T> head;

    public void add(T value) {
        if (head == null) {
            head = new Node<>(value);
        } else {
            insert(head, value);
        }
    }

    private void insert(Node<T> node, T value) {
        int cmp = node.value.compareTo(value);
        if (cmp < 0) {
            if (node.right == null) {
                node.right = new Node<>(value);
            } else {
                insert(node.right, value);
            }
        } else if (cmp > 0) {
            if (node.left == null) {
                node.left = new Node<>(value);
            } else {
                insert(node.left, value);
            }
        }
    }

    public boolean contains(T value) {
        return search(head, value) != null;
    }

    private Node<T> search(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = node.value.compareTo(value);
        if (cmp < 0) {
            return search(node.right, value);
        } else if (cmp > 0) {
            return search(node.left, value);
        } else {
            return node;
        }
    }

    public boolean delete(T value) {
        return deleteNode(head, value) != null;
    }

    private Node<T> deleteNode(Node<T> node, T value) {
        if (node == null) {
            return null;
        }
        int cmp = node.value.compareTo(value);
        if (cmp < 0) {
            node.right = deleteNode(node.right, value);
        } else if (cmp > 0) {
            node.left = deleteNode(node.left, value);
        } else {
            if (node.left != null && node.right != null) {
                Node<T> minNode = findMinimum(node.right);
                node.value = minNode.value;
                node.right = deleteNode(node.right, minNode.value);
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        return node;
    }

    private Node<T> findMinimum(Node<T> node) {
        if (node.left == null) {
            return node;
        } else {
            return findMinimum(node.left);
        }
    }

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        public Node(T value) {
            this.value = value;
        }
    }
}
