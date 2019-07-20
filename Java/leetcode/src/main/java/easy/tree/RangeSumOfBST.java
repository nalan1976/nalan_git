package easy.tree;

import tools.tree.BinaryTreeNode;
import tools.tree.TreeTools;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedList;

public class RangeSumOfBST {

/*    class TreeNode extends BinaryTreeNode{
        public TreeNode() {
            super();
        }
    };*/

    public static int rangeSumBST(BinaryTreeNode root, int L, int R) {
        LinkedList<BinaryTreeNode> list = new LinkedList<>();
        list.add(root);
        int sum = 0;
        while (list.size() != 0){
            BinaryTreeNode n = list.pop();
//            if (n == null) continue;
            if (n.getVal() >= L && n.getVal() <= R) sum += n.getVal();

            if (n.getVal() > L && n.getLeft() != null) list.push(n.getLeft());
            if (n.getVal() < R && n.getRight() != null) list.push(n.getRight());
        }
        return sum;
    }
/*    public static int rangeSumBST2(TreeNode root, int L, int R) {
        if (root == null) return 0;

        // [3, 8]
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (root.val > R) return rangeSumBST(root.left, L, R);
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
    public static int rangeSumBST3(TreeNode root, int L, int R) {
        if(root == null){
            return 0;
        }

        int sum = 0;

        if(root.val>=L && root.val<=R){
            sum = root.val;
        }

        sum += rangeSumBST(root.left,L,R);
        sum += rangeSumBST(root.right,L,R);

        return sum;

    }*/
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        BinaryTreeNode[] nodeList = new BinaryTreeNode[7];
        TreeTools.initTreeNodeList(nodeList);
        Integer[] arr = new Integer[] {10,5,15,3,7,null,18};
        System.out.println(rangeSumBST(TreeTools.initByArray(nodeList, arr), 7, 15));   //32

        BinaryTreeNode[] nodeList2 = new BinaryTreeNode[15];
        TreeTools.initTreeNodeList(nodeList2);
        System.out.println(rangeSumBST(TreeTools.initByArray(nodeList2, new Integer[] {10,5,15,3,7,13,18,1,null,6,null,null,null,null,null}), 6, 10));  //23

    }
}
