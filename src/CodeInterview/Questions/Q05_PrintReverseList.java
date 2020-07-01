package CodeInterview.Questions;

/*
题目：请实现一个函数，把字符串中的每个空格替换成"20%"。例如输入"We are happy"，则输出"We20%are20%happy"
 */

public class Q05_PrintReverseList {

    public static void main(String[] args) {
        String s = "ddd  as asdas ";
        System.out.println(solution1(s));
    }

    /**
     * 利用StringBuilder直接相加，这个解法感觉意义不大？从时间复杂度来看是O(n)
     * @param s 输入字符串
     * @return
     */
    public static String solution1(String s) {
        //暂不考虑特殊情况
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }

}


