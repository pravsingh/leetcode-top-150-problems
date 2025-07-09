
import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * Given a roman numeral, convert it to an integer.
 *
 * Example 1:
 * Input: s = "III"
 * Output: 3
 *
 * Example 2:
 * Input: s = "LVIII"
 * Output: 58
 *
 * SOLUTION APPROACH:
 * - Use HashMap to store roman numeral values
 * - Process the string from left to right
 * - If current value >= next value, add current value
 * - If current value < next value, subtract current value
 * - This handles special cases like IV (4), IX (9), etc.
 * - Continue until all characters are processed
 *
 * TIME COMPLEXITY: O(n) - Single pass through the string
 * SPACE COMPLEXITY: O(1) - Fixed size HashMap for roman numerals
 *
 * ALTERNATIVE APPROACHES:
 * 1. Switch cases: O(n) time, O(1) space - Use switch statements
 * 2. Array lookup: O(n) time, O(1) space - Use array instead of HashMap
 * 3. Recursive: O(n) time, O(n) space - Recursive parsing
 *
 * KEY INSIGHTS:
 * - Roman numerals are read from left to right
 * - If smaller value comes before larger, it's subtracted
 * - If larger value comes before smaller, it's added
 * - HashMap provides O(1) lookup for roman numeral values
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);
        
        int result = 0;
        int prevValue = 0;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanValues.get(s.charAt(i));
            
            if (currentValue >= prevValue) {
                result += currentValue;
            } else {
                result -= currentValue;
            }
            
            prevValue = currentValue;
        }
        
        return result;
    }
} 