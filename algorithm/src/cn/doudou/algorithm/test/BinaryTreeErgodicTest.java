package cn.doudou.algorithm.test;

import cn.doudou.algorithm.linear.Queue;
import cn.doudou.algorithm.tree.BinaryTree;

/**
 * Create By 王嘉浩
 * Time 2022-10-29 16:40
 */
public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        //创建树对象
        BinaryTree<String, String> tree = new BinaryTree<>();

        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        //遍历
        /*Queue<String> keys = tree.layerErgodic();
        for (String key : keys) {
            System.out.println(key + "----->"+tree.get(key));
        }*/

        System.out.println(tree.maxDepth());
    }
}
