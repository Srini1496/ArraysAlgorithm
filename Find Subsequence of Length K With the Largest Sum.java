/*
You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
*/

class Solution {
    
    public int[] maxSubsequence(int[] nums, int k) {
        int[] res= new int[k];
        int n=nums.length;
        int[][] arr=new int[n][2];
        //Form a 2D array
        for(int i=0;i<n;i++){
            arr[i][0]=i;
            arr[i][1]=nums[i];
        }
        
        //Sort based on value
        for(int i=1;i<nums.length;i++){
            int key=nums[i];
            int j=i-1;
            while(j>=0 && nums[j]<key){
                nums[j+1]=nums[j];
                arr[j+1][0]=arr[j][0];
                arr[j+1][1]=arr[j][1];
                j--;
            }
            nums[j+1]=key;
            arr[j+1][0]=i;
            arr[j+1][1]=key;
            
        }
        
        //Sort based on index upto k elemtns
        for(int i=1;i<k;i++){
            int key=arr[i][0];
            int val=arr[i][1];
            int j=i-1;
            while(j>=0 && arr[j][0]>key){
                arr[j+1][0]=arr[j][0];
                arr[j+1][1]=arr[j][1];
                j--;
            }
            arr[j+1][0]=key;
            arr[j+1][1]=val;
        }
        
        //add result in an array and return
        for(int i=0;i<k;i++){
           res[i]=arr[i][1];
        }
        
        return res;
        
    }
}
