package com.yqw.algorithm.sort;

/**
 * 2019/6/18.
 */
public class SortUtils {

    /**
     * 冒泡排序
     */
    public static void bubble_sort(int arr[], int len) {
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 直接选择排序
     */
    public static void select_sort(int arr[], int len) {
        for (int i = 0; i < len; i++) {
            int min = i;//通过下面for循环，选择出最小值
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j])
                    min = j;
            }
            //交换
            swap(arr, i, min);
        }
    }

    /**
     * 两路选择排序
     */
    public void select_2way_sort(int arr[], int len) {
        int tmp, min, max;
        for (int i = 0; i < len / 2; ++i) {
            min = max = i;
            for (int j = i + 1; j < len - i; ++j) {
                if (arr[max] < arr[j])
                    max = j;
                if (arr[min] > arr[j])
                    min = j;
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
            if (max == i)
                max = min;
            tmp = arr[len - 1 - i];
            arr[len - 1 - i] = arr[max];
            arr[max] = tmp;
        }
    }


    /**
     * 双冒泡排序
     *
     * @param arr
     * @param len
     */
    public static void bubble_2way_sort(int arr[], int len) {
        int tmp, pos;
        int low = 0, high = len - 1;
        while (low < high) {
            pos = low;
            for (int i = low; i < high; ++i)
                if (arr[i] > arr[i + 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    pos = i;
                }
            high = pos;

            pos = high;
            for (int i = high; i > low; --i)
                if (arr[i] < arr[i - 1]) {
                    tmp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = tmp;
                    pos = i;
                }
            low = pos;
        }
    }

    /**
     * 简单插入排序
     *
     * @param arr
     * @param len
     */
    public static void insert_sort(int arr[], int len) {
        for (int i = 1; i < len; i++) {
            int j, key = arr[i];
            for (j = i; j > 0 && arr[j - 1] > key; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = key;
        }
    }

    /**
     * 二分插入排序
     *
     * @param arr
     * @param len
     */
    public void insert_binary_sort(int arr[], int len) {
        for (int i = 1; i < len; ++i) {
            int low = 0, high = i - 1;
            int mid, key = arr[i];
            while (low <= high) {
                mid = (low + high) / 2;
                //   arr[mid] < key ? (low = mid+1) : (high = mid-1);
                if (arr[mid] < key) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            for (int j = i; j > low; --j)
                arr[j] = arr[j - 1];
            arr[low] = key;
        }
    }

    /**
     * 两路插入排序
     *
     * @param arr
     * @param len
     */
    public void insert_2way_sort(int arr[], int len) {
        //int tmp[len];
        int[] tmp = new int[len];
        tmp[0] = arr[0];
        int first = 0, last = 0;
        for (int i = 1; i < len; ++i) {
            if (arr[i] < tmp[first])
                tmp[first = (first - 1 + len) % len] = arr[i];
            else if (arr[i] > tmp[last])
                tmp[++last] = arr[i];
            else {
                int j, jless;
                for (j = ++last; tmp[jless = (j - 1 + len) % len] > arr[i]; j = jless)
                    tmp[j] = tmp[jless];
                tmp[j] = arr[i];
            }
        }
        for (int i = 0; i < len; ++i)
            arr[i] = tmp[(first + i) % len];
    }

    private static void heap_adjust(int arr[], int length, int node) {
        int key = arr[node];
        while (true) {
            int child = node * 2 + 1;
            if (child >= length)
                break;
            if (child + 1 < length && arr[child + 1] > arr[child])
                child++;
            if (arr[child] <= key)
                break;

            arr[node] = arr[child];
            node = child;
        }
        arr[node] = key;
    }

    /**
     * 堆排序
     *
     * @param arr
     * @param len
     */
    public static void heap_sort(int arr[], int len) {
        for (int node = len / 2 - 1; node >= 0; node--)
            heap_adjust(arr, len, node);

        for (int length = len - 1; length > 0; length--) {
            int tmp = arr[0];
            arr[0] = arr[length];
            arr[length] = tmp;
            heap_adjust(arr, length, 0);
        }
    }


    private static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 快速排序
     */
    public static void quick_sort(int arr[], int left, int right) {
        if (left >= right)
            return;
        swap(arr, left, (left + right) / 2);//设置left为基准点
        int index = left;//index表示小于基准点的索引
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[left]) {
                swap(arr, ++index, i);//比基准值小的都一次放到左边去
            }
        }
        swap(arr, left, index);//把基准值挪到中间，此时基准值左边的都是小的，右边的都是大的
        quick_sort(arr, left, index - 1);
        quick_sort(arr, index + 1, right);
    }

    /**
     * 希尔排序
     */
    public static void shell_sort(int arr[], int len) {
        for (int d = len / 2; d > 0; d /= 2) {
            d |= 1;
            for (int i = d; i < len; i++) {
                int j, key = arr[i];
                for (j = i; j >= d && arr[j - d] > key; j -= d)
                    arr[j] = arr[j - d];
                arr[j] = key;
            }
        }
    }

    /**
     * 合并排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void merge_sort(int arr[], int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        merge_sort(arr, left, mid);
        merge_sort(arr, mid + 1, right);

        int count = right - left + 1;
        // int tmp[ count];
        int[] tmp = new int[count];
        for (int i = 0; i < count; i++)
            tmp[i] = arr[left + i];

        int j = 0, jmax = mid - left + 1;
        int k = jmax, kmax = count;
        for (int i = left; i <= right; i++)
            arr[i] = j >= jmax || (k < kmax && tmp[k] < tmp[j]) ? tmp[k++] : tmp[j++];
    }

    /**
     * 计数排序
     *
     * @param arr
     * @param len
     */
    public void count_sort(int arr[], int len) {
        int max = arr[0];
        for (int i = 1; i < len; i++)
            if (max < arr[i])
                max = arr[i];
        int counts[] = new int[++max];
        for (int i = 0; i < max; i++)
            counts[i] = 0;

        for (int i = 0; i < len; i++)
            counts[arr[i]]++;

        for (int i = 0, j = 0; i < max; i++)
            while (counts[i]-- > 0)
                arr[j++] = i;
    }
}
