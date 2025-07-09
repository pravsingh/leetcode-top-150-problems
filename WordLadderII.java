
import java.util.*;

/**
 * 126. Word Ladder II
 *
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Example 1:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
 *
 * Example 2:
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: []

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
public class WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) return result;
        
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        
        boolean found = false;
        
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();
            
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                
                char[] chars = current.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newWord = new String(chars);
                        
                        if (wordSet.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                            
                            if (!visited.contains(newWord)) {
                                if (!graph.containsKey(newWord)) {
                                    graph.put(newWord, new ArrayList<>());
                                }
                                graph.get(newWord).add(current);
                                
                                if (!levelVisited.contains(newWord)) {
                                    queue.offer(newWord);
                                    levelVisited.add(newWord);
                                }
                            }
                        }
                    }
                    
                    chars[j] = original;
                }
            }
            
            visited.addAll(levelVisited);
        }
        
        if (found) {
            List<String> path = new ArrayList<>();
            path.add(endWord);
            backtrack(result, path, graph, endWord, beginWord);
        }
        
        return result;
    }
    
    private void backtrack(List<List<String>> result, List<String> path, 
                          Map<String, List<String>> graph, String current, String target) {
        if (current.equals(target)) {
            List<String> newPath = new ArrayList<>(path);
            Collections.reverse(newPath);
            result.add(newPath);
            return;
        }
        
        if (!graph.containsKey(current)) return;
        
        for (String prev : graph.get(current)) {
            path.add(prev);
            backtrack(result, path, graph, prev, target);
            path.remove(path.size() - 1);
        }
    }
} 