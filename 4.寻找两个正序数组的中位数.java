/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] arr = new int[nums1.length+nums2.length];
        if(nums1.length==0) arr=nums2;
        else if(nums2.length==0) arr=nums1;
        else{
        int s1=0,s2=0,i=0;
        while(s1<nums1.length&&s2<nums2.length){
            arr[i++] = nums1[s1]<nums2[s2]?nums1[s1++]:nums2[s2++];
        }
        while(s1<nums1.length) arr[i++] = nums1[s1++];
        while(s2<nums2.length) arr[i++] = nums2[s2++];
    }
        //计算中位数
        double res = 0;
        if(arr.length % 2 != 0) res = arr[(arr.length-1)/2];
        else res = (arr[(arr.length-1)/2]+arr[(arr.length-1)/2+1])/2.0;
        return res;
    }
}

// @lc code=end

