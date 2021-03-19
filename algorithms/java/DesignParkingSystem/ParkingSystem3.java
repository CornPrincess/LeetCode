package DesignParkingSystem;

/**
 * @author zhoutianbin
 * @date 2021/3/19 11:26 AM
 */

/**
 * 二进制分段
 * 事实上，由于 1000 的二进制表示只有 10位，而 int 有 32 位。
 * <p>
 * 我们可以使用一个 int 配合「位运算」来分段做。
 * <p>
 * 使用 [0,10) 代表 big，[10,20) 表示 medium，使用 [20,30) 表示 small
 * <p>
 * PS. 而这样 int 分段的做法，在工程源码上也有提现：JDK 中的 ThreadPoolExecutor 使用了一个 ctl 变量 (int 类型) 的前 3 位记录线程池的状态，后 29 位记录程池中线程个数。
 * <p>
 * core 这样的「二进制分段压缩存储」的主要目的，不是为了减少使用一个 int，而是为了让「非原子性操作」变为「原子性操作」。
 * <p>
 * 我们可以分析下为什么 ThreadPoolExecutor 要这么做。
 * <p>
 * 当线程数量变化为某个特定值时，要修改的就不仅仅是「线程数量」，还需要修改「线程池的状态」。
 * <p>
 * 由于并发环境下，如果要做到「原子性」地同时需要修改两个 int 的话。只能上「重量级锁」，「重量级锁」就会涉及到「内核态」的系统调用，通常是耗时是「用户态」的上百倍。
 * <p>
 * 但是如果我们将「线程数量」和「线程池的状态」合二为一之后，我们只需要修改一个 int，这时候只需要使用 CAS 做法（用户态）即可保证线程安全与原子性。
 * <p>
 * 那么对应到该题，如果我们允许同时停入不同类型的车，在不引入重量级锁的前提下，想要真正做到「同时」修改两种类型的车的车位的话，只能采用这样的「二进制分段」做法 ~
 * <p>
 * 作者：AC_OIer
 * 链接：https://leetcode-cn.com/problems/design-parking-system/solution/yi-ti-san-jie-jian-dan-bian-liang-ha-xi-0gs72/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class ParkingSystem3 {
    // 使用一个int来表示三个数，每个数占用10位，因为10位二进制最大能表示无符号数为 1023，而题目中表示的最多为1000个
    // [0, 10)：big [10, 20):meduim [20,30):small
    private int cnt = 0;

    public ParkingSystem3(int big, int medium, int small) {
        // 比如 big = 3， meduim = 5，small = 7
        // 3： 00 0000 0011
        // i 表示指针
        // core 通过位运算将三个数放入一个int中
        for (int i = 0; i < 30; i++) {
            // 储存当前二进制的值
            int curr = 0;
            if (i < 10) {
                curr = (big >> i) & 1;
            } else if (i < 20) {
                curr = (medium >> (i - 10)) & 1;
            } else {
                curr = (small >> (i - 20)) & 1;
            }
            cnt += curr == 0 ? 0 : (curr << i);
        }
    }

    public boolean addCar(int carType) {
        int value = countOfType(carType);
        if (value > 0) {
            setCount(carType, value - 1);
            return true;
        }
        return false;
    }

    // big:1 medium:2 small:3
    // core 取出其中一个数
    public int countOfType(int carType) {
        int start = (carType - 1) * 10;
        int end = start + 10;
        int res = 0;
        for (int i = start; i < end; i++) {
            int cur = 0;
            cur = (cnt >> i) & 1;
            res += cur == 0 ? 0 : (cur << (i - start));
        }
        return res;
    }

    // core 对其中一个数重新赋值
    public void setCount(int carType, int value) {
        int start = (carType - 1) * 10;
        int end = start + 10;
        for (int i = start; i < end; i++) {
            int cur = (value >> (i - start)) & 1;
            // core 将某一位置为1，其他位不变，使用或运算
            if (cur == 1) {
                cnt |= cur << i;
            } else {
                // core 将某一位置为0，其他位不变，使用与运算
                cnt &= ~(1 << i);
            }
        }
    }
}
