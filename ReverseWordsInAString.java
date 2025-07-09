
/**
 * 151. Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 *
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 *
 * SOLUTION APPROACH:
 * - Split the string by whitespace and filter out empty strings
 * - Reverse the order of words in the array
 * - Join the words back with single space separator
 * - Handle leading/trailing whitespace and multiple spaces
 * - Use StringBuilder for efficient string concatenation
 * - Trim the result to remove any extra spaces
 *
 * TIME COMPLEXITY: O(n) - Where n is the length of the input string
 * SPACE COMPLEXITY: O(n) - Space for storing words array
 *
 * ALTERNATIVE APPROACHES:
 * 1. Two-pointer: O(n) time, O(n) space - Reverse entire string, then reverse each word
 * 2. Stack: O(n) time, O(n) space - Push words onto stack, pop to reverse
 * 3. In-place: O(n) time, O(1) space - Reverse in-place (complex)
 *
 * KEY INSIGHTS:
 * - Split and join is most straightforward approach
 * - Handle multiple spaces and edge cases carefully
 * - StringBuilder is more efficient than String concatenation
 * - Can be done in-place but is more complex
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        // Split by whitespace and filter empty strings
        String[] words = s.trim().split("\\s+");
        
        // Reverse the array
        for (int i = 0; i < words.length / 2; i++) {
            String temp = words[i];
            words[i] = words[words.length - 1 - i];
            words[words.length - 1 - i] = temp;
        }
        
        // Join with single space
        return String.join(" ", words);
    }
} 