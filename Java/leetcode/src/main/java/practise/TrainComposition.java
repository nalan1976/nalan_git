package practise;

import java.util.LinkedList;
//import java.util.List;

public class TrainComposition {
    class Node{

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        private int value ;
        private Node left;
        private Node right;
    }

    private LinkedList<Node > list = new LinkedList<>();
//    private Node curLeft;
//    private Node curRight;

    public void TrainComposition(){
//        this.node = new Node();

    }

    public void attachWagonFromLeft(int wagonId) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        Node n = new Node();
        n.setValue(wagonId);
        this.list. offer(n);
    }

    public void attachWagonFromRight(int wagonId) {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        Node n = new Node();
        n.setValue(wagonId);
        this.list.push(n);
    }

    public int detachWagonFromLeft() {
//        throw new UnsupportedOperationException("Waiting to be implemented.");

        return list.pollLast().getValue();
    }

    public int detachWagonFromRight() {
//        throw new UnsupportedOperationException("Waiting to be implemented.");
        return list.poll().getValue();
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}