package CodeInterview.Questions;

/*
题目：请实现一个函数，把字符串中的每个空格替换成"20%"。例如输入"We are happy"，则输出"We20%are20%happy"
 */

//刚拿到确实没什么想法，直接替换？
//比如，直接遍历，用Stringbuilder去加起来？
//哦，要在原字符串上面弄，假设情况只允许一份空间，直接遍历，会需要O(n*n)的挪动，可以计算所需空间从后往前！
//但仔细一想，Java的字符串似乎没有空间连续的说法？只能作为一个思路了

public class Q04_ReplaceBlank {

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
        for(char ch: c){
            if(ch == ' '){
                sb.append("20%");
            }
            else{
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}


