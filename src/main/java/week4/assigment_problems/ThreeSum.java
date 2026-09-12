import java.util.Arrays;
import java.util.Scanner;

public class ThreeSum {

    public static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        int[][] temp = new int[nums.length * nums.length][3];
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    temp[count][0] = nums[i];
                    temp[count][1] = nums[left];
                    temp[count][2] = nums[right];
                    count++;

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        int[][] result = new int[count][3];

        for (int i = 0; i < count; i++) {
            result[i] = temp[i];
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[][] result = threeSum(nums);

        System.out.print("Output: [");

        for (int i = 0; i < result.length; i++) {

            System.out.print("["
                    + result[i][0] + ", "
                    + result[i][1] + ", "
                    + result[i][2] + "]");

            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");

        sc.close();
    }
}