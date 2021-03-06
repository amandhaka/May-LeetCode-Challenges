# Permutation in String

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.

*Example 1:*
```
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").
```
*Example 2:*
```
Input:s1= "ab" s2 = "eidboaoo"
Output: False
```

*Solution:*
```
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            checkInclusion(s2,s1);
        }
        int[] chars=new int[26];
        for(char ch:s1.toCharArray()){
            chars[ch-'a']++;
        }
        int right=0;
        int left=0;
        int len=s1.length();
        int[] chars1=new int[26];
        while(right<s2.length()){
            char ch=s2.charAt(right);
            chars1[ch-'a']++;
            if((right-left+1)<len){
                right++;
                continue;
            }
            if((right-left+1)==len){
                char start=s2.charAt(left);
                if(Arrays.equals(chars,chars1)){
                    return true;
                }
                else
                    chars1[start-'a']--;
                left++;
                right++;
            }
        }
        return false;
    }
}
```
