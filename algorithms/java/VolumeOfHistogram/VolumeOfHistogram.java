package VolumeOfHistogram;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 4/2/21
 * Time: 11:34 PM
 */
public class VolumeOfHistogram {
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

            // find maxRight
            int maxRight = Integer.MIN_VALUE;
            for (int j = i + 1; j < height.length - 1; j++) {
                if (height[j] > maxRight) {
                    maxRight = height[j];
                }
            }

            int t = Math.min(maxLeft, maxRight);
            if (height[i] < t) {
                res += (t - height[i]);
            }
        }
        return res;
    }
}
