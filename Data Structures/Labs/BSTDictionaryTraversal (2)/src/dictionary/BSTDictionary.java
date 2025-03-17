package dictionary;
import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

public class BSTDictionary {

    // The root node of this BST
    private WordNode root;

    /**
     * This method is provided for you, do not edit it.
     * 
     * This will call your recursive postOrder() method, give it an ArrayList of
     * WordNodes, and then return that list. Your recursive method should fill
     * this list with WordNodes, in pre-order.
     * 
     * @return arraylist containing WordNodes of this tree, ordered via pre-order
     */
    public ArrayList<WordNode> preOrder() {
        // DO NOT EDIT
        ArrayList<WordNode> traversal = new ArrayList<>();
        preOrderHelper(root, traversal);
        return traversal;
    }

    /**
     * This is a recursive helper method for post-order traversal.
     * 
     * You should:
     * 1) return if the curr WordNode is null
     * 2) Add curr to the ArrayList
     * 3) Recursively call this method on curr's left child
     * 4) Recursively call this method on curr's right child
     */
    private void preOrderHelper(WordNode curr, ArrayList<WordNode> list) {
        // Base case: return if the current node is null
        if (curr == null) {
            return;
        }
    
        // Step 1: Add the current node to the list
        list.add(curr);
    
        // Step 2: Recursively traverse the left subtree using the getter
        preOrderHelper(curr.getLeft(), list);
    
        // Step 3: Recursively traverse the right subtree using the getter
        preOrderHelper(curr.getRight(), list);
    }
    
    

    /**
     * This method is provided for you, do not edit it.
     * 
     * This will call your recursive postOrder() method, give it an ArrayList of
     * WordNodes, and then return that list. Your recursive method should fill this
     * list with WordNodes, in post-order.
     * 
     * @return An arraylist containing WordNodes of this tree, ordered via post
     *         order
     */
    public ArrayList<WordNode> postOrder() {
        // DO NOT EDIT
        ArrayList<WordNode> traversal = new ArrayList<>();
        postOrderHelper(root, traversal);
        return traversal;
    }

    /**
     * This is a recursive helper method for post-order traversal.
     * 
     * You should:
     * 1) return if the curr WordNode is null
     * 2) Recursively call this method on curr's left child
     * 3) Recursively call this method on curr's right child
     * 4) Add curr to the ArrayList
     */
    private void postOrderHelper(WordNode curr, ArrayList<WordNode> list) {
        // Base case: return if the current node is null
        if (curr == null) {
            return;
        }
    
        // Step 1: Recursively traverse the left subtree
        postOrderHelper(curr.getLeft(), list);
    
        // Step 2: Recursively traverse the right subtree
        postOrderHelper(curr.getRight(), list);
    
        // Step 3: Add the current node to the list
        list.add(curr);
    }    

    /**
     * This method is provided for you, do not edit it.
     * 
     * This will call your recursive postOrder() method, give it an ArrayList of
     * WordNodes, and then return that list. Your recursive method should fill
     * this list with WordNodes, ordered via in-order.
     * 
     * @return arraylist containing WordNodes of this tree, ordered via in-order
     */
    public ArrayList<WordNode> inOrder() {
        // DO NOT EDIT
        ArrayList<WordNode> traversal = new ArrayList<>();
        inOrderHelper(root, traversal);
        return traversal;
    }

    /**
     * This is a recursive helper method for post-order traversal.
     * 
     * You should:
     * 1) return if the curr WordNode is null
     * 2) Recursively call this method on curr's left child
     * 3) Add curr to the ArrayList
     * 4) Recursively call this method on curr's right child
     */
    private void inOrderHelper(WordNode curr, ArrayList<WordNode> list) {
        // Base case: return if the current node is null
        if (curr == null) {
            return;
        }
    
        // Step 1: Recursively traverse the left subtree
        inOrderHelper(curr.getLeft(), list);
    
        // Step 2: Add the current node to the list
        list.add(curr);
    
        // Step 3: Recursively traverse the right subtree
        inOrderHelper(curr.getRight(), list);
    }    
    /**
     * This method should iteratively traverse the tree, using a Queue.
     * It should fill an ArrayList with WordNodes, ordered via level-order.
     * Finally, return that array list.
     * 
     * To complete this method:
     * 1) Create an ArrayList of WordNodes and a Queue of WordNodes
     * 2) enqueue the root of the tree
     * 3) while the queue is NOT empty:
     * -dequeue a node, add it to the arraylist
     * -if the left child of that node is not null, enqueue it
     * -if the right child of that node is not null, enqueue it
     * 4) return your ArrayList
     * 
     * @return arraylist containing WordNodes of this tree, ordered via level-order
     */

     public ArrayList<WordNode> levelOrder() {
        // Create an ArrayList to store the traversal result
        ArrayList<WordNode> result = new ArrayList<>();
    
        // If the tree is empty, return an empty list
        if (root == null) {
            return result;
        }
    
        // Use LinkedList as a Queue for BFS traversal
        Queue<WordNode> queue = new LinkedList<>();
    
        // Enqueue the root node
        queue.add(root);
    
        // Perform level-order traversal
        while (!queue.isEmpty()) {
            // Dequeue a node and add it to the result list
            WordNode current = queue.poll();
            result.add(current);
    
            // Enqueue the left child if it exists
            if (current.getLeft() != null) {
                queue.add(current.getLeft());
            }
    
            // Enqueue the right child if it exists
            if (current.getRight() != null) {
                queue.add(current.getRight());
            }
        }
    
        // Return the list containing nodes in level-order
        return result;
    }
    

    /**
     * This method is provided for you, do not edit it.
     * 
     * This inserts a new WordNode in this BST, containing the given
     * word and the given definition
     * 
     * @param word       The word to add
     * @param definition The definition of the word
     */
    public void addWord(String word, String definition) {
        // DO NOT EDIT
        if (root == null) {
            root = new WordNode(word, definition);
            return;
        }
        WordNode ptr = root;
        while (ptr != null) {
            if (word.compareTo(ptr.getWord()) < 0) {
                if (ptr.getLeft() == null) {
                    ptr.setLeft(new WordNode(word, definition));
                    return;
                }
                ptr = ptr.getLeft();
            } else if (word.compareTo(ptr.getWord()) > 0) {
                if (ptr.getRight() == null) {
                    ptr.setRight(new WordNode(word, definition));
                    return;
                }
                ptr = ptr.getRight();
            } else {
                return;
            }
        }
    }

    /**
     * This method is provided for you, do not edit it.
     * 
     * @return the root node of this BST
     */
    public WordNode getRoot() {
        // DO NOT EDIT
        return this.root;
    }
}
