import java.util.Scanner;
import java.util.Stack;

/**
 * Problem: Remove k digits from a number string to get the smallest possible result.
 * Approach: Use a monotonic stack — greedily remove larger digits when a smaller one comes next.
 */
public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            // pop bigger digits from stack while we still have removals left
            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // if we still need to remove more, trim from the end
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // build the result string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // strip leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        String num = sc.nextLine();

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        RemoveKDigits solver = new RemoveKDigits();
        String answer = solver.removeKdigits(num, k);
        System.out.println("Smallest number: " + answer);

        sc.close();
    }
}
