package DSA.Searching;
import java.util.Scanner;
import java.util.Arrays;

//GFG - question https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
//we need to find the Count of element in a sorted array
public class P6_CountOccurenceOfElementInSortedArray {

    public static void main(String[] args)
    {
        int[] nums = new int[]{1, 1, 2, 2, 2, 2, 3};
        int target = 5;
        System.out.println(countElementInSortedArrayUsingBinarySearch(nums,target));
    }

    //Approach 1 - Using Brute force method
    private static int countElementInSortedArray(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        //traversing for the first Occurence
        for(int i = 0; i<n  ; i++)
        {
            if(nums[i] == target)
            {
                count++;
            }
        }

        return count;
    }


    //Approach 2 - Using Binary Search
    private static int countElementInSortedArrayUsingBinarySearch(int[] nums, int target) {
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
        //if firstOccurence is -1 means there is no element exist in the array for that target element
        if(firstOccurence == -1)
                return 0;

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


        //this formula will calculate the number of element exist inclusive using their first and last index of the element
        return lastOccurence - firstOccurence + 1;
    }
}
