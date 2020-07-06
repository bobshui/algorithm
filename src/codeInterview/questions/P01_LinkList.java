package CodeInterview.Questions;

public class P01_LinkList {
    //定义LinkList，链表
    //---内部类问题

    public String name;
    public P01_LinkList next; //指向下一个节点

    //构造器
    public P01_LinkList(String name, P01_LinkList next) {
        this.name = name;
        this.next = next;
    }

    @Override
    public String toString() {
        return "P01_LinkList [name=" + name + "]";
    }

    /**
     * 作为头结点，打印整个当前链表
     */
    public void printAll() {
        System.out.print(this.toString() + "--");
        P01_LinkList ll = this;
        while (ll.next != null) {
            ll = ll.next;
            System.out.print(ll.toString() + "--");
        }
        System.out.println();
    }
}
