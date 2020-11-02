import java.util.*;


public class Solution {

    public static void main(String[] args) {
        
    }
}


//2.设计LRU缓存结构 20201002 牛客
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