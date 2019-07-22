package tools.tree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Implement BinaryTreeNode injection from outside, use generics
 * 1)Which generics should be used? base on function or class?
 *      A: We can only base on the function
 * 2) What is the exactly different between <? extends T> and <? super T>
 *
 *
 *  Other questions:
 *  1) What happens if the lengths of BinaryTreeNode and input are different? How to modify its implementation?
 *  2)The other solutions in leetcode need understand
 *  3)What are the differences between  the Static class and the normal class?
 *  4) When does the generics function need to attach like the "<T>" label before the function name?
 *
 * */
public  class TreeTools {
/**
 * @Return:
 * Class<T> cls: only use for pass the generics type due to create new instance
 * */
/*    public static <T> void initTreeNodeList(T[ ]  nodeList, Class<T> cls) throws IllegalAccessException, InstantiationException {
        for (int i = 0; i < nodeList.length; i++){
            nodeList[i] = cls.newInstance();
        }
    }*/
    public static <T> void initTreeNodeList(T[ ]  nodeList) throws IllegalAccessException, InstantiationException {
/*        System.out.println("getName : " + nodeList.getClass().getComponentType().getName());
        System.out.println(nodeList.getClass().getComponentType().getSimpleName());
        System.out.println(nodeList.getClass().getComponentType().getCanonicalName());
        System.out.println(nodeList.getClass().getComponentType().getTypeName());
        System.out.println(nodeList.getClass().getComponentType().getDeclaredClasses());
        System.out.println(nodeList.getClass().getComponentType().getEnclosingClass());
        System.out.println("getClasses" + nodeList.getClass().getComponentType().getClasses());*/

        for (int i = 0; i < nodeList.length; i++){
            try {
                nodeList[i] = (T)nodeList.getClass().getComponentType().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static <T> T initByArray(T[] treeNodes, Integer[] input) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (treeNodes == null || input == null) return null;
        if (treeNodes.length != input.length) return null;
/*
        Method[] method = treeNodes.getClass().getComponentType().getMethods();
        for (Method m : method) {
            System.out.println(m);
        }
        System.out.println("---------------------------");
*/
        //only for eliminating warning
        Object[] ob = null;
        Class<?>[] cl = null;
/*        System.out.println("initByArray getComponentType : " + treeNodes.getClass().getComponentType());
        System.out.println("initByArray getName : " + treeNodes.getClass().getComponentType().getName());*/
        Method setVal = treeNodes.getClass().getComponentType().getMethod("setVal", Integer.class);
        Method getVal = treeNodes.getClass().getComponentType().getMethod("getVal", cl);
        Method setLeft = treeNodes.getClass().getComponentType().getMethod("setLeft", BinaryTreeNode.class);
        Method setRight = treeNodes.getClass().getComponentType().getMethod("setRight", BinaryTreeNode.class);

        for ( int i = 0; i < treeNodes.length; i++ ) {
            setVal.invoke(treeNodes[i], input[i] );
        }
        for ( int i = 0; i*2 + 2 < treeNodes.length; i++ ) {
                setLeft.invoke(treeNodes[i], null != getVal.invoke(treeNodes[i * 2 + 1], ob) ? treeNodes[i * 2 + 1] : null);
                setRight.invoke(treeNodes[i], null != getVal.invoke(treeNodes[i * 2 + 2], ob) ? treeNodes[i * 2 + 2] : null);
        }

        return treeNodes[0];
    }
}
