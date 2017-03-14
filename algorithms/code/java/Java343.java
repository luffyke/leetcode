/**
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 *
 * @author kext
 */
public class IntegerBreak {
	public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int x = n % 3;
        int y = n / 3;
        if (x == 0) {
            return (int) Math.pow(3, y);
        } else if (x == 1) {
            return (int) Math.pow(3, y - 1) * 2 * 2;
        } else {
            return (int) Math.pow(3, y) * 2;
        }
    }
}
