import java.util.Scanner;

/**
 * Problem: Find the single number in an array where every other element appears twice.
 * Approach: XOR all elements — duplicates cancel out, leaving the unique one.
 */
public class SingleNumber {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the elements (space separated):");
        String input = sc.nextLine();
        String[] parts = input.trim().split("\\s+");

        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }

        SingleNumber solver = new SingleNumber();
        int answer = solver.singleNumber(nums);
        System.out.println("Single number is: " + answer);

        sc.close();
    }
}
