/*
Edit Distance

Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
You have the following 3 operations permitted on a word:
Insert a character
Delete a character
Replace a character

Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
/*
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            /*
            if we want to convert to empty string. Like we have "A" so we will just delete this to 
            convert to "".
            */
            dp[i][0]=i; 
        }
        for(int i=0;i<=word2.length();i++){
            /*
            if we want to convert an empty string to word2 . Like we have "" and for converting it 
            to "AMAN" it requires 4 insertion operation which goes in dp like we have A so adding A
            is 1 and then M adding M is 1+(cost of adding A) and so on
            */
            dp[0][i]=i;
        }
        /*
        Row will check on word1 and column will check on word2
        */
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                /*
                if both character are equal so we dont need to perform any operation so we just take the cost
                of operations before these characters so we go to dp(i-1)(j-1) which is nothing but cost
                of operations without these characters
                */
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]+=dp[i-1][j-1];
                }
                /*
                otherwise we will check which operation cost will be minimum considering cost of previous operat
                -ions. So for insertion we look into dp(i)(j-1) for example , "A", "D" so we add "D" in "A"
                so we don't need to check with "D" now so we move one backward in string "D" i.e j-1;
                AND if we wanna delete the current then we go to dp(i-1)(j) as we deleted "A" so we don't have
                "A" in our string and if we swap then we look for dp(i-1)(j-1) as both "A" and "D" will become
                similar and we don't need to check for these two letters;
                */
                else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i-1][j]),dp[i][j-1])+1;
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
