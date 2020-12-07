import java.util.*;

//int[] arr1 = list1.stream().mapToInt(Integer::valueOf).toArray();

public class Solution {

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 4, 3};
    }
}

//17.找到字符串的最长无重复字符子串 20201207 牛客
// 想想linkedlist是不是更加优雅，或类似于滑动窗口的处理？不过都是同源的
///**
// * @param arr int整型一维数组 the array
// * @return int整型
// */
//public static int maxLength(int[] arr) {
//    // write code here
//    HashMap<Integer, Integer> map = new HashMap<>();
//    int flag = 0;
//    int result = 0;
//    int tempresult = 0;
//    for (int i = 0; i < arr.length; i++) {
//        if (!map.containsKey(arr[i])) {
//            tempresult++;
//            result = Math.max(result, tempresult);
//        } else {
//            int a = map.get(arr[i]);
//            if (a > flag) {
//                flag = a;
//            }
//            tempresult = i - flag;
//            result = Math.max(result, tempresult);
//        }
//        map.put(arr[i], i);
//    }
//    return result;
//}

//16.链表中环的入口节点 20201207 牛客
//    public ListNode detectCycle(ListNode head) {
//        if (head == null) {
//            return null;
//        }
//        ListNode slow = head.next;
//        if (slow == null) {
//            return null;
//        }
//        ListNode fast = head.next.next;
//        while (fast != slow) {
//            if (fast == null || fast.next == null) {
//                return null;
//            }
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        //到这里就确定有环了，计算环的长度
//        ListNode t = slow.next;
//        int count = 1;
//        while (t != slow) {
//            t = t.next;
//            count++;
//        }
//        fast = slow = head;
//        while (count-- > 0) {
//            fast = fast.next;
//        }
//        while (fast != slow) {
//            fast = fast.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
// 没做出来
// 思路1，方法和我基本一致，但是简便不少。从数学上来说，如将此时两指针分别放在起始位置和相遇位置，并以相同速度前进，当一个指针走完距离a时，
// 另一个指针恰好走出 绕环n-1圈加上c的距离。故两指针会在环开始位置相遇。
// 思路2，很有想法。若存在环，则从起点开始，每走一步就删除上一个节点的next指针，最后一个节点就是环的起点。因为环的起点会存在两个next指向它。

//todo 15.最长公共子串 20201206 牛客
//todo 非常典型的动态规划，借此机会研究学习了一波，但是一直通不过，怀疑是牛客的bug
///**
// * longest common substring
// *
// * @param str1 string字符串 the string
// * @param str2 string字符串 the string
// * @return string字符串
// */
//public static String LCS(String str1, String str2) {
//    // write code here
//    int l1 = str1.length();
//    int l2 = str2.length();
//    int l2_index = 0;
//    int result = 0;
//
//    int[][] t = new int[l1 + 1][l2 + 1];
//    for (int i = 1; i < l1 + 1; i++) {
//        for (int j = 1; j < l2 + 1; j++) {
//            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
//                t[i][j] = t[i - 1][j - 1] + 1;
//                result = t[i][j];
//                l2_index = j;
//            } else {
//                t[i][j] = 0;
//            }
//        }
//    }
//    if (result == 0) {
//        return "-1";
//    }
//    return str2.substring(l2_index - result, l2_index);
//}


//14.括号序列 20201113 牛客
///**
// * @param s string字符串
// * @return bool布尔型
// */
//public boolean isValid(String s) {
//    char[] chars = s.toCharArray();
//    Stack<Character> stack = new Stack<Character>();
//    for (char c : chars) {
//        if (c == '{' || c == '[' || c == '(') {
//            stack.push(c);
//        } else if (stack.size() == 0) {
//            return false;
//        } else if (c == '}') {
//            if (stack.pop() != '{') {
//                return false;
//            }
//        } else if (c == ']') {
//            if (stack.pop() != '[') {
//                return false;
//            }
//        } else if (c == ')') {
//            if (stack.pop() != '(') {
//                return false;
//            }
//        }
//    }
//    if(stack.size()==0){
//        return true;
//    }
//    return false;
//}
//有一些讨巧一点的写法，但是思路是一致的


