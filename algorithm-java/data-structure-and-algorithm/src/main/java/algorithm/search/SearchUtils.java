package algorithm.search;

public class SearchUtils {

    /**
     * 线性查找
     *
     * @param sortedData
     * @param value
     * @return
     */
    public static int linearSearchSorted(int[] sortedData, int value) {

        for (int i = 0; i < sortedData.length; i++) {
            System.out.println(sortedData[i] + " " + value);
            if (sortedData[i] == value) {
                return i;
            }
            if (value < sortedData[i]) {
                return -1;
            }
        }
        return -1;
    }

    /**
     * 二分查找，非递归方法
     *
     * @param sortedData
     * @param value
     * @return
     */
    public static int binarySearchSorted(int[] sortedData, int value) {
        int low = 0, hith = sortedData.length - 1;
        while (low <= hith) {
            int mid = (low + hith) / 2;
            if (sortedData[mid] == value) {
                return mid;
            } else if (sortedData[mid] < value) {
                low = mid + 1;
            } else {
                hith = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找递归方法
     *
     * @param sortedData
     * @param low
     * @param high
     * @param value
     * @return
     */
    public static int binarySearchSortedRecursion(int[] sortedData, int low, int high, int value) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (sortedData[mid] == value) {
            return mid;
        } else if (sortedData[mid] < value) {
            return binarySearchSortedRecursion(sortedData, mid + 1, high, value);
        } else if (sortedData[mid] > value) {
            return binarySearchSortedRecursion(sortedData, low, mid - 1, value);
        }
        return -1;
    }
}
