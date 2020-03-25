package SurfaceAreaOf3dShapes;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-25
 * Time: 23:30
 */
public class SurfaceAreaOf3dShapesTest {
    private SurfaceAreaOf3dShapes surfaceAreaOf3dShapes = new SurfaceAreaOf3dShapes();
    private int[][] testcase = {{2,2,2},{2,1,2},{2,2,2}};

    @Test
    public void surfaceArea() {
        int result = surfaceAreaOf3dShapes.surfaceArea(testcase);
        Assert.assertEquals(result, 46);
    }
}
