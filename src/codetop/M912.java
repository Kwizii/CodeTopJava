package codetop;

class M912 {
    void qsort(int[] nums, int l, int r) {
        if (l >= r) return;
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        qsort(nums, l, j);
        qsort(nums, j + 1, r);
    }

    void heapSort(int[] nums) {
        int n = nums.length - 1;
        buildMaxHeap(nums, n);
        for (int i = n; i >= 1; i--) {
            swap(nums, i, 0);
            n--;
            maxHeapify(nums, 0, n);
        }
    }

    void buildMaxHeap(int[] nums, int len) {
        for (int i = len / 2; i >= 0; i--) {
            maxHeapify(nums, i, len);
        }
    }

    void maxHeapify(int[] nums, int i, int len) {
        while ((i << 1) + 1 <= len) {
            int lson = (i << 1) + 1;
            int rson = (i << 1) + 2;
            int large;
            if (lson <= len && nums[lson] > nums[i]) {
                large = lson;
            } else {
                large = i;
            }
            if (rson <= len && nums[rson] > nums[large]) {
                large = rson;
            }
            if (large != i) {
                swap(nums, i, large);
                i = large;
            } else {
                break;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }
}