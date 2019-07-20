/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 * Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.
 *
 * */

package easy.tree;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class IncreasingOrderSearchTree {
    static public TreeNode increasingBST(TreeNode root) {

        //first looking for the right bottom node
        TreeNode lt = root.right;
        LinkedList<TreeNode> lst = new LinkedList<>();

        while(lt != null){
            TreeNode oldLt = lt;    //8

            //handle the right node
            lt = lt.right;
            if(lt != null){//9
                if(lt.right == null){
                    //whether lt.left equals null, put the lt into lst
                    lst.add(lt);
                    //cut off the connection with the superior node
                    oldLt.right = null;
                    lt = oldLt;
                }else{
                    continue;
                }
            }

            //handle the left node
            lt = oldLt;
            lt = lt.left;
            if(lt != null){
                if(lt.right != null){   //include "both != null" and "right != null but left == null"
                    continue;
                }else if(lt.left != null) {   //right == null
                    continue;
                }else{  //only both == null
                    lst.add(oldLt);
                    lst.add(lt);
                    oldLt.left = null;
//                    lt = oldLt;
//                    lst.add(lt);
//                    oldLt.left = null;
//                    lt = oldLt;
                }
            }

            lt = oldLt;
        }

//     rearrange the data
//        boolean bFirst = true;
        TreeNode cur = null;
        TreeNode old = null;
        TreeNode first = null;

        for(Iterator it = lst.iterator(); it.hasNext(); ) {
            cur = lst.pop();
            cur.left = null;
//            if(bFirst) {
//                bFirst = false;
//            }else{
            if (old != null) {
                old.right = cur;
            } else {
                first = cur;
            }
            old = cur;
            System.out.println(cur.val);

        }


        return first;
    }

    static public TreeNode Init(){
        TreeNode note[] = new TreeNode[9];
        for(int i = 0; i < 9; i++){
            note[i] = new TreeNode(-1);
        }
//        Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
        note[0].val = 5;
        note[0].left = note[1];
        note[0].right = note[2];

        note[1].val = 3;
        note[1].left = note[3];
        note[1].right = note[4];

        note[2].val = 6;
        note[2].left = null;
        note[2].right = note[5];

        note[3].val = 2;
        note[3].left = note[6];
        note[3].right = null;

        note[4].val = 4;
        note[4].left = null;
        note[4].right = null;

        note[5].val = 8;
        note[5].left = note[7];
        note[5].right = note[8];

        note[6].val = 1;
        note[6].left = null;
        note[6].right = null;

        note[7].val = 7;
        note[7].left = null;
        note[7].right = null;

        note[8].val = 9;
        note[8].left = null;
        note[8].right = null;



        System.out.println(note[0].val);
        return note[0];
    }

    @Test
    public void testRun() {
        TreeNode node = IncreasingOrderSearchTree.Init();
        IncreasingOrderSearchTree.increasingBST(node);

    }
}



