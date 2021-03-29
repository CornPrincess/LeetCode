// Source : https://leetcode.com/problems/reverse-bits/
// Author : cornprincess
// Date   : 2021-03-29

/***************************************************************************************************** 
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 * 	Note that in some languages such as Java, there is no unsigned integer type. In this case, 
 * both input and output will be given as a signed integer type. They should not affect your 
 * implementation, as the integer's internal binary representation is the same, whether it is signed 
 * or unsigned.
 * 	In Java, the compiler represents the signed integers using 2's complement notation. 
 * Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents 
 * the signed integer -1073741825.
 *
 * Follow up:
 *
 * If this function is called many times, how would you optimize it?
 *
 * Example 1:
 *
 * Input: n = 00000010100101000001111010011100
 * Output:    964176192 (00111001011110000010100101000000)
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned 
 * integer 43261596, so return 964176192 which its binary representation is 
 * 00111001011110000010100101000000.
 *
 * Example 2:
 *
 * Input: n = 11111111111111111111111111111101
 * Output:   3221225471 (10111111111111111111111111111111)
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned 
 * integer 4294967293, so return 3221225471 which its binary representation is 
 * 10111111111111111111111111111111.
 *
 * Constraints:
 *
 * 	The input must be a binary string of length 32
 ******************************************************************************************************/

package ReverseBits;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // 所有的数都是以补码形式产生的，所以第一步要得到 n 补码表示形式
        String s = Integer.toUnsignedString(n, 2);
        // n 为正数，将0补齐
        if (s.length() < 32) {
            s = formate(s);
        }
        // reverse
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        String newStr = sb.toString();
        if (newStr.charAt(0) == '0') {
            return parseInt(tripZero(newStr.substring(1)));
        } else {
            // 如果是负数，全部取反+1
            StringBuilder sb2 = new StringBuilder();
            for (int i = 1; i < 32; i++) {
                if (newStr.charAt(i) == '1') {
                    sb2.append('0');
                } else {
                    sb2.append('1');
                }
            }
            // +1
            // 进行二进制的计算
            return -(parseInt(tripZero(sb2.toString())) + 1);
        }
    }

    // 时间复杂度：O(1)
    // 空间复杂度：O(1)
    public int reverseBits2(int n) {
        int res = 0;
        int index = 31;
        // 1
        while (n != 0) {
            int digit = n & 1;
            res |= digit << index;
            index--;
            n >>>= 1;
        }
        return res;
    }

    // 分治思想
    // 1001 0100

    // 1001 0100
    // 0101 0101 &
    // 0001 0100 <<
    // 0010 1000
    //
    // 0100 1010 >>>
    // 0101 0101 &
    // 0100 0000 |
    // 0010 1000
    // 0110 1000

    // 0101 0101 0101 0101 0101 0101 0101 0101
    private static final int M1 = 0x55555555;
    // 0011 0011 0011 0011 0011 0011 0011 0011
    private static final int M2 = 0x33333333;
    // 0000 1111 0000 1111 0000 1111 0000 1111
    private static final int M3 = 0x0f0f0f0f;
    // 0000 0000 1111 1111 0000 0000 1111 1111
    private static final int M4 = 0x00ff00ff;

    public int reverseBits3(int n) {
        // core >> == << ==<<< > & > |
        // 即这里先进行位运行，再进行 & 运行，最后进行 ｜ 运行
        n = n >>> 1 & M1 | (n & M1) << 1;
        n = n >>> 2 & M2 | (n & M2) << 2;
        n = n >>> 4 & M3 | (n & M3) << 4;
        n = n >>> 8 & M4 | (n & M4) << 8;
        n = n >>> 16 | n << 16;
        return n;
    }

    private String formate(String s) {
        // 10
        int length = 32 - s.length();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sBuilder.append("0");
        }
        return sBuilder.append(s).toString();
    }

    public String tripZero(String s) {
        while (s.startsWith("0")) {
            s = s.substring(1);
        }
        return s;
    }

    public int parseInt(String s) {
        // 1100
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                res += Math.pow(2, s.length() - 1 - i);
            }
        }
        return res;
    }
}
