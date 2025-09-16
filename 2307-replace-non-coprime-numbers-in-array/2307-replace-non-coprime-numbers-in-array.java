import java.util.*;

public class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        for (int num : nums) {
            while (!stack.isEmpty() && gcd(stack.peek(), num) > 1) {
                num = lcm(stack.pop(), num);
            }
            stack.push(num);
        }
        
        return new ArrayList<>(stack);
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b; // (a * b) / gcd(a, b) can cause overflow
    }
}