package cn.ccs.sort;

public class MergeSortCcs {
    private void merge(int[] a, int start, int mid, int end) {
        System.out.println("merge " + start + " ~ " + end);
        if (start == end) {
            return;
        }
        int[] temp = new int[a.length];
        int i = start;
        int j = mid + 1;
        int cur = start;
        while (i < mid + 1 && j < end + 1) {
            if (a[i] < a[j]) {
                temp[cur++] = a[i++];
            } else {
                temp[cur++] = a[j++];
            }
        }
        while (i < mid + 1) {
            temp[cur++] = a[i++];
        }
        while (j < end + 1) {
            temp[cur++] = a[j++];
        }
        for (i = start; i <= end; i++) {
            a[i] = temp[i];
        }
    }

    public void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        merge(a, start, mid, end);
    }

    public static void main(String[] args) {
        int[] a = new int[]{6, 3, 5, 4, 1};
        new MergeSortCcs().mergeSort(a, 0, a.length - 1);
        for (int k : a) {
            System.out.print(k + "\t");
        }
    }
}
