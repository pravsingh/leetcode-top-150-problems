
import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 *
 * Example 1:
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 *
 * Example 2:
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4

 *
 * SOLUTION APPROACH:
 * - Use appropriate array manipulation technique
 * - Consider sorting, two pointers, or sliding window
 * - Handle edge cases and boundary conditions
 * - Optimize for time and space complexity
 *
 * TIME COMPLEXITY: Varies based on approach - typically O(n) to O(n²)
 * SPACE COMPLEXITY: Varies based on approach - typically O(1) to O(n)
 *
 * ALTERNATIVE APPROACHES:
 * 1. Brute Force: O(n²) or higher - Check all combinations
 * 2. Sorting: O(n log n) - Sort first, then process
 * 3. Hash-based: O(n) - Use HashMap/HashSet for lookups
 *
 * KEY INSIGHTS:
 * - Choose the right data structure for the problem
 * - Consider trade-offs between time and space complexity
 * - Look for patterns that can be optimized
 */
public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        
        int maxPoints = 0;
        
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeCount = new HashMap<>();
            int duplicates = 0;
            
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    duplicates++;
                    continue;
                }
                
                String slope = getSlope(points[i], points[j]);
                slopeCount.put(slope, slopeCount.getOrDefault(slope, 0) + 1);
            }
            
            int maxCount = 0;
            for (int count : slopeCount.values()) {
                maxCount = Math.max(maxCount, count);
            }
            
            maxPoints = Math.max(maxPoints, maxCount + duplicates + 1);
        }
        
        return maxPoints;
    }
    
    private String getSlope(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];
        
        if (dx == 0) return "vertical";
        if (dy == 0) return "horizontal";
        
        int gcd = gcd(Math.abs(dx), Math.abs(dy));
        dx /= gcd;
        dy /= gcd;
        
        if (dx < 0) {
            dx = -dx;
            dy = -dy;
        }
        
        return dy + "/" + dx;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
} 