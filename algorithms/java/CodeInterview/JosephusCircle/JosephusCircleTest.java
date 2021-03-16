package CodeInterview.JosephusCircle;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-30
 * Time: 22:38
 */
public class JosephusCircleTest {
    private JosephusCircle josephusCircle = new JosephusCircle();

    @Test
    public void mockLinkedList_test() {
        int result = josephusCircle.mockLinkedList(5, 3);
        Assert.assertEquals(result, 3);
        int result2 = josephusCircle.mockLinkedList(5, 1);
        Assert.assertEquals(result2, 4);
        int result3 = josephusCircle.mockLinkedList(10, 17);
        Assert.assertEquals(result3, 2);
    }

    @Test
    public void recursive_test() {
        int result = josephusCircle.recursive(5, 3);
        Assert.assertEquals(result, 3);
        int result2 = josephusCircle.recursive(5, 1);
        Assert.assertEquals(result2, 4);
        int result3 = josephusCircle.recursive(10, 17);
        Assert.assertEquals(result3, 2);
    }

    @Test
    public void iterate_test() {
        int result = josephusCircle.iterate(5, 3);
        Assert.assertEquals(result, 3);
        int result2 = josephusCircle.iterate(5, 1);
        Assert.assertEquals(result2, 4);
        int result3 = josephusCircle.iterate(10, 17);
        Assert.assertEquals(result3, 2);
    }

    @Test
    public void test() {
        Integer i = 127;
        Integer i2 = 127;
        System.out.println(i  == i2); // true

        Integer i3 = -128;
        Integer i4 = -128;
        System.out.println(i3  == i4); // true

        Integer i5 = 128;
        Integer i6 = 128;
        System.out.println(i5  == i6); // false

        Integer i7 = -129;
        Integer i8 = -129;
        System.out.println(i7  == i8); // false

        Integer j = new Integer(127);
        Integer j2 = new Integer(127);
        System.out.println(j == j2);  // false

        Integer a = 1;
        Double b = 2.0;
        System.out.println(true ? a : b); // 1.0
    }
}
