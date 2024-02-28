package DSA.Searching;
import java.util.Scanner;
import java.util.*;

public class P1_LinearSearch {
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

        boolean linearSearch = linearSearch(nums, target);
        System.out.println(linearSearch);

    }



    //linearSearch function
    private static boolean linearSearch(int[] nums, int target)
    {
        int n = nums.length;
        boolean isFound = false;
        for(int i = 0; i<n; i++)
        {
            if(nums[i] == target)
            {
                isFound = true;
                break;
            }
        }
        return isFound;
    }
}
