
/**
 * 11. Container With Most Water
 *
 * Given n non-negative integers height where each represents a point at coordinate (i, height[i]), find two lines that together with the x-axis form a container that would hold the maximum amount of water.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * SOLUTION APPROACH:
 * - Use two pointers (left and right) starting from both ends
 * - Calculate area using the shorter height and current width
 * - Move the pointer with the shorter height inward
 * - Keep track of maximum area found so far
 * - Continue until pointers meet
 *
 * TIME COMPLEXITY: O(n) - Single pass through the array
 * SPACE COMPLEXITY: O(1) - Constant extra space
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n²) - Check all possible pairs
 * 2. Dynamic Programming: Not applicable for this problem
 * 3. Greedy with optimization: O(n) - Similar to two pointers
 *
 * KEY INSIGHTS:
 * - Two pointers approach is optimal because we can eliminate many combinations
 * - Moving the shorter height pointer is optimal because:
 *   - Width will decrease, so we need higher height to get larger area
 *   - The shorter height is the limiting factor
 * - No need to check combinations that would give smaller areas
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        
        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;
            
            maxArea = Math.max(maxArea, area);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
} 