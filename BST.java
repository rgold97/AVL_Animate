// Binary search tree of nodes that contain integers
//
// CS 302

class BST {

  class Node {
    int key, height;
    Node left, rigth;

    public Node(int k) {
      key = k;
      height = 1;
      left = null;
      right = null;
    }
  }
  // Instance variables of BST
  Node root;

  // BST constructor 
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

  // rotateR() {
  //
  // }

  // rotateL(Node n) {
  //
  // }

  void insert(int key) {
    return insertHelp(BST.root, key);
  }

  Node insertHelp(Node n, int key) {
    // if n is null, we know tree is empty, so return resulting tree of size 1
    if (n == null) {
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
  }

  int getBal(Node n) {
    // returns the balance factor of a Node, i.e. difference in children heights
    if (n == null) {
      return 0;
    }
    return height(n.left) - height(n.right);
  }
}
