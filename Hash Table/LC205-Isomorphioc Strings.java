/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
*/
  public boolean isIsomorphic(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        // Key: character for the first string; Value: character for the second string 
        Map<Character, Character> map = new HashMap<>();
        
        // store the characters has occurred in String t
        
        Set<Character> set = new HashSet<>();
        
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        
        
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(chars[i])) {
                if (set.contains(chart[i]))
                    return false;
                map.put(chars[i], chart[i]);
                set.add(chart[i]);
            } else {
                if (map.get(chars[i]) == chart[i])
                    continue;
                return false;
            }
        }
        return true;
    }