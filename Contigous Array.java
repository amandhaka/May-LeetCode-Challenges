/*
Contiguous Array

Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.

Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Note: The length of the given binary array will not exceed 50,000.
*/

class Solution {
    public int findMaxLength(int[] nums) {
        int count=0;
        int max=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) count++;
            if(nums[i]==0) count--;
            if(map.containsKey(count)){
                max=Math.max(max,i-map.get(count)+1);
            }
            else if(count==0){
                max=Math.max(max,i+1);
            }
            else{
                map.put(count,i+1);
            }
        }
        return max;
    }
}
