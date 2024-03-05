package DSA.Searching;
import java.util.Scanner;

public class P3_BinarySearchReverseSortedArray {
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
        int targetIndex = binarySearch(nums, target,size);
        if(targetIndex > 0)
            System.out.println("At index " + targetIndex + " Element " + nums[targetIndex]);
        else
            System.out.println("No element exist in the array");
    }

    //binary search reverse sorted array function
    private static int binarySearch(int[] nums, int target,int size)
    {
        int start = 0;
        int end = size-1;

        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)     return mid;
            else if(target < nums[mid])  start = mid+1;
            else end = mid-1;
        }

        return -1;
    }
}
