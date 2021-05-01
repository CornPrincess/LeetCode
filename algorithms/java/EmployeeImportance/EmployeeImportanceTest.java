package EmployeeImportance;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zhoutianbin
 * @date 2021/5/1 10:46 PM
 */
public class EmployeeImportanceTest {
    private EmployeeImportance employeeImportance = new EmployeeImportance();
    private List<Employee> employeeList = new ArrayList<>();

    @Before
    public void init() {
        Employee e1 = new Employee();
        e1.id = 1;
        e1.importance = 5;
        e1.subordinates = new ArrayList<Integer>(){{
            add(2);
            add(3);
        }};
        Employee e2 = new Employee();
        e2.id = 2;
        e2.importance = 3;
        e2.subordinates = new ArrayList<>();
        Employee e3 = new Employee();
        e3.id = 3;
        e3.importance = 3;
        e3.subordinates = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
    }

    @Test
    public void test() {
        int ans = employeeImportance.getImportance(employeeList,1);
        System.out.println(ans);
    }
}