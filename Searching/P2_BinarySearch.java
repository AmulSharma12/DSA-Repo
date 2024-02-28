package DSA.Searching;
import java.util.*;

public class P2_BinarySearch {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] nums = new int[size];

        //Taking input for the array
        for(int i = 0; i<size; i++)
        {
            nums[i] = sc.nextInt();
        }

        //input for the target
        int target = sc.nextInt();

        boolean binarySearch = binarySearch(nums, target);
        System.out.println(binarySearch);

    }

    private static boolean binarySearch(int[] nums, int target)
    {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while(start <= end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] == target)
                return true;
            else if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return false;
    }
}
