package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> result = new HashMap<>();

        for (String word : strs) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedWord = new String(charArr);

            /// If sorted word key is not present, add it to the hashmap.
            if (!result.containsKey(sortedWord)) {
                result.put(sortedWord, new ArrayList<>());
            }

            /// eventaully add the word, under sorted word key.
            result.get(sortedWord).add(word);
        }

        return new ArrayList<>(result.values());
    }
}
// @lc code=end
