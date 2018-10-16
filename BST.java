// Binary search tree of nodes that contain integers
//
// CS 302

class Node {
  int key, height;
  Node left, rigth;

  node(int k) {
    key = k;
    height = 1;
  }
}

class BST {
  Node root;

  // Get the height of a tree by passing its root
  int height(Node n) {
    if (n == null) {
      return 0;
    }
    return n.height;
  }

  rotateR() {

  }

  rotateL(Node n) {

  }

  insert(Node n) {

  }

  delete(Node n) {

  }

  int getBal(Node n) {
    // returns the balance factor of a Node, i.e. difference in children heights
    if (n == null) {
      return 0;
    }
    return height(n.left) - height(n.right);
  }
}
