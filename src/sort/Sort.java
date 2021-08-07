package sort;

/*
    各种排序算法
 */

import org.testng.annotations.Test;

public class Sort {
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 冒泡排序
    public void bubbleSort(int[] arr) {
        if (arr == null) {
            return;
        }
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            flag = false;
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    swap(arr, i, j);
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public void selectSort(int[] arr) {
        if (arr == null) {
            return;
        }
        int temp;
        for (int i = 0; i < arr.length; i++) {
            temp = i;
            for (int j = i + 1; j < arr.length; j++) {
                temp = arr[temp] > arr[j] ? j : temp;
            }
            swap(arr, i, temp);
        }
    }

    //
    public void insertSort(int[] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j + 1] < arr[j]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    // 归并排序
    public void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, R);
    }

    public void merge(int[] arr, int L, int R) {
        int mid = (L + R) / 2;
        int[] temp = new int[R - L + 1];
        int i = 0, j = mid + 1, k = 0;
        while (i <= mid && j <= R) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= R) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }

    // 快速排序
    public void quickSort(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int i = L, j = R;
        int star = arr[R];
        while (i < j) {
            while (i < j && arr[i] <= star) {
                i++;
            }
            arr[j] = arr[i];
            while (i < j && arr[j] > star) {
                j--;
            }
            arr[i] = arr[j];
        }
        arr[i] = star;
        quickSort(arr, L, i - 1);
        quickSort(arr, i + 1, R);
    }

    // 堆排序--感觉这个不很重要

    @Test
    public void ttest() {
        int[] arr = {4, 8, 2, 3, 7, 6, 5};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
