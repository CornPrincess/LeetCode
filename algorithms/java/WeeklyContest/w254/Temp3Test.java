package WeeklyContest.w254;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhoutianbin
 * @date 2021/3/28 11:33 AM
 */
public class Temp3Test {
    private Temp3 temp3 = new Temp3();

    @Test
    public void test() {
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(new ArrayList<String>(){{add("name");add("bob");}});
        knowledge.add(new ArrayList<String>(){{add("age");add("18");}});
        final String evaluate = temp3.evaluate("aa(name)is(age)yearsold(dd)(name)", knowledge);
        final String evaluate2 = temp3.evaluate("(age)(dd)(name)", knowledge);
        System.out.println(evaluate);
        System.out.println(evaluate2);
    }

}