import java.util.*;

//int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

public class Solution {

    public static void main(String[] args) {

    }


}

//5.实现二叉树先序、中序和后序遍历 20201104 牛客
///**
// *
// * @param root TreeNode类 the root of binary tree
// * @return int整型二维数组
// */
//public int[][] threeOrders (TreeNode root) {
//    ArrayList<Integer> preArray = new ArrayList<>();
//    ArrayList<Integer> midArray = new ArrayList<>();
//    ArrayList<Integer> aftArray = new ArrayList<>();
//    preOrder(root,preArray);
//    midOrder(root,midArray);
//    aftOrder(root,aftArray);
//    int[][] result = new int[3][preArray.size()];
//    result[0] = preArray.stream().mapToInt(Integer::valueOf).toArray();
//    result[1] = midArray.stream().mapToInt(Integer::valueOf).toArray();
//    result[2] = aftArray.stream().mapToInt(Integer::valueOf).toArray();
//    return result;
//}
//
//public void midOrder(TreeNode root, ArrayList array){
//    TreeNode temp = root;
//    if(root.left != null){
//        temp = root.left;
//        midOrder(temp, array);
//    }
//    array.add(root.val);
//    if(root.right != null){
//        temp = root.right;
//        midOrder(temp, array);
//    }
//}
//
//public static void preOrder(TreeNode root, ArrayList array){
//    array.add(root.val);
//    TreeNode temp = root;
//    if(root.left != null){
//        temp = root.left;
//        preOrder(temp, array);
//    }
//    if(root.right != null){
//        temp = root.right;
//        preOrder(temp, array);
//    }
//}
//
//public void aftOrder(TreeNode root, ArrayList array){
//    TreeNode temp = root;
//    if(root.left != null){
//        temp = root.left;
//        aftOrder(temp, array);
//    }
//    if(root.right != null){
//        temp = root.right;
//        aftOrder(temp, array);
//    }
//    array.add(root.val);
//}

//不够简洁，参考下图
//private void preOrder(TreeNode root) {
//    if (root == null) return;
//    pre.add(root.val);
//    preOrder(root.left);
//    preOrder(root.right);
//}

//学习非遍历的思路

//4.判断链表中是否有环 20201103 牛客
///**
// * Definition for singly-linked list.
// * class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) {
// *         val = x;
// *         next = null;
// *     }
// * }
// */
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
//
//public boolean hasCycle(ListNode head) {
//    ListNode l1 = head;
//    ListNode l2 = head;
//    if(head.next == null){
//        return false;
//    }
//    while(l2 != null && l2.next != null){
//        l1 = l1.next;
//        l2 = l2.next.next;
//        if(l1 == l2){
//            return true;
//        }
//    }
//    return false;
//}

//3. 20201103 牛客
///**
// * 二分查找
// * @param n int整型 数组长度
// * @param v int整型 查找值
// * @param a int整型一维数组 有序数组
// * @return int整型
// */
//public static int upper_bound_ (int n, int v, int[] a) {
//    int low = 0;
//    int high = n -1;
//    if(a[0] >= v){
//        return 1;
//    }
//    if(a[high] < v){
//        return n + 1;
//    }
//    while(low <= high){
//        int mid = (low + high) / 2;
//        if(a[mid] < v){
//            if(a[mid+1] == v){
//                return mid + 2;
//            }
//            low = (low + high) / 2 + 1;
//        }
//        else{
//            high = (low + high) / 2 - 1;
//        }
//    }
//    return n + 1;
//}
//不够简练，不过思路基本正确，读题还需要细心一些

//2.设计LRU缓存结构 20201102 牛客
///**
// * lru design
// * @param operators int整型二维数组 the ops
// * @param k int整型 the k
// * @return int整型一维数组
// */
//public static int[] LRU (int[][] operators, int k) {
//    LinkedHashMap<Integer, Integer> linkedHashMap =
//            new LinkedHashMap<>(k, 0.5f, true);
//    ArrayList<Integer> list = new ArrayList<>();
//    for(int[] row : operators ){
//        if(row.length == 2){
//            if(linkedHashMap.get(row[1])==null){
//                list.add(-1);
//            }else{
//                list.add(linkedHashMap.get(row[1]));
//            }
//        }else{
//            if(linkedHashMap.size()==k && linkedHashMap.get(row[1])==null){
//                linkedHashMap.remove(linkedHashMap.entrySet().iterator().next().getKey());
//            }
//            linkedHashMap.put(row[1],row[2]);
//        }
//    }
//    //神奇的转换方法
//    return list.stream().mapToInt(Integer::valueOf).toArray();
//}

//1.反转链表 20201102 牛客
/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
//public class Solution {
//    public ListNode ReverseList(ListNode head) {
//        ListNode next = null , temp = null;
//        while(head != null){
//            temp = head.next;
//            head.next = next;
//            next = head;
//            head = temp;
//        }
//        return next;
//    }
//}
//
//有一种递归的方法，很巧妙