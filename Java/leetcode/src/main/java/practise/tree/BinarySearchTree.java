package practise.tree;


class Node {
    public int value;
    public Node left, right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

public class BinarySearchTree {
    public static boolean contains(Node root, int value) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        if (root == null) return false;
        Node curNode = root;
        while(curNode != null){
            if (value < curNode.value){
                curNode = curNode.left;
            }else if (value > curNode.value){
                curNode = curNode.right;
            }else{
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(contains(n2, 3));
    }
}
