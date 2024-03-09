package DSA.Searching;
import java.util.Arrays;

//LeetCode 34 - https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//We need to find the first and last Occurence of the element in sorted array
public class P5_FirstAndLastOccurenceOfElementInSortedArray {
    public static void main(String[] args)
    {
        int[] nums = new int[]{};
        int target = 0;
        System.out.println(Arrays.toString(searchRangeUsingBinarySearch(nums,target)));
    }

    //Approach 1 - Using Brute force method
    private static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int firstOccurence = -1;
        int lastOccurence = -1;

        //traversing for the first Occurence
        for(int i = 0; i<n  ; i++)
        {
            if(nums[i] == target)
            {
                firstOccurence = i;
                break;
            }
        }


        //traversing for the last occurence
        for(int i = n-1; i>=0; i--)
        {
            if(nums[i] == target)
            {
                lastOccurence = i;
                break;
            }
        }


        return new int[]{firstOccurence, lastOccurence};
    }


    //Approach 2 - Using Binary Search
    private static int[] searchRangeUsingBinarySearch(int[] nums, int target) {
        int n = nums.length;
        int firstOccurence = -1;
        int lastOccurence = -1;

        int low = 0;
        int high = n-1;
        //binary search for finding the first occurence
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                firstOccurence = mid;
                high = mid - 1;
            }
            else if(target > nums[mid])
                low = mid + 1;
            else
                high = mid -1;
        }

        low = 0;
        high = n-1;
        //binary search for finding the last occurence
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(nums[mid] == target)
            {
                lastOccurence = mid;
                low = mid + 1;
            }
            else if(target > nums[mid])
                low = mid + 1;
            else
                high = mid -1;
        }

        return new int[]{firstOccurence, lastOccurence};
    }
}
