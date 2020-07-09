package basics.algorithm;

public class ArraySort {
    public static void main(String[] args) {
        int[] a = {3, 6, 5, 8, 9, 4, 2, 7, 1};
        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

    /**
     * 冒泡法排序
     * 从第一位开始，把相邻两位进行比较，第一波就留下最大的
     * @param a
     */
    private static void bubbleSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {  //i+1比i更好
                int temp;
                if (a[j] > a[j + 1]) {
                    temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

    /**
     * 选择法排序
     * 把第一位和其他所有的进行比较，只要比第一位小的，就换到第一个位置来
     *
     * @param a
     */
    private static void selectSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {  //i+1比i更好
                int temp;
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
