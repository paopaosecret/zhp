package com.xander.algorithm;

/**
 * 快速排序 数组：开始下标 start, 结束下标end,数组长度length
 *
 * 一次快速排序：
 * a、选取第一个元素值为key, i = 0, j = length - 1
 * b、从后向前遍历找到小于key的元素，和i元素交换， i++
 * c、从前向后遍历找到大于key的元素，和j元素交换, j--
 * d、如果i< j 重复 b，c,直到i == j, 则数组被分为 大于key 和 小于 key的前后两部分[start, i-1] 和 [j+1, end]
 *
 * 快速排序
 *  一次快速排序之后，将前后两部分继续做快速排序，直到 前半部分 start = i - 1，后半部分 end = j - 1;
 *
 *
 * @作者 zhaobing04
 * @创建日期 2020/7/17 10:40
 */
public class QuickSort {
    /**
     * @param targetArr
     * @param start
     * @param end
     */
    static void quickSort(int targetArr[], int start, int end) {
        int i = start, j = end;
        int key = targetArr[start];
        while (i < j) {
            while (j > i && targetArr[j] >= key) {
                j--;
            }
            if (i < j) {/*targetArr[i]已经保存在key中，可将后面的数填入*/
                targetArr[i] = targetArr[j];
                i++;
            }
            /*按i++方向遍历目标数组，直到比key大的值为止*/
            while (i < j && targetArr[i] <= key) {/*此处一定要小于等于零，假设数组之内有一亿个1，0交替出现的话，而key的值又恰巧是1的话，那么这个小于等于的作用就会使下面的if语句少执行一亿次。*/
                i++;
            }
            if (i < j) {
                /*targetArr[j]已保存在targetArr[i]中，可将前面的值填入*/
                targetArr[j] = targetArr[i];
                j--;
            }
        }
        /*此时i==j*/
        targetArr[i] = key;

        /*递归调用，把key前面的完成排序*/
        if (start == i - 1) {
            return;
        } else {
            quickSort(targetArr, start, i - 1);
        }

        /*递归调用，把key后面的完成排序*/
        if (j + 1 == end) {
            return;
        } else {
            quickSort(targetArr, j + 1, end);
        }
    }

    public static void main(String args[]) {

        int array[] = {15, 5, 6, 59, 15, 45, 78};
        quickSort(array, 0, 6);

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }
}
