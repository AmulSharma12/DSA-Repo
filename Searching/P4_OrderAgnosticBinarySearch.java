package DSA.Searching;
import java.util.Scanner;

public class P4_OrderAgnosticBinarySearch {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];
        for(int i = 0; i<size; i++)
        {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        //binary search in reverse sorted array return the index if element found otherwise return -1
        int targetIndex = orderAgnosticBinarySearch(nums, target,size);
        if(targetIndex > 0)
            System.out.println("At index " + targetIndex + " Element " + nums[targetIndex]);
        else
            System.out.println("No element exist in the array");
    }


    //orderAgnosticBinarySearch is also the searching algorithim but you need to identify the order
    //through the first and last element that whether it is ascending sorted or descending sorted
    private static int orderAgnosticBinarySearch(int[] nums, int target, int size)
    {
        int start = 0;
        int end = size - 1;

        //based on first and last element we can identify which sorting order it is
        //if start element is lesser than end element it means ascending sorted
        //if start element is greater than end element it means descending sorted
        boolean isAscending  = nums[start] < nums[end];

        while(start <= end)
        {
            //calculating the mid position using start and end
            int mid = start + (end-start)/2;

            //if element at mid-position equals to target then we found element then return the mid index.
            if(nums[mid] == target)         return mid;

            //if not found in mid it will either in 2 halves
            //Based on which order it is update the start and end positions
            if(isAscending)
            {
                //if it is Ascending order
                if(target > nums[mid])   start = mid + 1;
                else end = mid - 1;
            }
            else {
                //if it is descending order
                if(target > nums[mid])      end = mid - 1;
                else start = mid + 1;
            }
        }


        //if we don't be able to find out the target element we will return -1
        return -1;
    }
}
