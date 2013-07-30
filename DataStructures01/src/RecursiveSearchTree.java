/**
 * This is an implementation of a binary search tree with recursive functions for inserting and searching.
 */
public class RecursiveSearchTree {

    /**
     * A simple node class.
     * Each node stores a value and references (possibly null) to subtrees of greater and lesser values.
     */
    private class TreeNode {
        int value;
        TreeNode lesser;
        TreeNode greater;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    /** The root node of the tree. For an empty tree this is null. */
    TreeNode rootNode;

    /**
     * Add a new integer to the tree in the proper place.
     * @param value A new integer to insert into the tree.
     */
    public void insert(int value) {
        if (rootNode==null) {
            rootNode = new TreeNode(value);
        } else {
            insert(value,rootNode);
        }
    }

    /**
     * A private function for recursively inserting an element in the tree.
     * @param value The value to insert.
     * @param node The value will be inserted somewhere in the subtree under this node.
     */
    private void insert(int value, TreeNode node) {
        if (value==node.value) {
            // If the value is already in the tree, just return.
            return;
        } else if (value<node.value) {
            // If the value is less than node.value, insert it somewhere in the lesser subtree.
            if (node.lesser==null) {
                // If this subtree doesn't exist, create it with the new value.
                node.lesser = new TreeNode(value);
            } else {
                insert(value,node.lesser);
            }
        } else {
            // If the value is greater than node.value insert it in the greater subtree.
            if (node.greater==null) {
                node.greater = new TreeNode(value);
            } else {
                insert(value,node.greater);
            }
        }
    }

    /**
     * Check if a given value exists in the tree.
     * @param value The value to look for.
     * @return A boolean indicating whether the value is the in the tree.
     */
    public boolean search(int value) {
        return search(value, rootNode);
    }

    /**
     * Recursively check if the value exists in the subtree with node as root.
     * @param value The int to look for.
     * @param node The root of the current subtree.
     * @return A boolean indicating whether the value is found in this subtree.
     */
    private boolean search(int value, TreeNode node) {
        if (node==null) {
            // Case 0: the subtree is null and doesn't contain the value.
            return false;
        } else if (node.value==value) {
            // Case 1: the value is at the head of the tree, so we don't need to look further.
            return true;
        } else if (value<node.value) {
            // Case 2: the value is less than node.value, so keep looking in the lesser subtree.
            return search(value, node.lesser);
        } else {
            // Case 3: the value is greater than node.value, so keep looking in the greater subtree.
            return search(value, node.greater);
        }
    }
}