//13.用两个栈实现队列 20201113 牛客
//Stack<Integer> stack1 = new Stack<Integer>();//用来push
//Stack<Integer> stack2 = new Stack<Integer>();//用来pop
//
//public void push(int node) {
//    if(stack2.size()>0){
//        while(stack2.size()>0){
//            stack1.push(stack2.pop());
//        }
//    }
//    stack1.push(node);
//}
//
//public int pop() {
//    if(stack2.size()>0){
//        return stack2.pop();
//    }
//    if(stack1.size()==0){
//        return 0;
//    }
//    while(stack1.size()>0){
//        stack2.push(stack1.pop());
//    }
//    return stack2.pop();
//}
//其实插入确实是一句话的事情


//12.删除链表倒数第n个节点 20201113 牛客
// / *
// * @param head ListNode类
// * @param n int整型
// * @return ListNode类
// */
//public ListNode removeNthFromEnd (ListNode head, int n) {
//    int count = 0;
//    ListNode temp = head;
//    while(temp!=null){
//        temp = temp.next;
//        count++;
//    }
//    temp =head;
//    int i= count-n;
//    if(count==n){
//        return head.next;
//    }
//    while(i-1>0){
//        temp = temp.next;
//        i--;
//    }
//    temp.next=temp.next.next;
//    return head;
//}

//双指针法，知道要这么干，怎么想半天想不到，这道题蠢了


//11.链表中的节点每k个一组反转 20201110 牛客
// * @param head ListNode类
// * @param k    int整型
// * @return ListNode类
// */
//public ListNode reverseKGroup(ListNode head, int k) {
//    if (k == 1) {
//        return head;
//    }
//    ListNode tail = null;
//    ListNode t = head;
//    int i = k;
//    while (t != null && i > 0) {
//        t = t.next;
//        i--;
//    }
//    if (i > 0) {
//        return head;
//    }
//    ListNode next = null, temp = null;
//    i = k;
//    while (i > 0) {
//        if(i==k){
//            tail = head;
//        }
//        temp = head.next;
//        head.next = next;
//        next = head;
//        head = temp;
//        i--;
//    }
//    tail.next = reverseKGroup(head, k);
//    return next;
//}
//


//10.跳台阶 20201110 牛客
//public int JumpFloor(int target) {
//    if (target == 1) {
//        return 1;
//    }
//    if (target == 2) {
//        return 2;
//    }
//    int[] arr = new int[target];
//    arr[0] = 1;
//    arr[1] = 2;
//    for (int i = 2; i < target; i++) {
//        arr[i] = arr[i - 1] + arr[i - 2];
//    }
//    return arr[target - 1];
//}
// 递归要考虑到栈的问题
// 这个方法的问题在于数组占用的空间可能过大，事实上三个变量就可以处理


//9.求二叉树的层序遍历 20201110 牛客
///**
// * @param root TreeNode类
// * @return int整型ArrayList<ArrayList <>>
// */
//public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
//    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//    if (root == null) {
//        return result;
//    }
//    Queue<TreeNode> q1 = new LinkedList<>();
//    Queue<TreeNode> q2 = new LinkedList<>();
//    q1.offer(root);
//    while (q1.size() > 0 || q2.size() > 0) {
//        ArrayList<Integer> arr = new ArrayList<>();
//        if(q1.size()>0) {
//            while (q1.size() > 0) {
//                TreeNode t = q1.poll();
//                if (t.left != null) {
//                    q2.offer(t.left);
//                }
//                if (t.right != null) {
//                    q2.offer(t.right);
//                }
//                arr.add(t.val);
//            }
//            result.add(arr);
//            continue;
//        }
//        if(q2.size()>0) {
//            while (q2.size() > 0) {
//                TreeNode t = q2.poll();
//                if (t.left != null) {
//                    q1.offer(t.left);
//                }
//                if (t.right != null) {
//                    q1.offer(t.right);
//                }
//                arr.add(t.val);
//            }
//            result.add(arr);
//            continue;
//        }
//    }
//    return result;
//}
//
//public class TreeNode {
//    int val = 0;
//    TreeNode left = null;
//    TreeNode right = null;
//}
// 思考递归的方法来解决问题
// 仔细想想，其实一个队列就能够处理了


