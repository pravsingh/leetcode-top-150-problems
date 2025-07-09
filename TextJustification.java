
import java.util.*;

/**
 * 68. Text Justification
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters.
 *
 * Example 1:
 * Input: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * Output: ["This    is    an","example  of text","justification.  "]

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
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < words.length) {
            int j = i + 1;
            int currentLength = words[i].length();
            
            while (j < words.length && currentLength + words[j].length() + 1 <= maxWidth) {
                currentLength += words[j].length() + 1;
                j++;
            }
            
            StringBuilder line = new StringBuilder();
            int spaces = maxWidth - currentLength;
            
            if (j == words.length || j - i == 1) {
                // Left justify
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Distribute spaces
                int gaps = j - i - 1;
                int spacesPerGap = gaps > 0 ? spaces / gaps : 0;
                int extraSpaces = gaps > 0 ? spaces % gaps : 0;
                
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spacesToAdd = spacesPerGap + (extraSpaces-- > 0 ? 1 : 0);
                        for (int s = 0; s < spacesToAdd; s++) {
                            line.append(" ");
                        }
                    }
                }
            }
            
            result.add(line.toString());
            i = j;
        }
        
        return result;
    }
} 