class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int half = (total + 1) / 2;

        int l1 = 0;
        int r1 = nums1.length;

        int m1 = 0;
        int m2 = 0;
        while (l1 <= r1) {
            m1 = l1 + ((r1 - l1) / 2);
            m2 = half - m1;

            int left1 = m1 > 0 ? nums1[m1 - 1] : Integer.MIN_VALUE;
            int right1 = m1 < m ? nums1[m1] : Integer.MAX_VALUE;
            int left2 = m2 > 0 ? nums2[m2 - 1] : Integer.MIN_VALUE;
            int right2 = m2 < n ? nums2[m2] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if ((total % 2) == 1) {
                    return Math.max(left1, left2);
                } else {
                    int low = Math.max(left1, left2);
                    int high = Math.min(right1, right2);
                    double sum = low + high;
                    return sum / 2.0;
                }
            } else if (left1 > right2) {
                r1 = m1 - 1;
            } else {
                l1 = m1 + 1;
            }
        }

        return -1;
    }
}
