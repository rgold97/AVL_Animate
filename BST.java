// Binary search tree of nodes that contain integers
//
// CS 302

class BST {

  class Node {
    int key, height;
    Node left, right;

    public Node(int k) {
      key = k;
      height = 1;
      left = null;
      right = null;
    }
  }
  // Instance variables of BST
  Node root;

  // BST con  structor
  BST() {
    root = null;
  }

  // Get the height of a tree by passing its root
  int height(Node n) {
    if (n == null) {
      return 0;
    }
    return n.height;
  }

  int getBal(Node n) {
    // returns the balance factor of a Node, i.e. difference in children heights
    if (n == null) {
      return 0;
    }
    return height(n.left) - height(n.right);
  }

  // Single rotation right
  Node rotateR(Node root) {
    Node newroot = root.left;
    Node newleft = newroot.right;

    newroot.right = root;
    root.left = newleft;
    // update heights
    newroot.height = Math.max(height(newroot.left), height(newroot.right)) + 1;
    root.height = Math.max(height(root.left), height(root.right)) + 1;

    return newroot;
  }

  // Single rotation left
  Node rotateL(Node root) {
    Node newroot = root.right;
    Node newright = newroot.left;

    newroot.left = root;
    root.right = newright;
    // update heights
    newroot.height = Math.max(height(newroot.left), height(newroot.right)) + 1;
    root.height = Math.max(height(root.left), height(root.right)) + 1;

    return newroot;
  }

  // Primer function to make insertion call easier
  void insert(int key) {
    root = insertHelp(root, key);
  }

  // Recursive insert function
  Node insertHelp(Node n, int key) {
    // if n is null, we know tree is empty, so return resulting tree of size 1
    if (n == null) {
      n = new Node(key);
      return n;
    }
    // recursively insert node until subtree is empty and insert there
    if (key < n.key) {
      n.left = insertHelp(n.left, key);
    } else if (key > n.key) {
      n.right = insertHelp(n.right, key);
    } else {
      return n;
    }
    // update height
    n.height = Math.max(height(n.left), height(n.right)) + 1;

    // get balances of current node, left subtree and right subtree
    int bal = getBal(n);
    int lbal = getBal(n.left);
    int rbal = getBal(n.right);

    // perform rotations as necessary
    if (bal < -1) {
      if (rbal > 1) {
        // double left rotation
        n.right = rotateR(n.right);
        return rotateL(n);
      } else {
        // single left rotation
        return rotateL(n);
      }
    } else if (bal > 1) {
      if (lbal < -1) {
        // double right rotation
        n.left = rotateL(n.left);
        return rotateR(n);
      } else {
        // single right rotation
        return rotateR(n);
      }
    }

    return n;
  }

  // This method mainly calls InorderRec()
  void inorder() {
    inorderRec(root);
  }

  // A utility function to do inorder traversal of BST
  void inorderRec(Node root) {
    if (root != null) {
      inorderRec(root.left);
      System.out.println(root.key);
      System.out.println(root.height);
      inorderRec(root.right);
    }
  }

  void printRoot() {
    System.out.println(root.key);
  }

  // Main program to test above functions
  public static void main(String[] args) {
    BST tree = new BST();

    tree.insert(10);
    tree.insert(20);
    tree.insert(30);
    tree.insert(40);
    tree.insert(50);
    tree.insert(25);
    tree.insert(60);
    tree.insert(70);
    tree.insert(80);
    tree.insert(90);
    tree.insert(55);
    tree.insert(35);

    System.out.println("done");
    tree.inorder();
  }
}
