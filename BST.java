// Binary search tree of nodes that contain integers
//
// CS 302

public class BST {

    // Instance variables

    protected int value;
    protected IntTree left;
    protected IntTree right;

    // Constructor

    public BST(int val, IntTree lt, IntTree rt) {
        value = val;
        left = lt;
        right = rt;
    }

    // Instance methods:

    public int value() {
        // returns the integer stored in the root node of the BST
        return value;
    }

    public IntTree left() {
        // returns the left subtree of the BST
        return left;
    }

    public IntTree right() {
        // returns the right subtree of the BST
        return right;
    }

    public void setValue(int newValue) {
        // sets the integer in the root node of the BST to a new value
        value = newValue;
    }

    public void setLeft(IntTree newLeft) {
        // changes to the left subtree to a new BST
        left = newLeft;
    }

    public void setRight(IntTree newRight) {
        // changes the right subtree to a new BST
        right = newRight;
    }


    // Class Methods:

    public static BST empty() {
        // returns an empty BST (i.e., null)
        return null;
    }

    public static boolean isEmpty(BST t) {
        // returns true if the BST is empty
        return t == null;
    }

    public static boolean isLeaf(BST t) {
        // returns true if the BST is a leaf
        return t.left() == null && t.right() == null;
    }

    public static BST node(int val, BST lt, BST rt) {
        // creates a new BST with the integer "val" in the root node
        // and with the left subtree "lt" and right subtree "rt"
        return new IntTree(val, lt, rt);
    }

    public static IntTree leaf(int val) {
        // creates a new tree with the integer "val" in the root node
        // and no children (i.e., a leaf)
        return new IntTree(val, empty(), empty());
    }

    public static int value(IntTree t) {
        // returns the integer stored in the root node of the tree
        return t.value();
    }

    public static IntTree left(IntTree t) {
        // returns the left subtree of the tree t
        return t.left();
    }

    public static IntTree right(IntTree t) {
        // returns the right subtree of the tree t
        return t.right();
    }

    public static void setValue(IntTree t, int newValue) {
        // sets the integer in the root node of the tree to a new value
        t.setValue(newValue);
    }

    public static void setLeft(IntTree t, IntTree newLeft) {
        // changes to the left subtree to a new tree
        t.setLeft(newLeft);
    }

    public static void setRight(IntTree t, IntTree newRight) {
        // changes to the right subtree to a new tree
        t.setRight(newRight);
    }

    public static void show(IntTree t) {
        // displays a printed representation of the contents of the tree t,
        // using show1
        System.out.print("<IntTree ");
        show1(t);
        System.out.println(">");
    }

    public static void show1(IntTree t) {
        if (isEmpty(t)) {
            System.out.print("_");
        } else {
            System.out.print("(");
            show1(left(t));
            System.out.print(" " + value(t) + " ");
            show1(right(t));
            System.out.print(")");
        }
    }

    public static void printTree(IntTree t) {
        // displays a printed representation of tree t using printTree1
        printTree1(t, 0, true);
    }

    public static void printTree1(IntTree t, int level, boolean indent) {
        if (indent) {
            for (int i=0; i<level; i++)
                System.out.print("    ");
        } else {
            System.out.print(" ");
        }
        if (isEmpty(t)) {
            System.out.println("  .");
        } else {
            System.out.printf("%3d", value(t));
            if (isLeaf(t)) {
                System.out.println();
            } else {
                printTree1(right(t), level+1, false);
                printTree1(left(t),  level+1, true);
            }
        }
    }

}
