package codeInterview.questions;

/*
题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
    请完成一个函数，输入这样的一个二维数组和整数，判断数组中是否有该整数。
 */

//一开始确实还是没想到什么好办法，因为这个和什么数据结构和算法感觉都扯不上关系，如果左上右下的来话，基本走不通，
//还是看了答案才有的思路
//输入就略了，直接生成二维数组

public class Q03_FindInPartiallySortedMatrix {

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


