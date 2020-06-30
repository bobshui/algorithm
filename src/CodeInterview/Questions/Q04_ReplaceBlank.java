package CodeInterview.Questions;

/*
题目：请实现一个函数，把字符串中的每个空格替换成"20%"。例如输入"We are happy"，则输出"We20%are20%happy"
 */

public class Q04_ReplaceBlank {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {11, 12, 13, 14}, {15, 16, 17, 18}};
        System.out.println(solution1(matrix, 100));
    }

    /**
     * 时间复杂度为O(m+n)
     * @param matrix 数组
     * @param number 待查找待数字
     * @return
     */
    public static boolean solution1(int[][] matrix, int number) {
        //行列，暂不考虑特殊情况
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        int j = col - 1;
        while (i < row && j > -1) {
            if (matrix[i][j] > number) {
                j -= 1;
            } else if (matrix[i][j] < number) {
                i += 1;
            } else {
                return true;
            }
        }
        return false;
    }

    //考虑到每一行都是有序的数组，也可以对每一行进行二分查找，这样的时间复杂度为O(mlogn)
}


