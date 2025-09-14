package solution.arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        // Fill the array from the back in non-decreasing order, so max value out of
        // 2 arrays would go at the last first.
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        // If the first array is merged but second array is still not completely merged
        // We do not need to do for this for first array as it is already sorted and if
        // we are able to merge the second array, the arrays are already merged.
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
