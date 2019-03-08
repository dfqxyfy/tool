package cn.ccs.sort;

public class MergeSort {
 
    public static void merge(int[] a, int start, int mid, int end) {
        int[] tmp = new int[a.length];
        System.out.println("merge " + start + "~" + end);
        int i = start, j = mid + 1, k = start;
        while (i != mid + 1 && j != end + 1) {
            if (a[i] < a[j])
                tmp[k++] = a[i++];
            else
                tmp[k++] = a[j++];
        }
        while (i != mid + 1)
            tmp[k++] = a[i++];
        while (j != end + 1)
            tmp[k++] = a[j++];
        for (i = start; i <= end; i++)
            a[i] = tmp[i];
        for (int p : a)
            System.out.print(p + " ");
        System.out.println();
    }
 
    static void mergeSort(int[] a, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(a, start, mid);// 左边有序
            mergeSort(a, mid + 1, end);// 右边有序
            merge(a, start, mid, end);
        }
    }
 
    public static void main(String[] args) {
        int[] b = { 49, 38, 65, 97, 76, 13, 27, 50 };
        mergeSort(b, 0, b.length - 1);
    }
}