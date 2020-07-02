package CodeInterview.Questions;

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
        solution2(l3);
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

    public static void solution2(LinkList ll){
        Stack<LinkList> stack = new Stack<>();
        //暂不考虑特殊情况
        while(ll!=null){
            stack.push(ll);
            ll=ll.next;
        }
        //while(stack.size()>0){，不优秀的遍历
        while(!stack.empty()){
            LinkList l = stack.pop();
            System.out.print(l.toString());
        }
    }

}


