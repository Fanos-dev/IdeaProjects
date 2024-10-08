import java.util.Stack;

public class BST<E> implements Tree<E> {
    protected TreeNode<E> root;
    protected int size = 0;
    protected java.util.Comparator<E> c;

    /** Create a default BST with a natural order comparator */
    public BST() {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
    }

    /** Create a BST with a specified comparator */
    public BST(java.util.Comparator<E> c) {
        this.c = c;
    }

    /** Create a binary tree from an array of objects */
    public BST(E[] objects) {
        this.c = (e1, e2) -> ((Comparable<E>)e1).compareTo(e2);
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override /* Returns true if the element is in the tree */
    public boolean search(E e) {
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if (c.compare(e, current.element) > 0) {
                current = current.right;
            }
            else // element matches current.element
                return true; // Element is found
        }

        return false;
    }

    @Override /* Insert element e into the binary tree
      Return true if the element is inserted successfully */
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e); // Create a new root
        else {
            // Locate the parent node
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null)
                if (c.compare(e, current.element) < 0) {
                    parent = current;
                    current = current.left;
                }
                else if (c.compare(e, current.element) > 0) {
                    parent = current;
                    current = current.right;
                }
                else
                    return false; // Duplicate node not inserted

            // Create the new node and attach it to the parent node
            if (c.compare(e, parent.element) < 0)
                parent.left = createNewNode(e);
            else
                parent.right = createNewNode(e);
        }

        size++;
        return true; // Element inserted successfully
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e, null, null);
    }

    @Override /* Inorder traversal from the root */
    public void inorder() {
        inorder(root);
    }

    /** Inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override /* Postorder traversal from the root */
    public void postorder() {
        postorder(root);
    }

    /** Postorder traversal from a subtree */
    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override /* Preorder traversal from the root */
    public void preorder() {
        preorder(root);
    }

    /** Preorder traversal from a subtree */
    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    /** This inner class is static, because it does not access
     any instance members defined in its outer class */
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode() {

        }
        public TreeNode(E e, TreeNode<E> leftChild, TreeNode<E> rightChild) {
            element = e;
            left=leftChild;
            right= rightChild;

        }
    }

    @Override /* Get the number of nodes in the tree */
    public int getSize() {
        return size;
    }

    /** Returns the root of the tree */
    public TreeNode<E> getRoot() {
        return root;
    }

    /** Returns a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list =
                new java.util.ArrayList<>();
        TreeNode<E> current = root; // Start from the root

        while (current != null) {
            list.add(current); // Add the node to the list
            if (c.compare(e, current.element) < 0) {
                current = current.left;
            }
            else if (c.compare(e, current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }

        return list; // Return an array list of nodes
    }

    @Override /* Delete an element from the binary tree
	  using the deletion by copying approach
      Return true if the element is deleted successfully
      Return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break; // Element is in the tree pointed at by current
        }

        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            }
            else {
                if (c.compare(e, parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }

        size--; // Reduce the size of the tree
        return true; // Element deleted successfully
    }

    @Override /* Obtain an iterator. Use inorder. */
    public java.util.Iterator<E> iterator() {
        return new InorderIterator();
    }
	
	/** Delete an element from the binary tree
	 * using the deletion by merging approach
     * Return true if the element is deleted successfully
     * Return false if the element is not in the tree */
    public boolean deleteByMerging(E e) {
        // add your code here
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        // Find element to delete
        while (current != null) {
            if (c.compare(e, current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (c.compare(e, current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break; // Element is in the tree pointed at by current
            }
        }

        // Element is not in the tree
        if (current == null) {
            return false;
        }

        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            }
            else {
                if (c.compare(e, parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {
            //Find rightmost in left subtree
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                rightMost = rightMost.right; // Keep going to the right
            }

            //Link rightmost with right subtree
            rightMost.right = current.right;
            current.right = null;

            //Delete the node
            if (parent == null){
                root = current.left;
            } else {
                if (parent.left == current) {
                    parent.left = current.left;
                } else if (parent.right == current) {
                    parent.right = current.left;
                }
            }
        }

        size--;
        return true;
    }

	
	/** uses a loop to traverse a BST in a post-order fashion
	* Hint: You need an explicit stack in your code to 
	* implement this method*/

    public  void iterativePostorder() {
		// Add your code here
        if (root == null) {
            return;
        }
        Stack<TreeNode<E>> firstStack = new Stack<>();
        Stack<TreeNode<E>> secondStack = new Stack<>();

        firstStack.push(root);

        while (!firstStack.isEmpty()) {
            //Pop top node from first stack and push  to second stack
            TreeNode<E> temp = firstStack.pop();
            secondStack.push(temp);

            if (temp.left != null) {
                firstStack.push(temp.left);
            }
            if (temp.right != null) {
                firstStack.push(temp.right);
            }
        }

        //Pop all elements of second stack
        while (!secondStack.isEmpty()) {
            TreeNode<E> temp = secondStack.pop();
            System.out.print(temp.element + " ");
        }
    }
	
	/** Returns the height of this binary tree, i.e., the 
	* number of the nodes in the longest path of the root to a leaf
	* NB:- this is best implemented as a recursive algorithm */

    public int getHeight(){
		return height(root); // you may change what is returned here
    }

    public int height(TreeNode<E> node){
        if(node == null){
            return 0;
        }
        //Recursive function to get heights for the left and right
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        if (node == root){
            return Math.max(leftHeight, rightHeight);
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

	/*creates a mirror image of the original binary tree. */ 
    public void mirrorOf(TreeNode<E> node){
        //Swap the left and right
        if (node != null) {
            mirrorOf(node.left);
            mirrorOf(node.right);

            TreeNode<E> temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
    }

    public void convertToMirrorImage(){
        mirrorOf(root);
    }

    // Inner class InorderIterator
    private class InorderIterator implements java.util.Iterator<E> {
        // Store the elements in a list
        private java.util.ArrayList<E> list =
                new java.util.ArrayList<>();
        private int current = 0; // Point to the current element in list

        public InorderIterator() {
            inorder(); // Traverse binary tree and store elements in list
        }

        /** Inorder traversal from the root*/
        private void inorder() {
            inorder(root);
        }

        /** Inorder traversal from a subtree */
        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
        }

        @Override /* More elements for traversing? */
        public boolean hasNext() {
            if (current < list.size())
                return true;

            return false;
        }

        @Override /* Get the current element and move to the next */
        public E next() {
            return list.get(current++);
        }

        @Override // Remove the element returned by the last next()
        public void remove() {
            if (current == 0) // next() has not been called yet
                throw new IllegalStateException();

            delete(list.get(--current));
            list.clear(); // Clear the list
            inorder(); // Rebuild the list
        }
    }

    @Override /* Remove all elements from the tree */
    public void clear() {
        root = null;
        size = 0;
    }
}