// Source : https://leetcode-cn.com/problems/employee-importance/
// Author : cornprincess
// Date   : 2021-05-01

/***************************************************************************************************** 
 *
 * You are given a data structure of employee information, which includes the employee's unique id, 
 * their importance value and their direct subordinates' id.
 *
 * For example, employee 1 is the leader of employee 2, and employee 2 is the leader of employee 3. 
 * They have importance value 15, 10 and 5, respectively. Then employee 1 has a data structure like 
 * [1, 15, [2]], and employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although 
 * employee 3 is also a subordinate of employee 1, the relationship is not direct.
 *
 * Now given the employee information of a company, and an employee id, you need to return the total 
 * importance value of this employee and all their subordinates.
 *
 * Example 1:
 *
 * Input: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * Output: 11
 * Explanation:
 * Employee 1 has importance value 5, and he has two direct subordinates: employee 2 and employee 3. 
 * They both have importance value 3. So the total importance value of employee 1 is 5 + 3 + 3 = 11.
 *
 * Note:
 *
 * 	One employee has at most one direct leader and may have several subordinates.
 * 	The maximum number of employees won't exceed 2000.
 ******************************************************************************************************/

package EmployeeImportance;

import java.util.*;

public class EmployeeImportance {
    Map<Integer, Employee> map = new HashMap<>();

    // DFS
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        Employee employee = map.get(id);
        return getImportanceRecur(employee);
    }

    public int getImportanceRecur(Employee employee) {
        int own = employee.importance;
        int subImportances = 0;
        List<Integer> sub = employee.subordinates;
        for (int id : sub) {
            subImportances += getImportanceRecur(map.get(id));
        }
        return own + subImportances;
    }

    // BFS
    public int getImportance2(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee: employees) {
            map.put(employee.id, employee);
        }
        Deque<Employee> queue = new LinkedList<>();
        queue.addLast(map.get(id));
        int ans = 0;
        while (!queue.isEmpty()) {
            Employee employee = queue.pollFirst();
            ans += employee.importance;
            for (int subId: employee.subordinates) {
                queue.addLast(map.get(subId));
            }
        }
        return ans;
    }
}
