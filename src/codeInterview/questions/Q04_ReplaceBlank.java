package codeInterview.questions;

/*
题目：请实现一个函数，把字符串中的每个空格替换成"20%"。例如输入"We are happy"，则输出"We20%are20%happy"
 */

//刚拿到确实没什么想法，直接替换？
//比如，直接遍历，用Stringbuilder去加起来？
//假设情况只允许一份空间，直接遍历，会需要O(n*n)的挪动，按答案意思可以计算所需空间从后往前
//但仔细一想，Java的字符串似乎没有空间连续的说法？

public class Q04_ReplaceBlank {

    public static void main(String[] args) {
        String s = "ddd  as asdas ";
        System.out.println(solution2(s));
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

    /**
     * 参考书中的解法，先计算所需空间，在从后往前写入，和C++不同，这一招感觉在java中意义不大
     * 仅做思路参考
     * @param s 输入字符串
     * @return
     */
    public static String solution2(String s) {
        //暂不考虑特殊情况
        char[] c = s.toCharArray();
        int len = c.length;
        int count = 0;
        for(char ch: c){
            if(ch == ' '){
                count +=2;
            }
        }
        int newLength = len+count*2;
        char[] result = new char[newLength];
        for(int j=len-1;j>-1;j--){
            if(c[j]==' '){
                result[newLength-1] = '0';
                result[newLength-2] = '2';
                result[newLength-3] = '%';
                newLength-=3;
            }else{
                result[newLength-1] = c[j];
                newLength-=1;
            }
        }
        return new String(result);
    }

    //扩展题目，有两个排序的数组A1和A2，A1有足够的空间，合并两个数组并保证有序，也可以参考类似的，从后往前的思路，很棒
}


