package org.smartx;

/**
 * @author kext
 */
public class Java343 {
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
