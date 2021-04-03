package VolumeOfHistogram;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 4/2/21
 * Time: 11:34 PM
 */
public class VolumeOfHistogram {
    // 朴素解法
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            // find maxLeft
            int maxLeft = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (height[j] > maxLeft) {
                    maxLeft = height[j];
                }
            }
            // core 优化性能
            if (maxLeft < height[i]) {
                continue;
            }

            // find maxRight
            int maxRight = Integer.MIN_VALUE;
            for (int j = i + 1; j < height.length - 1; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            // core 优化性能
            if (maxRight < height[i]) {
                continue;
            }

            int t = Math.min(maxLeft, maxRight);
            if (height[i] < t) {
                res += (t - height[i]);
            }
        }
        return res;
    }

    // ZTODO 单调栈
    public int trap2(int[] height) {
        return -1;
    }

    // ZTODO 双指针
    public int trap3(int[] height) {
        return -1;
    }
}
