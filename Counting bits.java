/*
Counting Bits
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example 1:
Input: 2
Output: [0,1,1]

Example 2:
Input: 5
Output: [0,1,1,2,1,2]

Follow up:
It is very easy to come up with a solution with run time O(n*sizeof(integer)).
But can you do it in linear time O(n) /possibly in a single pass?
Space complexity should be O(n).
Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*/
class Solution {
    public int[] countBits(int num) {
        int[] res=new int[num+1];
        res[0]=0;
        /*Intuition is that after every interval number which is even will have +1
        number of ones like 2-5 has just 1 then 6-12 has 2 and so on . And with odd
        numbers it will be (i-1) +1 */
        for(int i=1;i<=num;i++){
            res[i]=res[i&(i-1)]+1;
        }
        return res;
    }
}
