package DistributeCandiesToPeople;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-03-05
 * Time: 22:00
 */
public class DistributeCandiesToPeopleTest {
    private int candies = 7;
    private int num_people = 4;
    private int[] expect = {1, 2, 3, 1};
    private DistributeCandiesToPeople solution = new DistributeCandiesToPeople();

    @Test
    public void distributeCandies() {
        int[] result = this.solution.distributeCandies(candies, num_people);
        Assert.assertArrayEquals(expect, result);
    }

    @Test
    public void distributeCandies2() {
        int[] result = this.solution.distributeCandies2(candies, num_people);
        Assert.assertArrayEquals(expect, result);
    }
}
