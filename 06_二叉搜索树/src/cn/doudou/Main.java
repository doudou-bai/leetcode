package cn.doudou;

import cn.doudou.printer.BinaryTreeInfo;
import cn.doudou.printer.BinaryTrees;

import java.util.Comparator;

/**
 * Create By 王嘉浩
 * Time 2022-11-12 14:34
 */
public class Main {
    public static class MyPersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Integer[] datas = new Integer[]{
                7, 4, 9, 2
        };
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for (Integer data : datas) {
            bst.add(data);
        }
        BinaryTrees.println(bst);
        System.out.println(bst.isComplete());
                        /*bst.preorderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 3 ? true : false;
            }
        });
        System.out.println();
        bst.inorderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 5 ? true : false;
            }
        });
        System.out.println();
        bst.postorderTraversal(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 4 ? true : false;
            }
        });
        System.out.println();
        bst.levelorder(new BinarySearchTree.Visitor<Integer>() {
            @Override
            boolean visit(Integer element) {
                System.out.print(element + " ");
                return element == 5 ? true : false;
            }
        });*/
    }
}
