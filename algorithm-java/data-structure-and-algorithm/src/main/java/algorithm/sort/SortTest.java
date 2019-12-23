package algorithm.sort;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * SortUtils的测试类
 * 2019/6/18.
 */
public class SortTest {

    private static final int COUNT = 10;
    private int[] arr = new int[COUNT];

    @Before
    public void initData() {
        System.out.printf("new an array randomly :\n");
        for (int i = 0; i < COUNT; ++i)
            arr[i] = new Random().nextInt() % COUNT + 1;
        for (int i = 0; i < COUNT; ++i)
            System.out.printf("%d ", arr[i]);
        System.out.println();//换行
    }

    /**
     * 百万数据，--
     * 10万数据，25秒
     * 1万数据，800毫秒
     * 1千数据,150毫秒
     */
    @Test
    public void test_bubble_sort() {

        SortUtils.bubble_sort(arr, arr.length);
        System.out.printf("%s\n", "bubble sort:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 百万数据，--
     * 10万数据，8秒
     * 1万数据，600毫秒
     * 1千数据,125毫秒
     */
    @Test
    public void test_select_sort() {
        SortUtils.select_sort(arr, arr.length);
        System.out.printf("%s\n", "select sort:");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test_insert_sort() {
        SortUtils.insert_sort(arr, arr.length);
        System.out.printf("%s\n", "soerted:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 百万数据，--
     * 10万数据，15秒
     * 1万数据，500毫秒
     * 1千数据,140毫秒
     */
    @Test
    public void test_bubble_2way_sort() {
        SortUtils.bubble_2way_sort(arr, arr.length);
        System.out.printf("%s\n", "bubble_2way_sort sort:");
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 百万数据，8秒
     * 10万数据，1.7秒
     * 1万数据，350毫秒
     * 1千数据,125毫秒
     */
    @Test
    public void test_heap_sort() {
        SortUtils.heap_sort(arr, arr.length);
        System.out.printf("%s\n", "heap_sort sort:");
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 百万数据，8.7秒
     * 10万数据，1.6秒
     * 1万数据，400毫秒
     * 1千数据,140毫秒
     */
    @Test
    public void test_shell_sort() {
        SortUtils.shell_sort(arr, arr.length);
        System.out.printf("%s\n", "###############");
        System.out.println(Arrays.toString(arr));
    }


    @Test
    public void test_quick_sort() {
        SortUtils.quick_sort(arr, 0, arr.length - 1);
        System.out.printf("%s\n", "sorted:");
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void setArr() {
        System.out.println("sfsdf");
    }
}
