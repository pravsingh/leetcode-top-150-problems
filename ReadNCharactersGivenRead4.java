
/**
 * 157. Read N Characters Given Read4
 *
 * Given a file and assume that you can only read the file using a given method read4, implement a method to read n characters.
 *
 * Example 1:
 * Input: file = "abc", n = 4
 * Output: 3
 *
 * Example 2:
 * Input: file = "abcde", n = 5
 * Output: 5

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
public class ReadNCharactersGivenRead4 {
    /**
     * The read4 API is defined in the parent class Reader4.
     * int read4(char[] buf4);
     */
    
    public class Reader4 {
        int read4(char[] buf4) {
            // Implementation not shown
            return 0;
        }
    }
    
    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Number of characters to read
         * @return    The number of actual characters read
         */
        public int read(char[] buf, int n) {
            int copiedChars = 0, readChars = 4;
            char[] buf4 = new char[4];
            
            while (copiedChars < n && readChars == 4) {
                readChars = read4(buf4);
                
                for (int i = 0; i < readChars; i++) {
                    if (copiedChars == n) return copiedChars;
                    buf[copiedChars] = buf4[i];
                    copiedChars++;
                }
            }
            
            return copiedChars;
        }
    }
} 