//8.最小的k个数 20201109 牛客
//public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
//    int len = input.length;
//    ArrayList<Integer> result = new ArrayList<>();
//    if (k > len || len < 1) {
//        return result;
//    }
//    for (int i = len / 2; i >= 0; i--) {
//        heap(input, i, len);
//    }
//    for (int i = 0; i < k; i++) {
//        heap(input, 0, len - i);
//        int temp;
//        temp = input[len - i - 1];
//        input[len - i - 1] = input[0];
//        input[0] = temp;
//        result.add(input[len - i - 1]);
//    }
//    return result;
//}
//
//public static void heap(int[] input, int parent, int len) {
//    int temp = input[parent];
//    int child = parent * 2 + 1;
//    while (child < len) {
//        if (child + 1 < len && input[child] > input[child + 1]) {
//            child++;
//        }
//        if (temp < input[child]) {
//            break;
//        }
//        input[parent] = input[child];
//        parent = child;
//        child = child * 2 + 1;
//    }
//    input[parent] = temp;
//}

//PriorityQueue<Integer>
//另：参考下快排的partition思想


//7.合并链表 20201109 牛客
///**
// * @param l1 ListNode类
// * @param l2 ListNode类
// * @return ListNode类
// */
//public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//    ListNode head, temp;
//    //根据参考答案， 这一段有点冗余，可以合并到后序逻辑，提示：返回head.next
//    if (l1 == null)
//        return l2;
//    if (l2 == null)
//        return l1;
//    if (l1.val < l2.val) {
//        head = temp = l1;
//        l1 = l1.next;
//    } else {
//        head = temp = l2;
//        l2 = l2.next;
//    }
//    while (l1 != null && l2 != null) {
//        if (l1.val < l2.val) {
//            temp.next = l1;
//            l1 = l1.next;
//        } else {
//            temp.next = l2;
//            l2 = l2.next;
//        }
//        temp = temp.next;
//    }
//    if (l1 != null) {
//        temp.next = l1;
//    } else {
//        temp.next = l2;
//    }
//    return head;
//}


//还有可以参考到递归方法


//6.寻找第K大 20201108 牛客
//public int findKth(int[] a, int n, int K) {
//    for (int i = n / 2; i >= 0; i--) {
//        heap(a, i, n);
//    }
//    int temp;
//    for (int i = n - 1; i >= n - K; i--) {
//        temp = a[i];
//        a[i] = a[0];
//        a[0] = temp;
//        heap(a, 0, i);
//    }
//    return a[n - K];
//}
//
//public static void heapSort(int[] a) {
//    for (int i = a.length / 2; i >= 0; i--) {
//        heap(a, i, a.length);
//    }
//    int temp;
//    for (int i = a.length - 1; i > 0; i--) {
//        temp = a[i];
//        a[i] = a[0];
//        a[0] = temp;
//        heap(a, 0, i);
//    }
//}
//
//public static void heap(int[] arr, int parent, int length) {
//    int p = arr[parent];
//    int child = parent * 2 + 1;
//    while (child < length) {
//        if (child + 1 < length && arr[child + 1] > arr[child]) {
//            child++;
//        }
//        if (p >= arr[child]) {
//            break;
//        }
//        arr[parent] = arr[child];
//        parent = child;
//        child = child * 2 + 1;
//    }
//    arr[parent] = p;
//}
//
//public static void quicks(int[] arr, int l, int h) {
//    if (l >= h) {
//        return;
//    }
//    int temp = arr[l];
//    while (l < h) {
//        while (l < h && arr[h] >= temp) {
//            h--;
//        }
//        arr[l] = arr[h];
//        while (l < h && arr[l] <= temp) {
//            l++;
//        }
//        arr[h] = arr[l];
//    }
//    arr[l] = temp;
//    quicks(arr, 0, l - 1);
//    quicks(arr, l + 1, h);
//}


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