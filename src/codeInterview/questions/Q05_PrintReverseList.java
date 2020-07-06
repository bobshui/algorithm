package codeInterview.questions;

/*
题目：输入一个链表的头节点，从头到尾反过来打印每个节点的值
 */

import java.util.Stack;

public class Q05_PrintReverseList {

    public static void main(String[] args) {
        LinkList l0 = new LinkList("l0", null);
        LinkList l1 = new LinkList("l1", l0);
        LinkList l2 = new LinkList("l2", l1);
        LinkList l3 = new LinkList("l3", l2);
        //solution2(l3);
        solution3(l1, null);
    }

    //定义LinkList
    //---内部类问题
    static class LinkList {
        public String name;
        public LinkList next; //指向下一个节点

        //构造器
        public LinkList(String name, LinkList next) {
            this.name = name;
            this.next = next;
        }

        @Override
        public String toString() {
            return "LinkList [name=" + name + "]";
        }

        public void printAll() {
            System.out.print(this.toString() + "--");
            LinkList ll = this;
            while (ll.next != null) {
                ll = ll.next;
                System.out.print(ll.toString() + "--");
            }
            System.out.println();
        }
    }

    /**
     * 自己想的一个办法，就是遍历，遍历一个节点就放一个节点到末尾
     * 看答案后意识到，(1)破坏了原有链表到结构 (2)并没有完全满足需求，应该直接打印而不是返回新的头节点
     *
     * @param ll 链表的头节点
     * @return 新链表的头节点
     */
    public static LinkList solution1(LinkList ll) {
        //暂不考虑特殊情况
        LinkList newhead = ll;
        LinkList cur = newhead.next;
        newhead.next = null;
        LinkList temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = newhead;
            newhead = cur;
            cur = temp;
        }
        return newhead;
    }

//    是不是很简单整洁？
//    public static Node reverseList(Node node) {
//        Node pre = null;
//        Node next = null;
//        while (node != null) {
//            next = node.next;
//            node.next = pre;
//            pre = node;
//            node = next;
//        }
//        return pre;
//    }

    /**
     * 利用栈的性质，感受到先进后出到逻辑后，应该要能够联想到栈到结构
     *
     * @param ll
     */
    public static void solution2(LinkList ll) {
        Stack<LinkList> stack = new Stack<>();
        //暂不考虑特殊情况
        while (ll != null) {
            stack.push(ll);
            ll = ll.next;
        }
        //while(stack.size()>0){，不优秀的遍历
        while (!stack.empty()) {
            LinkList l = stack.pop();
            System.out.print(l.toString());
        }
    }

    /**
     * 递归本质上是栈结构（感受下这个思想）
     * 但是调用太深，可能会是个问题
     * @param ll
     */
    public static void solution3(LinkList ll, LinkList pre) {
        //暂不考虑特殊情况
        if (ll == null) {
            return;
        }
        LinkList next = ll.next;
        ll.next = pre;
        solution3(next, ll);
    }
}


