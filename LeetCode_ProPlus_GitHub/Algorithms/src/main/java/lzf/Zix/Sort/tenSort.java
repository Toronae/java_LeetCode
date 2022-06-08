package lzf.Zix.Sort;

import java.util.Arrays;

public class tenSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        tenSort solution = new tenSort();
        int num = solution.findKthLargest(nums, 4);
        System.out.println(num);
        System.out.println(Arrays.toString(nums));
    }

    public int findKthLargest(int[] nums, int k) {
        //1.冒泡排序
        //bubbleSort(nums);

        //2.选择排序
        //selectSort(nums);

        //3.插入排序
        //insertSort(nums);

        //4.快排
        //quickSort(nums, 0, nums.length - 1);

        //5.希尔排序
        //shellSort(nums);

        //6.归并排序
        //mergeSort(nums, 0, nums.length - 1);

        //7.堆排序
        heapSort(nums);

        return nums[k - 1];

        //7.基数排序 未优化,暂无法解决负数问题
        //radixSort(nums);
        //return nums[nums.length - k];
    }


    //冒泡排序
    public void bubbleSort(int[] nums) {
        int len = nums.length;
        boolean flag;
        for (int i = 0; i < len; i++) {
            flag = true;
            for (int j = i + 1; j < len; j++) {
                if (nums[i] < nums[j]) {
                    swap(nums, i, j);
                    flag = false;
                }
                if (false) {
                    break;
                }
            }
        }
    }

    //选择排序
    public void selectSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int max = nums[i];
            int index = i;
            for (int j = i + 1; j < len; j++) {
                if (max < nums[j]) {
                    index = j;
                    max = nums[j];
                }
            }
            swap(nums, i, index);
        }
    }

    //插入排序
    public void insertSort(int[] nums) {
        int len = nums.length;
        int insert;
        int index;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                insert = nums[j];
                index = j - 1;
                if (nums[index] < insert) {
                    while (index >= 0 && nums[index] < insert) {
                        nums[index + 1] = nums[index];
                        index--;
                    }
                    nums[index + 1] = insert;
                }

            }
        }
    }

    //归并排序
    public void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            temp[index++] = nums[i] > nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) {
            temp[index++] = nums[i++];
        }

        while (j <= right) {
            temp[index++] = nums[j++];
        }

        for (int num : temp) {
            nums[left++] = num;
        }
    }

    //基数排序  未优化 暂无法解决负数问题
    public void radixSort(int[] nums) {
        int max = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }

        int count = 0;
        while (max != 0) {
            max /= 10;
            count++;
        }

        int radix[][] = new int[10][len];
        int radixIndex[] = new int[10];
        int index;
        for (int i = 0, div = 1; i < count; i++, div *= 10) {
            for (int j = 0; j < len; j++) {
                index = nums[j] / div % 10;
                radix[index][radixIndex[index]++] = nums[j];
            }
            index = 0;
            for (int j = 0; j < radix.length; j++) {
                for (int k = 0; k < radixIndex[j]; k++) {
                    nums[index++] = radix[j][k];
                }
                radixIndex[j] = 0;
            }
        }
    }

    //希尔排序
    public void shellSort(int[] nums) {
        int len = nums.length;
        int insert;
        int index;
        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                insert = nums[i];
                index = i - gap;
                if (nums[index] < insert) {
                    while (index >= 0 && nums[index] < insert) {
                        nums[index + gap] = nums[index];
                        index -= gap;
                    }
                    nums[index + gap] = insert;
                }
            }
        }
    }

    //快排
    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int pivot = left;
            int index = left + 1;
            for (int i = index; i <= right; i++) {
                if (nums[pivot] < nums[i]) {
                    swap(nums, index, i);
                    index++;
                }
            }
            swap(nums, index - 1, pivot);
            pivot = index - 1;
            quickSort(nums, left, pivot - 1);
            quickSort(nums, pivot + 1, right);
        }
    }

    //堆排序
    public void heapSort(int[] nums) {
        int len = nums.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, len);
        }

        while (len > 0) {
            swap(nums, 0, len - 1);
            len--;
            adjustHeap(nums, 0, len);
        }
    }

    private void adjustHeap(int[] nums, int i, int len) {
        int temp = nums[i];
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && nums[k] > nums[k + 1]) {
                k++;
            }

            if (nums[k] < temp) {
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }

        nums[i] = temp;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
