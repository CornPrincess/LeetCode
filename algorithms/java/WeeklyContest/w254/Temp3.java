package WeeklyContest.w254;

import java.util.*;

/**
 * @author zhoutianbin
 * @date 2021/3/28 11:15 AM
 */
/*
 * 5714. 替换字符串中的括号内容 显示英文描述
通过的用户数1209
尝试过的用户数1312
用户总通过次数1215
用户总提交次数1556
题目难度Medium
给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。

比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。

你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：

将 keyi 和括号用对应的值 valuei 替换。
如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。

请你返回替换 所有 括号对后的结果字符串。
 */
public class Temp3 {
    Map<String, String> map = new HashMap<>();
    public String evaluate(String s, List<List<String>> knowledge) {
        if (s == null || s.length() < 3) {
            return s;
        }
        List<Character> key = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        initMap(knowledge);

        boolean isKeyRegion = false;
        // "(name)is(age)yearsold(dd)(name)"
        for (char c: s.toCharArray()) {
            if (c == '(') {
                if (!key.isEmpty()) {
                    sb.append(findValue(key));
                }
                isKeyRegion = true;
                key.clear();
            } else if(c == ')') {
                isKeyRegion = false;
            } else {
                if (!isKeyRegion) {
                    if (!key.isEmpty()) {
                        sb.append(findValue(key));
                        key.clear();
                    }
                    sb.append(c);
                } else {
                    key.add(c);
                }
            }
        }
        if (!key.isEmpty()) {
            sb.append(findValue(key));
        }
        return sb.toString();
    }

    private void initMap(List<List<String>> knowledge) {
        for(List<String> entry: knowledge) {
            map.put(entry.get(0), entry.get(1));
        }
    }

    private String findValue(List<Character> key) {
        StringBuilder sb = new StringBuilder();
        for (char c : key) {
            sb.append(c);
        }
        String keyStr = sb.toString();
        return map.getOrDefault(keyStr, "?");
    }
}
