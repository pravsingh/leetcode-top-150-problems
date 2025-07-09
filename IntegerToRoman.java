
/**
 * 12. Integer to Roman
 *
 * Given an integer, convert it to a roman numeral.
 *
 * Example 1:
 * Input: num = 3
 * Output: "III"
 *
 * Example 2:
 * Input: num = 58
 * Output: "LVIII"
 *
 * SOLUTION APPROACH:
 * - Use greedy approach with predefined roman numeral values
 * - Create arrays of values and symbols in descending order
 * - For each value, subtract as many as possible from the number
 * - Append corresponding symbols to the result
 * - Continue until the number becomes zero
 * - This works because roman numerals are additive
 *
 * TIME COMPLEXITY: O(1) - Fixed number of roman numeral symbols
 * SPACE COMPLEXITY: O(1) - Constant space for predefined arrays
 *
 * ALTERNATIVE APPROACHES:
 * 1. Recursive: O(1) time, O(1) space - Recursive subtraction
 * 2. Switch cases: O(1) time, O(1) space - Handle each digit separately
 * 3. HashMap: O(1) time, O(1) space - Store value-symbol mappings
 *
 * KEY INSIGHTS:
 * - Greedy approach works because roman numerals are additive
 * - Process from largest to smallest values
 * - Special cases (4, 9, 40, 90, etc.) are handled by the predefined values
 * - Can be extended to handle larger numbers
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return result.toString();
    }
} 