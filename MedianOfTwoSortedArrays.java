
/**
 * 4. Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 *
 * SOLUTION APPROACH:
 * - Use binary search to find the correct partition point
 * - Ensure left partition has exactly (m+n+1)/2 elements
 * - Check if partition is correct by comparing boundary elements
 * - Calculate median based on whether total length is odd or even
 * - Handle edge cases where one array is empty or all elements are on one side
 *
 * TIME COMPLEXITY: O(log(min(m, n))) - Binary search on the smaller array
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Merge and Sort: O((m+n) log(m+n)) - Merge arrays and find median
 * 2. Two Pointers: O(m+n) - Merge in sorted order and find median
 * 3. Recursive: O(log(m+n)) - Recursive binary search approach
 *
 * KEY INSIGHTS:
 * - Binary search on the smaller array reduces complexity
 * - Partition must satisfy: leftA + leftB = rightA + rightB
 * - Correct partition: maxLeftA <= minRightB AND maxLeftB <= minRightA
 * - Handle edge cases carefully for arrays of different sizes
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for optimization
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int totalLeft = (m + n + 1) / 2;
        
        while (left <= right) {
            int partitionX = (left + right) / 2;
            int partitionY = totalLeft - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                // Found correct partition
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                right = partitionX - 1;
            } else {
                left = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted");
    }
} 