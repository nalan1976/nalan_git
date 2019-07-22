package tools.tree;

public  class BinaryTreeNode {
    public Integer val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

/*    public  BinaryTreeNode() {
    }*/

//This method is not a constructor!!! Because there is a void modifier before the method's name.
    public void BinaryTreeNode(Integer x) { val = x; }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }
    //should be change to generics method
    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
